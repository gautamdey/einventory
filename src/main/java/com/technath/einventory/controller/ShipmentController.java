package com.technath.einventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.entity.Test;

@Controller
@RequestMapping(value="/shipment")
public class ShipmentController {
	@PersistenceContext
	protected EntityManager entityManager;

	@RequestMapping(value = "/receiveshipment", method = RequestMethod.GET)
	@Transactional
	public String receiveShipmentGet(Model model) {
		Query query = entityManager.createQuery("select c from InvoiceDO c" );
		List<InvoiceDO> resultList = query.getResultList();

		model.addAttribute("invoices",resultList);

		return "receiveshipment";
	}

	@RequestMapping(value="/getInvoiceItem",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Object getInvoiceItem(@RequestParam("invoiceId")int invoiceId, Model model ){
		Query query = entityManager.createQuery("select c from InvoiceItemDO c where c.invoiceId="+invoiceId );
		List<InvoiceItemDO> resultList = query.getResultList();
		System.out.println("getInvoiceItem is called ");
		return new Test();
	}
	
	
	
	
	@RequestMapping(value = "/checkinshipmentstart", method = RequestMethod.GET)
	@Transactional
	public String checkinShipmentStartGet(Model model) {
		Query query = entityManager.createQuery("select c from InvoiceDO c" );
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("invoices",resultList);
		return "checkinshipmentstart";
	}
	
	@RequestMapping(value = "/checkinshipment", method = RequestMethod.GET)
	@Transactional
	public String checkinShipmentGet(@RequestParam("invoiceId")int invoiceId,Model model) {
		Query query = entityManager.createQuery("select c from InvoiceItemDO c where invoiceid="+invoiceId );
		
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("itemlists",resultList);
		model.addAttribute("invoiceid",invoiceId);
		return "checkinshipment";
	}
}
