package com.technath.einventory.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_poitems")
public class PurchaseOrderItemDO {

	public PurchaseOrderItemDO(){
		unitCost = new BigDecimal(0.0);
		stitchingCost = new BigDecimal(0.0);
		costPrice = new BigDecimal(0.0);
		discount= new BigDecimal(0.0);
	}



	@Id
	@Column(name = "itemId")
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

	@Column(name = "unitcost")
	private BigDecimal unitCost;

	@Column(name = "stitchingcost")
	private BigDecimal stitchingCost;

	@Column(name = "costprice")
	private BigDecimal costPrice;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name="poid")
	private PurchaseOrderDO po;

	@Column(name = "embroidery")
	private String embroidery ;

	@Column(name = "stitchingdetail")
	private String stitchingDetail ;


	@Column(name = "discount")
	private BigDecimal discount ;

	@Column(name = "netcostprice")
	private BigDecimal netCostPrice ;




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

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
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
	//	
	//	public PurchaseOrderDO getPo() {
	//		return po;
	//	}
	//
	//	public void setPo(PurchaseOrderDO po) {
	//		this.po = po;
	//	}



}
