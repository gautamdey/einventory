package com.technath.einventory.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.dao.ItemDO;
@Controller
public class ItemController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/listitems")
	public String listCatalogy(Model model) {
		Query query = entityManager.createQuery("select c from ItemDO c" );
		List<ItemDO> resultList = query.getResultList();
		for(ItemDO item :resultList){
			System.out.println("Item name::"+ item.getItemName());
		}
		model.addAttribute("items",resultList);
		return "listitems";
	}
	

	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public ModelAndView newItemGet(Model model) {
		return new ModelAndView("additem", "command", new ItemDO());
	}

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public String newItemPost(@ModelAttribute("SpringWeb")ItemDO item, 
			   ModelMap model) {
		entityManager.persist(item);
		entityManager.getTransaction().commit();		
		return "resultnewitem";
	}

	
}
