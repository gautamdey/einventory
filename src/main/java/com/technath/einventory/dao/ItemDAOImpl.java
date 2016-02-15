package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.Supplier;

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

	@Override
	public List<Item> listItemBySupplier(Supplier supplier) {
		List<Item> list = null ;
		Query query = entityManager.createQuery("from Item where supplierId = :supplierId ");
		query.setParameter("supplierId", supplier.getSupplierId());
		list =query.getResultList(); 
		return list;
	}



}
