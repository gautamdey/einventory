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

import com.technath.einventory.dao.CatagoryDO;

@Controller
public class CatagoryController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listcatagory")
	public String listCatalogy(Model model) {

		
//			ListCatalog listCatalog = new ListCatalog();
//			List<CatagoryDO> resultList=		listCatalog.returnAllCatalog();
		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		for(CatagoryDO catagoryItem :resultList){
			System.out.println("catagory name::"+ catagoryItem.getCatagoryName());
		}
		model.addAttribute("catagories",resultList);
		//		ListCatalog listCatalog = new ListCatalog();
		//		listCatalog.returnAllCatalog();
		//		Query query = entityManager.createQuery("select c from CatagoryDO c" );

		return "listcatagory";
	}


	@RequestMapping(value = "/addcatagory", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newCatagoryGet(Model model) {
		return new ModelAndView("addcatagory", "command", new CatagoryDO());
	}

	@RequestMapping(value = "/addcatagory", method = RequestMethod.POST)
	@Transactional
	public String newCatagoryPost(@ModelAttribute("SpringWeb")CatagoryDO catagory, 
			   ModelMap model) {
		entityManager.persist(catagory);
		entityManager.flush(); 
		return "listcatagory";
	}
}
