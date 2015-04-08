package com.technath.einventory.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.entity.CatalogVO;
@Service
public class ListCatalog {
	
	@PersistenceContext(unitName="EINVENTORY_DB_JPA")
//	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<CatagoryDO> returnAllCatalog(){
		Query query = entityManager.createQuery("select c from CatagoryDO c" );
		List<CatagoryDO> resultList = query.getResultList();

		return resultList;
	}

}
