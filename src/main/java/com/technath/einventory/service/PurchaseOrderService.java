package com.technath.einventory.service;

import com.technath.einventory.entity.PurchaseOrder;
import com.technath.einventory.entity.PurchaseOrderItem;

public interface PurchaseOrderService {
	
	public PurchaseOrder findPurchaseOrderById(long purchaseOrderId);
	public void addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception;

}
