package com.technath.einventory.service;

import java.util.List;

import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.Supplier;

public interface ItemService {
	
	public List<Item> listItems();
	public void addItem(Item item);
	public List<Item> listItemsBySupplier(Supplier supplier);

}
