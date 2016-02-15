package com.technath.einventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technath.einventory.dao.SupplierDAO;
import com.technath.einventory.entity.Supplier;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierDAO supplierDAO ;
	
	
	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}


	@Override
	public List<com.technath.einventory.entity.Supplier> getAllSuppliers() {
		List<Supplier> itemList = null ;
		itemList = supplierDAO.listSupplier();
		if(itemList==null){
			itemList= new ArrayList<Supplier>();
		}
		return itemList;
	}


	@Override
	public Supplier findSupplierById(long supplierId) {
		Supplier supplier = supplierDAO.findSupplierById(supplierId);
		return supplier;
	}
	
	

}
