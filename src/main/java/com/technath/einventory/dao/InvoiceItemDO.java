package com.technath.einventory.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_invoice_items")
public class InvoiceItemDO {
	@Id
	@Column(name = "itemcode")
	private String itemCode;
	
	@Column(name = "itemname")
	private String itemName;
	
	@Column(name = "itemdesc")
	private String itemDesc;
	
	@Column(name = "catagoryid")
	private String catagoryId;
	
	@Column(name = "catalogid")
	private String catalogId;

	@Column(name = "shippingcost")
	private BigDecimal shippingCost;

	@Column(name = "importduty")
	private BigDecimal importDuty;

	@Column(name = "costprice")
	private BigDecimal costPrice;
	
	@Column(name = "invoiceid")
	private int invoiceId;


	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(String catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public BigDecimal getImportDuty() {
		return importDuty;
	}

	public void setImportDuty(BigDecimal importDuty) {
		this.importDuty = importDuty;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	
}
