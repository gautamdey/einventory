package com.technath.einventory.entity;

import java.util.List;

import com.technath.einventory.dao.PurchaseOrderItemDO;

public class ShipmentCheckin {

	private int poId;
	private List<PurchaseOrderItemDO> selectedItems ;
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public List<PurchaseOrderItemDO> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<PurchaseOrderItemDO> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
	
}
