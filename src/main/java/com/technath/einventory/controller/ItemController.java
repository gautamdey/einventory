package com.technath.einventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technath.einventory.entity.Category;
import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.Supplier;
import com.technath.einventory.service.CategoryService;
import com.technath.einventory.service.ItemService;
import com.technath.einventory.service.SupplierService;
@Controller
@RequestMapping(value = "/item")
public class ItemController {
	
	
	protected ItemService itemService;
	protected SupplierService supplierService;
	protected CategoryService categoryService;
	
	
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
 
	@Autowired(required=true)
	@Qualifier(value="supplierService")
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}	
	
	
	
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
	public String newItemGet(Model model) {
		
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		List<Category> categories = categoryService.getAllCategory();
		Item emptyItem = new Item();
		model.addAttribute("command",emptyItem);
		model.addAttribute("suppliers",suppliers);	
		model.addAttribute("categories",categories);	
		return "additem";
	}
	@Transactional
	@RequestMapping(value = "/newitem", method = RequestMethod.POST)
	public String newItemPost(@ModelAttribute("SpringWeb") Item item, 
			ModelMap model) {
		itemService.addItem(item);		
		return "listitem";
	}


}
