package com.technath.einventory.service;

import java.util.List;

import com.technath.einventory.entity.Supplier;

public interface SupplierService {
	
	public List<Supplier> getAllSuppliers();
	public Supplier findSupplierById(long supplierId);

}
