package com.technath.einventory.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.config.ConstParams;
import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.dao.CatalogDO;
import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.dao.PurchaseOrderDO;
import com.technath.einventory.dao.PurchaseOrderItemDO;
import com.technath.einventory.dao.SupplierDO;

@Controller
@RequestMapping(value = "/purchaseorder")
public class PurchaseOrderController {
	@PersistenceContext
	protected EntityManager entityManager;


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
		List<SupplierDO> resultSupplier = query.getResultList();
		Map< Integer, String > suppliers = new HashMap<Integer,String>();
		for(SupplierDO supplier : resultSupplier){
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
		
		 Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		Map< Integer, String > categories = new HashMap<Integer,String>();
		for(CatagoryDO category : resultList){
			categories.put(new Integer(category.getCatagoryId()), category.getCatagoryName());
		}
		
		query = entityManager.createQuery("select c from CatalogDO c " );
		List<CatalogDO> resultListCatalog = query.getResultList();
		Map< Integer, String > catalogs = new HashMap<Integer,String>();
		for(CatalogDO catelog : resultListCatalog){
			catalogs.put(new Integer(catelog.getCatalogId()), catelog.getCatalogName());
		}
		
			
		model.addAttribute("command",emptyItem);
		model.addAttribute("command",emptyItem);
		model.addAttribute("categories",categories);
		model.addAttribute("catalogs",catalogs);
	
		
//		return new ModelAndView("addinvoiceitem", "command", emptyItem);
		return "addpoitem";
	}

	@RequestMapping(value = "/addpoitem", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newPurchaseOrderItemGet(@ModelAttribute("SpringWeb")PurchaseOrderItemDO item, 
			   ModelMap model) {
		BigDecimal totalCost = item.getCostPrice().add(item.getStitchingCost());
		BigDecimal discount = totalCost.multiply(item.getDiscount()).divide(new BigDecimal(100));
		
		BigDecimal netCost = totalCost.subtract(discount);
		item.setNetCostPrice(netCost);
		entityManager.persist(item);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddpoitem");
		mav.addObject("poId",item.getPo().getPoId());
		return mav;
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
