package com.technath.einventory.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.entity.Category;
import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.PurchaseOrder;
import com.technath.einventory.entity.PurchaseOrderItem;
import com.technath.einventory.entity.Supplier;
import com.technath.einventory.service.CategoryService;
import com.technath.einventory.service.ItemService;
import com.technath.einventory.service.PurchaseOrderService;
import com.technath.einventory.service.SupplierService;

@Controller
@RequestMapping(value = "/purchaseorder")
public class PurchaseOrderController {
	@PersistenceContext
	protected EntityManager entityManager;
	protected CategoryService categoryService;

	protected ItemService itemService;
	
	protected SupplierService supplierService;
	
	protected PurchaseOrderService purchaseOrderService;
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Autowired(required=true)
	@Qualifier(value="supplierService")
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@Autowired(required=true)
	@Qualifier(value="purchaseOrderService")
	public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	
	@RequestMapping("/listpo")
	public String listSupplier(Model model) {

//		Query query = entityManager.createQuery("select  p from PurchaseOrder as p left outer join fetch p.purchaseOrderItems");
		Query query = entityManager.createQuery("select  p from PurchaseOrder as p");
		List<PurchaseOrder> resultList = query.getResultList();
		model.addAttribute("pos",resultList);
		return "listpo";
	}


	@RequestMapping(value = "/addpo", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newPoGet(Model model) {

		Query query = entityManager.createQuery("select c from Supplier c" );
		List<Supplier> resultSupplier = query.getResultList();
		//		Map< Integer, String > suppliers = new HashMap<Integer,String>();
		//		for(Supplier supplier : resultSupplier){
		//			suppliers.put(new Integer(supplier.getSupplierId()), supplier.getSupplierName());
		//		}
		PurchaseOrder emptyItem = new PurchaseOrder();
		model.addAttribute("command",emptyItem);
		model.addAttribute("suppliers",resultSupplier);	
		return new ModelAndView("addpo", "command", new PurchaseOrder());
	}

	@RequestMapping(value = "/addpo", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newPoPost(@ModelAttribute("SpringWeb")PurchaseOrder purchaseOrder, 
			ModelMap model) {
		entityManager.persist(purchaseOrder);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddpo");
		return mav;
	}

	@RequestMapping(value = "/addpoitem", method = RequestMethod.GET)
	@Transactional
	public String newPurchaseOrderItemGet(@RequestParam("poid")long poId,Model model) throws Exception {

		PurchaseOrder po = purchaseOrderService.findPurchaseOrderById(poId);
		PurchaseOrderItem emptyItem = new PurchaseOrderItem();
		emptyItem.setPo(po);
		emptyItem.setUnitCost(new BigDecimal(0));
		List<Item> itemlist = itemService.listItemsBySupplier(po.getSupplier());

		List<Category> resultList = categoryService.getAllCategory();
		Map< Integer, String > categories = new HashMap<Integer,String>();
		for(Category category : resultList){
			categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
		}
		model.addAttribute("poItem",emptyItem);
		model.addAttribute("categories",categories);
		model.addAttribute("items",itemlist);
		return "addpoitem";
	}

	@RequestMapping(value = "/addpoitem", method = RequestMethod.POST)
	@Transactional
	public String newPurchaseOrderItemPost(@ModelAttribute("poItem") @Valid PurchaseOrderItem poItem, 
			Model model) throws Exception {
		purchaseOrderService.addPurchaseOrderItem(poItem);
	
			return "resultaddpoitem";

	}


	@RequestMapping("/viewpodetail")
	public String purchaseOrderDetail(@RequestParam("poid")int poId,Model model) {

		Query query = entityManager.createQuery("select c from PurchaseOrderItem c where c.po.poId="+poId );
		List<PurchaseOrderItem> resultList = query.getResultList();
		model.addAttribute("poitems",resultList);
		model.addAttribute("poid",poId);

		return "viewpodetail";
	}
}
