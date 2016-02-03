package com.technath.einventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.technath.einventory.config.ConstParams;
import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.dao.PurchaseOrderDO;
import com.technath.einventory.dao.PurchaseOrderItemDO;
import com.technath.einventory.dao.StockItemDO;
import com.technath.einventory.entity.ShipmentCheckin;

@Controller
@RequestMapping(value="/shipment")
public class ShipmentController {
	@PersistenceContext
	protected EntityManager entityManager;

//	@RequestMapping(value = "/receiveshipment", method = RequestMethod.GET)
//	@Transactional
//	public String receiveShipmentGet(Model model) {
//		Query query = entityManager.createQuery("select c from PurchaseDO c" );
//		List<PurchaseOrderDO> resultList = query.getResultList();
//		model.addAttribute("pos",resultList);
//		return "receiveshipment";
//	}

//	@RequestMapping(value="/getInvoiceItem",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public  Object getInvoiceItem(@RequestParam("invoiceId")int invoiceId, Model model ){
//		Query query = entityManager.createQuery("select c from InvoiceItemDO c where c.invoiceId="+invoiceId );
//		List<InvoiceItemDO> resultList = query.getResultList();
//		System.out.println("getInvoiceItem is called ");
//		return new Test();
//	}
	
	
	
	
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
	
	@RequestMapping(value = "/checkinshipment", method = RequestMethod.POST)
	@Transactional
	public RedirectView checkinShipmentPost(@ModelAttribute("SpringWeb")ShipmentCheckin shipmentCheckin, 
			   ModelMap model) {
		Query query;
		List<InvoiceItemDO> resultList;
		entityManager.setFlushMode(FlushModeType.COMMIT);
		System.out.println("poId::" + shipmentCheckin.getPoId());
		for (int poItemId :shipmentCheckin.getSelectedItems()){
			System.out.println("itemId::" + poItemId);
			query = entityManager.createQuery("select c from PurchaseOrderItemDO c where po="+poItemId );
			resultList = query.getResultList();
			
			if(resultList!=null){
				InvoiceItemDO item = resultList.get(0);
				System.out.println(item.getItemCode());

				StockItemDO stockItem = new StockItemDO(item);
				entityManager.persist(stockItem);	
				item.setReceived(ConstParams.YES);
				entityManager.merge(item);
				entityManager.flush();
			}
		}

		
//		Query query = entityManager.createQuery("select c from InvoiceItemDO c where invoiceid="+invoiceId );
//		
//		List<InvoiceDO> resultList = query.getResultList();
////		model.addAttribute("command",emptyItem);
		
		return new RedirectView("/shipment/checkinshipmentstart", true);

	}
}
