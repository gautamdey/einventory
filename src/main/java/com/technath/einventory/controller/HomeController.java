package com.technath.einventory.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@PersistenceContext
	protected EntityManager entityManager;


	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		String message = "<br><div align='center'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from EinventoryHelloWorld.java **********<br><br>";
		
		return new ModelAndView("welcome", "message", message);
	}

}
