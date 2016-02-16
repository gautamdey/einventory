package com.technath.einventory.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.technath.einventory.config.ConstParams;
import com.technath.einventory.dao.ItemDAO;
import com.technath.einventory.dao.PurchaseOrderDAO;
import com.technath.einventory.dao.PurchaseOrderItemDAO;
import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.PurchaseOrder;
import com.technath.einventory.entity.PurchaseOrderItem;

public class PurchaseOrderServiceImpl implements PurchaseOrderService{
	@Autowired
	PurchaseOrderDAO purchaseOrderDAO;
	@Autowired
	PurchaseOrderItemDAO purchaseOrderItemDAO;
	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public PurchaseOrder findPurchaseOrderById(long purchaseOrderId) {
		PurchaseOrder purchaseOrder = purchaseOrderDAO.findPurchaseOrderById(purchaseOrderId);
		return purchaseOrder;
	}

	@Override
	public void addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) throws Exception {
		String itemCode = purchaseOrderItem.getItem().getItemCode();
		Item item = itemDAO.findItemOrderItemCode(itemCode);
		if( item == null ){
			throw new Exception("Item code is invalid:"+ itemCode);
		}
		purchaseOrderItem.setItemDesc(item.getItemDesc());
		purchaseOrderItem.setCatagory(item.getCategory());
		purchaseOrderItem.setItemName(item.getItemName());
		purchaseOrderItem.setCatagory(item.getCategory());
		purchaseOrderItem.setReceived(ConstParams.NO);
		purchaseOrderItemDAO.addPoitem(purchaseOrderItem);
		
	}

}
