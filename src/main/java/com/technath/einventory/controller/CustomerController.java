package com.technath.einventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.technath.einventory.dao.CustomerDO;
import com.technath.einventory.dao.InvoiceDO;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping(value = "/listcustomer", method = RequestMethod.GET)
	public String listCatalogy(Model model) {

		Query query = entityManager.createQuery("select c from CustomerDO c" );
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("customers",resultList);

		return "listcustomer";
	}


	@RequestMapping(value = "/updatecustomer", method = RequestMethod.GET)
	@Transactional
	public String updateCustomerGet(@RequestParam("custid")int custId,Model model) {
		Query query = entityManager.createQuery("select c from CustomerDO c where custid="+ custId );
		List<CustomerDO> resultCustomerList = query.getResultList();
		CustomerDO customer = null;
		if(resultCustomerList!=null||resultCustomerList.isEmpty()==false){
			System.out.println("found customer");
			customer= resultCustomerList.get(0);

		}		
		else{
			System.out.println("invalid custid::" + custId);
		}
		model.addAttribute("command",customer);
		return "updatecustomer";
	}

	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	@Transactional
	public ModelAndView updateCustomerePost(@ModelAttribute("SpringWeb")CustomerDO customer, 
			   ModelMap model) {
		entityManager.persist(customer);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultupdatecustomer");
		return mav;
	}
	

	

	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	@Transactional
	public String newCustomerGet( Model model) {
		CustomerDO customer = new CustomerDO();
		model.addAttribute("command",customer);
		return "addcustomer";
	}

	

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoiceItemPost(@ModelAttribute("SpringWeb")CustomerDO customer, 
			   ModelMap model) {
		entityManager.persist(customer);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddcustomer");
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
}
