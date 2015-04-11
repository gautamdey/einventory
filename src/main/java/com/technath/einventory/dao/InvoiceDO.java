package com.technath.einventory.dao;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "tbl_invoice")
public class InvoiceDO {
	
	public InvoiceDO(){
		supplierId=0;
		invoiceDate = new Date();
		importduty = new BigDecimal(0.0);
		shippingCost=new BigDecimal(0.0);
		netAmount = new BigDecimal(0.0);
		
	}

	@Id
	@Column(name = "invoiceid")
	private int invoiceId;
	@Column(name = "invoicenum")
	private String invoiceNum;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "invoicedate")
	private Date invoiceDate;

	@Column(name = "supplierid")
	private int supplierId;

	@Column(name = "importduty")
	private BigDecimal importduty;
	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "shippingcost")
	private BigDecimal shippingCost;

	@Column(name = "itemcount")
	private Integer itemCount;
	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "netamount")
	private BigDecimal netAmount;

	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public String getInvoiceNum() {
		return invoiceNum;
	}


	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}


	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public BigDecimal getImportduty() {
		return importduty;
	}


	public void setImportduty(BigDecimal importduty) {
		this.importduty = importduty;
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
	
}
