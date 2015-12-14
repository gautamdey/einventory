package com.technath.einventory.dao;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "tbl_purchaseorder")
public class PurchaseOrderDO {
	
	public PurchaseOrderDO(){
		supplierId=0;
		poDate = new Date();
		importDuty = new BigDecimal(0.0);
		shippingCost=new BigDecimal(0.0);
		netAmount = new BigDecimal(0.0);
		
	}

	@Id
	@Column(name = "poid")
	private int poId;
	
	@Column(name = "ponum")
	private String poNum;
	
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "podate")
	private Date poDate;

	@Column(name = "supplierid")
	private int supplierId;

	@Column(name = "importduty")
	private BigDecimal importDuty;
	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "shippingcost")
	private BigDecimal shippingCost;

	@Column(name = "itemcount")
	private Integer itemCount;
	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "netamount")
	private BigDecimal netAmount;

	 @OneToMany(mappedBy="po")
	private Set<PurchaseOrderItemDO> purchaseOrderItems = new HashSet<PurchaseOrderItemDO>(
			0);

	public int getPoId() {
		return poId;
	}


	public void setPoId(int poId) {
		this.poId = poId;
	}


	public String getPoNum() {
		return poNum;
	}


	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}


	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}


	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}




	public BigDecimal getImportDuty() {
		return importDuty;
	}


	public void setImportDuty(BigDecimal importDuty) {
		this.importDuty = importDuty;
	}


	public BigDecimal getShippingCost() {
		return shippingCost;
	}


	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}


	public int getItemCount() {
		if(itemCount==null){
			return 0;
		}
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


	public BigDecimal getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbl_purchaseorder")
	public Set<PurchaseOrderItemDO> getPurchaseOrderItems() {
		return purchaseOrderItems;
	}


	public void setPurchaseOrderItems(Set<PurchaseOrderItemDO> purchaseOrderItems) {
		this.purchaseOrderItems = purchaseOrderItems;
	}


	
	
	
}
