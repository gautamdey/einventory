package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public void addItem(Item item) {
		entityManager.persist(item);

	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> listItem() {
		List<Item> list = null ;
		if(entityManager!=null){
			list = entityManager.createQuery("from Item").getResultList();
		}
		else{
			System.out.println("entity manager is null");
		}
		return list;
	}

}
