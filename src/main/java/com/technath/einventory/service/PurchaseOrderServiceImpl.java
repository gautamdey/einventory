package com.technath.einventory.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.technath.einventory.dao.PurchaseOrderDAO;
import com.technath.einventory.entity.PurchaseOrder;

public class PurchaseOrderServiceImpl implements PurchaseOrderService{
	@Autowired
	PurchaseOrderDAO purchaseOrderDAO;
	
	@Override
	public PurchaseOrder findPurchaseOrderById(long purchaseOrderId) {
		PurchaseOrder purchaseOrder = purchaseOrderDAO.findPurchaseOrderById(purchaseOrderId);
		return purchaseOrder;
	}

}
