package com.technath.einventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.PurchaseOrderDO;
import com.technath.einventory.dao.SupplierDO;

@Controller
public class PurchaseOrderController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listpo")
	public String listSupplier(Model model) {

		Query query = entityManager.createQuery("select  p from PurchaseOrderDO as p left outer join fetch p.purchaseOrderItems");
		List<PurchaseOrderDO> resultList = query.getResultList();
		model.addAttribute("pos",resultList);
		return "listpo";
	}


	@RequestMapping(value = "/addpo", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newPoGet(Model model) {
		
		Query query = entityManager.createQuery("select c from SupplierDO c" );
		List<SupplierDO> resultSupplier = query.getResultList();
		Map< Integer, String > suppliers = new HashMap<Integer,String>();
		for(SupplierDO supplier : resultSupplier){
			suppliers.put(new Integer(supplier.getSupplierId()), supplier.getSupplierName());
		}
		PurchaseOrderDO emptyItem = new PurchaseOrderDO();
		model.addAttribute("command",emptyItem);
		model.addAttribute("suppliers",suppliers);	
		return new ModelAndView("addpo", "command", new PurchaseOrderDO());
	}

	@RequestMapping(value = "/addpo", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newPoPost(@ModelAttribute("SpringWeb")PurchaseOrderDO purchaseOrder, 
			   ModelMap model) {
		entityManager.persist(purchaseOrder);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddpo");
		return mav;
	}

}
