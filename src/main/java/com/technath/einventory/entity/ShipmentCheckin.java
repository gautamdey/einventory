package com.technath.einventory.entity;

import java.util.List;

public class ShipmentCheckin {

	private int poId;
	private List<PurchaseOrderItem> selectedItems ;

	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public List<PurchaseOrderItem> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<PurchaseOrderItem> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
	
}
