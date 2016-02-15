package com.technath.einventory.dao;

import java.util.List;

import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.Supplier;


public interface ItemDAO{

	public void addItem(Item item);
	public void updateItem(Item item);
	public List<Item> listItem();
	public List<Item> listItemBySupplier(Supplier supplier);
	

}


