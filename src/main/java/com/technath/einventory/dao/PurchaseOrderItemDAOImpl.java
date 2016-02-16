package com.technath.einventory.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.PurchaseOrderItem;
@Repository
public class PurchaseOrderItemDAOImpl implements PurchaseOrderItemDAO {
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public void addPoitem(PurchaseOrderItem poItem) {
		entityManager.persist(poItem);
		entityManager.flush();
		
	}

}
