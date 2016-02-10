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

import com.technath.einventory.dao.PurchaseOrderDO;
import com.technath.einventory.dao.PurchaseOrderItemDO;
import com.technath.einventory.entity.Category;
import com.technath.einventory.entity.Supplier;
import com.technath.einventory.service.CategoryService;

@Controller
@RequestMapping(value = "/purchaseorder")
public class PurchaseOrderController {
	@PersistenceContext
	protected EntityManager entityManager;
protected CategoryService categoryService;
	
	
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping("/listpo")
	public String listSupplier(Model model) {

		Query query = entityManager.createQuery("select  p from PurchaseOrderDO as p left outer join fetch p.purchaseOrderItems");
		List<PurchaseOrderDO> resultList = query.getResultList();
		model.addAttribute("pos",resultList);
		return "listpo";
	}


	@RequestMapping(value = "/addpo", method = RequestMethod.GET)
	@Transactional
	public ModelAndView newPoGet(Model model) {

		Query query = entityManager.createQuery("select c from SupplierDO c" );
		List<Supplier> resultSupplier = query.getResultList();
		Map< Integer, String > suppliers = new HashMap<Integer,String>();
		for(Supplier supplier : resultSupplier){
			suppliers.put(new Integer(supplier.getSupplierId()), supplier.getSupplierName());
		}
		PurchaseOrderDO emptyItem = new PurchaseOrderDO();
		model.addAttribute("command",emptyItem);
		model.addAttribute("suppliers",suppliers);	
		return new ModelAndView("addpo", "command", new PurchaseOrderDO());
	}

	@RequestMapping(value = "/addpo", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newPoPost(@ModelAttribute("SpringWeb")PurchaseOrderDO purchaseOrder, 
			ModelMap model) {
		entityManager.persist(purchaseOrder);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddpo");
		return mav;
	}

	@RequestMapping(value = "/addpoitem", method = RequestMethod.GET)
	@Transactional
	public String newPurchaseOrderItemGet(@RequestParam("poid")int poId,Model model) throws Exception {

		PurchaseOrderDO po = new PurchaseOrderDO(); 
		po.setPoId(poId);


		PurchaseOrderItemDO emptyItem = new PurchaseOrderItemDO();
		emptyItem.setPo(po);
		emptyItem.setUnitCost(new BigDecimal(0));

		List<Category> resultList = categoryService.getAllCategory();
		Map< Integer, String > categories = new HashMap<Integer,String>();
		for(Category category : resultList){
			categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
		}


		model.addAttribute("poItem",emptyItem);
		model.addAttribute("categories",categories);


		//		return new ModelAndView("addinvoiceitem", "command", emptyItem);
		return "addpoitem";
	}

	@RequestMapping(value = "/addpoitem", method = RequestMethod.POST)
	@Transactional
	public String newPurchaseOrderItemPost(@ModelAttribute("poItem") @Valid PurchaseOrderItemDO poItem, 
			BindingResult result,Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().size());
//			model.addAttribute("poItem",item);
			List<Category> resultList = categoryService.getAllCategory();
			Map< Integer, String > categories = new HashMap<Integer,String>();
			for(Category category : resultList){
				categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
			}
			model.addAttribute("categories",categories);
			
			return "addpoitem";
		} else{
			entityManager.persist(poItem);
			entityManager.flush(); 
			ModelAndView mav = new ModelAndView();
			mav.setViewName("resultaddpoitem");
			mav.addObject("poId",poItem.getPo().getPoId());
			return "resultaddpoitem";
		}
	}


	@RequestMapping("/viewpodetail")
	public String purchaseOrderDetail(@RequestParam("poid")int poId,Model model) {

		Query query = entityManager.createQuery("select c from PurchaseOrderItemDO c where c.po.poId="+poId );
		List<PurchaseOrderItemDO> resultList = query.getResultList();
		model.addAttribute("poitems",resultList);
		model.addAttribute("poid",poId);

		return "viewpodetail";
	}
}
