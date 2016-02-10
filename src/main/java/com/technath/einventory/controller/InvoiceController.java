package com.technath.einventory.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.technath.einventory.config.ConstParams;
import com.technath.einventory.dao.CatalogDO;
import com.technath.einventory.dao.InvoiceDO;
import com.technath.einventory.dao.InvoiceItemDO;
import com.technath.einventory.entity.Category;
import com.technath.einventory.entity.Supplier;

@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping(value = "/listinvoice", method = RequestMethod.GET)
	public String listCatalogy(Model model) {

		Query query = entityManager.createQuery("select c from InvoiceDO c" );
		List<InvoiceDO> resultList = query.getResultList();
		model.addAttribute("invoices",resultList);

		return "listinvoice";
	}


	@RequestMapping(value = "/addinvoice", method = RequestMethod.GET)
	@Transactional
	public String newInvoiceGet(Model model) {
		Query query = entityManager.createQuery("select c from SupplierDO c" );
		List<Supplier> resultSupplier = query.getResultList();
		Map< Integer, String > suppliers = new HashMap<Integer,String>();
		for(Supplier supplier : resultSupplier){
			suppliers.put(new Integer(supplier.getSupplierId()), supplier.getSupplierName());
		}
		InvoiceDO emptyItem = new InvoiceDO();

		
		model.addAttribute("command",emptyItem);
		model.addAttribute("suppliers",suppliers);
		return "addinvoice";
	}

	@RequestMapping(value = "/addinvoice", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoicePost(@ModelAttribute("SpringWeb")InvoiceDO invoice, 
			   ModelMap model) {
		entityManager.persist(invoice);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddinvoice");

		Query query = entityManager.createQuery("select c from InvoiceDO c where c.invoiceNum='"+invoice.getInvoiceNum() +"'" );
		List<InvoiceDO> resultList = query.getResultList();
		if ( resultList!=null && resultList.isEmpty()==false){
			InvoiceDO resultDO = resultList.get(0);
			System.out.println("found the new invoice::" + resultDO.getInvoiceId());
//			model.addAttribute("invoiceId",resultDO.getInvoiceId());
			mav.addObject("invoiceId",resultDO.getInvoiceId());
		}	
		else{
			System.out.println("did not found the new invoice");
		}
		return mav;
	}
	


	@RequestMapping(value = "/addinvoiceitem", method = RequestMethod.GET)
	@Transactional
	public String newInvoiceItemGet(@RequestParam("invoiceid")int invoiceId,Model model) throws Exception {
		Query query = entityManager.createQuery("select c from InvoiceDO c " );
		List<InvoiceDO> invoiceList = query.getResultList();
		if ( invoiceList==null || invoiceList.isEmpty()==true){
		  throw new Exception("not a valid invoiceid");
		}
		
		InvoiceDO invoiceDO = invoiceList.get(0);
		int itemCount = invoiceDO.getItemCount();
		BigDecimal shippingCost = invoiceDO.getShippingCost();
		BigDecimal shippingCostPerItem = new BigDecimal(0.0);
//		shippingCostPerItem.setScale(0, RoundingMode.CEILING);
		System.out.println("shippingCost::" +shippingCost + " itemCount:: " +itemCount);
		if( shippingCost!=null){
			shippingCostPerItem = shippingCost.divide(new BigDecimal(itemCount),0,RoundingMode.CEILING);
			System.out.println("shippingCostPerItem::" +shippingCostPerItem );
		}

		InvoiceItemDO emptyItem = new InvoiceItemDO();
		emptyItem.setInvoiceId(invoiceId);
		emptyItem.setShippingCost(shippingCostPerItem);
		
		 query = entityManager.createQuery("select c from Category c" );
		List<Category> resultList = query.getResultList();
		Map< Integer, String > categories = new HashMap<Integer,String>();
		for(Category category : resultList){
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
		return "addinvoiceitem";
	}

	@RequestMapping(value = "/addinvoiceitem", method = RequestMethod.POST)
	@Transactional
	public ModelAndView newInvoiceItemPost(@ModelAttribute("SpringWeb")InvoiceItemDO item, 
			   ModelMap model) {
		BigDecimal netCost = item.getCostPrice().subtract(item.getCostPrice().divide(new BigDecimal(100.00)).multiply(item.getDiscount())).add(item.getShippingCost()).add(item.getAdditionalCost());
		item.setNetCostPrice(netCost);
		item.setReceived(ConstParams.NO);
		entityManager.persist(item);
		entityManager.flush(); 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resultaddinvoiceitem");
		mav.addObject("invoiceId",item.getInvoiceId());
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping("/viewinvoicedetail")
	public String invoiceDetail(@RequestParam("invoiceid")int invoiceId,Model model) {

		Query query = entityManager.createQuery("select c from InvoiceItemDO c where c.invoiceId="+invoiceId );
		List<InvoiceItemDO> resultList = query.getResultList();
		model.addAttribute("invoiceitems",resultList);
		model.addAttribute("invoiceid",invoiceId);

		return "viewinvoicedetail";
	}
	
	
}
