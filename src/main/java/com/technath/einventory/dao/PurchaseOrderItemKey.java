package com.technath.einventory.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Embeddable
public class PurchaseOrderItemKey {

//	@Column(name = "itemcode")
	private String itemCode;

//	@Column(name = "poid")
	private String poId;
}
