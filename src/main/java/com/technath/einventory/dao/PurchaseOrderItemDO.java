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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.technath.einventory.entity.Category;

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
	@NotEmpty
	@Size(min = 1, max = 50)
	@Column(name = "itemcode")
	private String itemCode;
	@NotEmpty
	@Size(min = 1, max = 50)
	@Column(name = "itemname")
	private String itemName;

	@Column(name = "itemdesc")
	@Size(min = 0, max = 100)
	private String itemDesc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="catagoryId")
	private Category catagory;
	

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
	
	@Size(min = 0, max = 100)
	@Column(name = "stitchingdetail")
	private String stitchingDetail ;


	@Column(name = "discount")
	private BigDecimal discount ;

	@Column(name = "netcostprice")
	private BigDecimal netCostPrice ;

	@Column(name = "received")
	private String received ;



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public BigDecimal getStitchingCost() {
		return stitchingCost;
	}

	public void setStitchingCost(BigDecimal stitchingCost) {
		this.stitchingCost = stitchingCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseOrderDO getPo() {
		return po;
	}

	public void setPo(PurchaseOrderDO po) {
		this.po = po;
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



	public Category getCatagory() {
		return catagory;
	}

	public void setCatagory(Category catagory) {
		this.catagory = catagory;
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

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}



}
