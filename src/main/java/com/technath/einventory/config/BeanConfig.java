package com.technath.einventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.technath.einventory.service.ItemService;
import com.technath.einventory.service.ItemServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.technath.einventory.dao" ,"com.technath.einventory.service","com.technath.einventory.entity"})
public class BeanConfig {

	@Bean(name = "itemService")
	public ItemService getItemService() {
		
		ItemService itemService = new ItemServiceImpl();
		return itemService;
	}

}
