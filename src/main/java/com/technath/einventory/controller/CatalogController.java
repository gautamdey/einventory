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

import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.dao.CatalogDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.dao.ItemDO;
import com.technath.einventory.service.ListCatalog;

@Controller
public class CatalogController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listcatalog")
	public String listCatalogy(Model model) {

		

		Query query = entityManager.createQuery("select c from CatalogDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		model.addAttribute("catalogs",resultList);

		return "listcatalog";
	}


	@RequestMapping(value = "/addcatalog", method = RequestMethod.GET)
	@Transactional
	public String newCatalogGet(Model model) {
		CatalogDO emptyCatagoryDO = new CatalogDO();
		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		Map< Integer, String > categories = new HashMap();
		for(CatagoryDO category : resultList){
			categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
			System.out.print(category.getCatagoryId());
		}
		model.addAttribute("categories",categories);
		model.addAttribute("command",emptyCatagoryDO);
		return "addcatalog";
	}

	@RequestMapping(value = "/addcatalog", method = RequestMethod.POST)
	@Transactional
	public String newCatalogPost(@ModelAttribute("SpringWeb")CatalogDO catalog, 
			   ModelMap model) {
		entityManager.persist(catalog);
		entityManager.flush(); 
		return "resultaddcatalog";
	}
}
