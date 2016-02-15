package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO{
	@PersistenceContext
	protected EntityManager entityManager;
	@Override
	public List<Supplier> listSupplier() {
		List<Supplier> list = null ;
		list = entityManager.createQuery("from Supplier").getResultList();
		return list;
	}
	@Override
	public Supplier findSupplierById(long supplierId) {
		Supplier s = entityManager.getReference(Supplier.class, supplierId);
		return s;
	}

}
