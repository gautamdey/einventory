package com.technath.einventory.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//
//'itemid','int(11)','NO','PRI',NULL,''
//'itemocode','varchar(50)','NO','',NULL,''
//'itemname','varchar(50)','YES','',NULL,''
//'desc','varchar(45)','YES','',NULL,''
//'catagoryid','varchar(50)','YES','',NULL,''
//'catalogid','varchar(50)','YES','',NULL,''
//'shippingcost','decimal(10,0)','YES','',NULL,''
//'importduty','decimal(5,0)','YES','',NULL,''
//'shipmentid','int(11)','NO','',NULL,''

@Entity
@Table(name = "tbl_items")
public class ItemDO {
	@Id
	@Column(name = "itemid")
	private int itemId;
	
	@Column(name = "itemcode")
	private String itemCode;
	
	@Column(name = "itemname")
	private String itemName;
	
	@Column(name = "itemdesc")
	private String itemDesc;
	
	@Column(name = "catagoryId")
	private String catagoryId;
	
	@Column(name = "catalogId")
	private String catalogId;

	@Column(name = "shippingcost")
	private BigDecimal shippingCost;

	@Column(name = "importduty")
	private BigDecimal importDuty;


	@Column(name = "shipmentid")
	private long shipmentId;

	@Column(name = "costprice")
	private BigDecimal costPrice;

	public int getItemid() {
		return itemId;
	}


	public void setItemid(int itemId) {
		this.itemId = itemId;
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


	public BigDecimal getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}


	public BigDecimal getImportDuty() {
		return importDuty;
	}


	public void setImportDuty(BigDecimal importDuty) {
		this.importDuty = importDuty;
	}


	public long getShipmentId() {
		return shipmentId;
	}


	public void setShipmentId(long shipmentId) {
		this.shipmentId = shipmentId;
	}




	
	
}

