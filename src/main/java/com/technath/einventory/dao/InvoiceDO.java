package com.technath.einventory.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_invoice")
public class InvoiceDO {

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


	@Column(name = "suppliername")
	private String supplierName;


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


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
