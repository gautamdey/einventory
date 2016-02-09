package com.technath.einventory.dao;

import java.util.List;

import com.technath.einventory.entity.Item;


public interface ItemDAO{

	public void addItem(Item item);
	public void updateItem(Item item);
	public List<Item> listItem();
	

}


