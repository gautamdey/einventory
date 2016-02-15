package com.technath.einventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.technath.einventory.service.CategoryService;
import com.technath.einventory.service.CategoryServiceImpl;
import com.technath.einventory.service.ItemService;
import com.technath.einventory.service.ItemServiceImpl;
import com.technath.einventory.service.PurchaseOrderService;
import com.technath.einventory.service.PurchaseOrderServiceImpl;
import com.technath.einventory.service.SupplierService;
import com.technath.einventory.service.SupplierServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.technath.einventory.dao" ,"com.technath.einventory.service","com.technath.einventory.entity"})
public class BeanConfig {

	@Bean(name = "itemService")
	public ItemService getItemService() {
		
		ItemService itemService = new ItemServiceImpl();
		return itemService;
	}

	@Bean(name = "supplierService")
	public SupplierService getSupplierService() {
		
		SupplierService supplierService = new SupplierServiceImpl();
		return supplierService;
	}
	@Bean(name = "categoryService")
	public CategoryService getCategoryService() {
		
		CategoryService categoryService = new CategoryServiceImpl();
		return categoryService;
	}
	@Bean(name = "purchaseOrderService")
	public PurchaseOrderService getPurchaseOrderService() {
		
		PurchaseOrderService purchaseOrderService = new PurchaseOrderServiceImpl();
		return purchaseOrderService;
	}
}
