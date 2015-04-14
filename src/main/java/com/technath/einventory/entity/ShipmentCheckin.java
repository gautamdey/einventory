package com.technath.einventory.entity;


public class ShipmentCheckin {

	private int invoiceId;
	private String[] selectedItems ;
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String[] getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(String[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	
	
}
