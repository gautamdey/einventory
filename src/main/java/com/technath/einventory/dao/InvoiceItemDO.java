package com.technath.einventory.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_invoice_items")
public class InvoiceItemDO {
	
	public InvoiceItemDO(){
		shippingCost = new BigDecimal(0.0);
		additionalCost = new BigDecimal(0.0);
		costPrice = new BigDecimal(0.0);
		discount= new BigDecimal(0.0);
	}
	
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

	@Column(name = "additionalcost")
	private BigDecimal additionalCost;

	@Column(name = "costprice")
	private BigDecimal costPrice;
	
	@Column(name = "invoiceid")
	private int invoiceId;

	@Column(name = "color")
	private String color ;
	
	@Column(name = "embroidery")
	private String embroidery ;
	
	@Column(name = "stitching")
	private BigDecimal stitching ;

	@Column(name = "stitchingdetail")
	private String stitchingDetail ;
	

	@Column(name = "discount")
	private BigDecimal discount ;
	
	@Column(name = "netcostprice")
	private BigDecimal netCostPrice ;
	
	@Column(name = "received")
	private String received;
	
	
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


	public BigDecimal getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(BigDecimal additionalCost) {
		this.additionalCost = additionalCost;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEmbroidery() {
		return embroidery;
	}

	public void setEmbroidery(String embroidery) {
		this.embroidery = embroidery;
	}



	public String getStitchingDetail() {
		return stitchingDetail;
	}

	public void setStitchingDetail(String stitchingDetail) {
		this.stitchingDetail = stitchingDetail;
	}

	public BigDecimal getStitching() {
		return stitching;
	}

	public void setStitching(BigDecimal stitching) {
		this.stitching = stitching;
	}


	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getNetCostPrice() {
		return netCostPrice;
	}

	public void setNetCostPrice(BigDecimal netCostPrice) {
		this.netCostPrice = netCostPrice;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}
	
}
