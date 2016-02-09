package com.technath.einventory.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.technath.einventory.dao.CatagoryDO;
import com.technath.einventory.dao.SupplierDO;

@Entity
@Table(name = "tbl_item_master")
public class Item {
	@Id
	@Column(name = "itemid")
	private int itemId;
	
	@Column(name = "itemcode")
	private String itemCode;
	
	@Column(name = "itemname")
	private String itemName;
	
	@Column(name = "itemdesc")
	private String itemDesc;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryId")
	private CatagoryDO category;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="supplierId")
	private SupplierDO supplier;
	
	@Column(name = "catalogId")
	private String catalogId;


	
	
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





	public CatagoryDO getCategory() {
		return category;
	}


	public void setCategory(CatagoryDO category) {
		this.category = category;
	}





	public String getCatalogId() {
		return catalogId;
	}


	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}


	public BigDecimal getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}


	public SupplierDO getSupplier() {
		return supplier;
	}


	public void setSupplier(SupplierDO supplier) {
		this.supplier = supplier;
	}


}