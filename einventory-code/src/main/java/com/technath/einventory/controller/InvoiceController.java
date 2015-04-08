package com.technath.einventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.dao.ItemDO;
import com.technath.einventory.service.ListCatalog;

@Controller
public class InvoiceController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listinvoice")
	public String listCatalogy(Model model) {

		Query query = entityManager.createQuery("select c from InvoiceDO c" );
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("invoices",resultList);

		return "listinvoice";
	}


	@RequestMapping(value = "/addinvoice", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newInvoiceGet(Model model) {
		return new ModelAndView("addinvoice", "command", new InvoiceDO());
	}

	@RequestMapping(value = "/addinvoice", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoicePost(@ModelAttribute("SpringWeb")InvoiceDO invoice, 
			   ModelMap model) {
		entityManager.persist(invoice);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddinvoice");

		Query query = entityManager.createQuery("select c from InvoiceDO c where c.invoiceNum='"+invoice.getInvoiceNum() +"'" );
		List<InvoiceDO> resultList = query.getResultList();
		if ( resultList!=null && resultList.isEmpty()==false){
			InvoiceDO resultDO = resultList.get(0);
			System.out.println("found the new invoice::" + resultDO.getInvoiceId());
//			model.addAttribute("invoiceId",resultDO.getInvoiceId());
			mav.addObject("invoiceId",resultDO.getInvoiceId());
		}	
		else{
			System.out.println("did not found the new invoice");
		}
		return mav;
	}
	


	@RequestMapping(value = "/addinvoiceitem", method = RequestMethod.GET)
	@Transactional
	public String newInvoiceItemGet(@RequestParam("invoiceid")int invoiceId,Model model) {
		InvoiceItemDO emptyItem = new InvoiceItemDO();
		emptyItem.setInvoiceId(invoiceId);
		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		Map< Integer, String > categories = new HashMap();
		for(CatagoryDO category : resultList){
			categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
		}
		model.addAttribute("command",emptyItem);
		model.addAttribute("categories",categories);
//		return new ModelAndView("addinvoiceitem", "command", emptyItem);
		return "addinvoiceitem";
	}

	@RequestMapping(value = "/addinvoiceitem", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoiceItemPost(@ModelAttribute("SpringWeb")InvoiceItemDO item, 
			   ModelMap model) {
		entityManager.persist(item);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddinvoiceitem");
		mav.addObject("invoiceId",item.getInvoiceId());
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
