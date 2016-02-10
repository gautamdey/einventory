package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.Category;
import com.technath.einventory.entity.Item;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> listCategory() {
		List<Category> list = null ;
		if(entityManager!=null){
			list = entityManager.createQuery("from Category").getResultList();
		}
		else{
			System.out.println("entity manager is null");
		}
		return list;
	}

}
