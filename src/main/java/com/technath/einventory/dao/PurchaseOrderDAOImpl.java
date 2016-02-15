package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.PurchaseOrder;
@Repository
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO{
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<PurchaseOrder> listAllPurchaseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PurchaseOrder findPurchaseOrderById(long purchaseOrderId) {
		PurchaseOrder po = entityManager.getReference(PurchaseOrder.class, purchaseOrderId);
		return po;
	}
	

}
