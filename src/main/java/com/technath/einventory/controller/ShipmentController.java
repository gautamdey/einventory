package com.technath.einventory.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.technath.einventory.config.ConstParams;
import com.technath.einventory.dao.PurchaseOrderDO;
import com.technath.einventory.dao.PurchaseOrderItemDO;
import com.technath.einventory.dao.StockItemDO;
import com.technath.einventory.entity.ShipmentCheckin;

@Controller
@RequestMapping(value="/shipment")
public class ShipmentController {
	@PersistenceContext
	protected EntityManager entityManager;	
	@org.springframework.beans.factory.annotation.Autowired
	private static final  String YES = "N";
	@RequestMapping(value = "/checkinshipmentstart", method = RequestMethod.GET)
	@Transactional
	public String checkinShipmentStartGet(Model model) {
		Query query = entityManager.createQuery("select c from PurchaseOrderDO c" );
		List<PurchaseOrderDO> resultList = query.getResultList();
		model.addAttribute("pos",resultList);
		return "checkinshipmentstart";
	}

	@RequestMapping(value = "/checkinshipment", method = RequestMethod.GET)
	@Transactional
	public String checkinShipmentGet(@RequestParam("poId")int poId,Model model) {
		Query query = entityManager.createQuery("select c from PurchaseOrderItemDO c where poid="+poId +" and received='N'");
		System.out.println("inside checkinShipmentGet");
		List<PurchaseOrderItemDO> resultList = query.getResultList();
		ShipmentCheckin checkinForm = new ShipmentCheckin();
		checkinForm.setPoId(poId);
		model.addAttribute("command",new ShipmentCheckin());
		model.addAttribute("itemlists",resultList);
		model.addAttribute("poId",poId);
		return "checkinshipment";
	}

	@RequestMapping(value = "/receiveshipment", method = RequestMethod.POST)
	@Transactional
	public String checkinShipmentPost(@RequestParam("poId")int poId, @RequestParam("selectedItems")String[] selectedItems,
			Model model) {
		System.out.println("receiveshipment is called ");
		entityManager.setFlushMode(FlushModeType.COMMIT);
		System.out.println("poId::" + poId);
		System.out.println("selectedItems" + selectedItems);
		for (String poItemId :selectedItems){
			System.out.println("itemId::" + poItemId);
			PurchaseOrderItemDO poItem = (PurchaseOrderItemDO) entityManager.find(PurchaseOrderItemDO.class, Integer.parseInt(poItemId));
			System.out.println("received::"+poItem.getReceived());
			poItem.setReceived(ConstParams.YES);
			StockItemDO stockItem = new StockItemDO(poItem); 
			entityManager.merge(poItem);
			entityManager.persist(stockItem);
		}
		entityManager.flush();
		return "checkinshipmentstart";
		//		
	}

}
