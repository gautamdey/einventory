package com.technath.einventory.dao;

import java.util.List;

import com.technath.einventory.entity.PurchaseOrder;

public interface PurchaseOrderDAO {
	
	public List<PurchaseOrder> listAllPurchaseOrder();
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);
	public PurchaseOrder findPurchaseOrderById(long purchaseOrderId);
	

}
