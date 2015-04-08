package com.technath.einventory.controller;

import java.util.List;

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
import com.technath.einventory.dao.SupplierDO;

@Controller
public class SupplierController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listsupplier")
	public String listSupplier(Model model) {

		Query query = entityManager.createQuery("select c from SupplierDO c" );
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("suppliers",resultList);

		return "listsuppliers";
	}


	@RequestMapping(value = "/addsupplier", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newSupplierGet(Model model) {
		return new ModelAndView("addsupplier", "command", new SupplierDO());
	}

	@RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoicePost(@ModelAttribute("SpringWeb")SupplierDO supplier, 
			   ModelMap model) {
		entityManager.persist(supplier);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddsupplier");
		return mav;
	}

}
