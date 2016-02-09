package com.technath.einventory.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.entity.Item;
import com.technath.einventory.service.ItemService;
@Controller
@RequestMapping(value = "/item")
public class ItemController {
	@PersistenceContext
	protected EntityManager entityManager;
	protected ItemService itemService;


	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}	 


	@RequestMapping("/listitem")
	public String listCatalogy(Model model) {
		List<Item> resultList = itemService.listItems();
		model.addAttribute("items",resultList);
		return "listitem";
	}


	@RequestMapping(value = "/newitem", method = RequestMethod.GET)
	public ModelAndView newItemGet(Model model) {
		return new ModelAndView("additem", "command", new Item());
	}

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public String newItemPost(@ModelAttribute("SpringWeb")Item item, 
			ModelMap model) {
		itemService.addItem(item);		
		return "listitem";
	}


}
