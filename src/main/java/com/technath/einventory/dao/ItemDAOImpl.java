package com.technath.einventory.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technath.einventory.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	protected EntityManager localEntityManager;
	@Override
	public void addItem(Item item) {
		localEntityManager.persist(item);
		
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> listItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
