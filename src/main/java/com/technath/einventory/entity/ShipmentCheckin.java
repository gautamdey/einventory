package com.technath.einventory.entity;


public class ShipmentCheckin {

	private int invoiceId;
	private int[] selectedItems ;
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int[] getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(int[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	
	
}
