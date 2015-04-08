package com.technath.einventory.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.service.ListCatalog;

@Controller
public class EinventoryHelloWorld {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div align='center'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from EinventoryHelloWorld.java **********<br><br>";
		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();
		for(CatagoryDO catagoryItem :resultList){
			System.out.println("catagory name::"+ catagoryItem.getCatagoryName());
		}
//		ListCatalog listCatalog = new ListCatalog();
//		listCatalog.returnAllCatalog();
//		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		
		return new ModelAndView("welcome", "message", message);
	}

}
