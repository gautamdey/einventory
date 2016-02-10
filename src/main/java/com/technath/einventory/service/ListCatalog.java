package com.technath.einventory.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.technath.einventory.entity.Category;
@Service
public class ListCatalog {
	
	@PersistenceContext(unitName="EINVENTORY_DB_JPA")
//	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Category> returnAllCatalog(){
		Query query = entityManager.createQuery("select c from Category c" );
		List<Category> resultList = query.getResultList();

		return resultList;
	}

}
