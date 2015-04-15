package com.technath.einventory.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_stock_item")
public class StockItemDO {

	public StockItemDO(){
		shippingCost = new BigDecimal(0.0);
		additionalCost = new BigDecimal(0.0);
		costPrice = new BigDecimal(0.0);
		totalCost = new BigDecimal(0.0);
		
	}
	public StockItemDO(InvoiceItemDO item){
		this.additionalCost=item.getAdditionalCost();
		this.catagoryId= item.getCatagoryId();
		this.catalogId = item.getCatalogId();
		this.costPrice = item.getCostPrice();
		this.invoiceId = item.getInvoiceId();
		this.itemCode = item.getItemCode();
		this.itemDesc = item.getItemDesc();
		this.itemName= item.getItemName();
		this.shippingCost = item.getShippingCost();
		this.stockDate = new Date();
		this.totalCost = new BigDecimal(0.0);
		this.totalCost = item.getNetCostPrice();
		this.color= item.getColor();
		this.embroidery= item.getEmbroidery();
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "stockid")
	private int stockId;
	
	@Column(name = "itemid")
	private int itemId;


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

	@Column(name = "totalcost")
	private BigDecimal totalCost;

	@Column(name = "suppliername")
	private int supplierName;

	@Column(name = "invoiceid")
	private int invoiceId;

	@Column(name = "stockdate")
	private Date stockDate;

	@Column(name = "color")
	private String color ;
	
	@Column(name = "embroidery")
	private String embroidery ;
	
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

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public int getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(int supplierName) {
		this.supplierName = supplierName;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
