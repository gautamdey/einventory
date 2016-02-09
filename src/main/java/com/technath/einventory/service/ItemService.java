package com.technath.einventory.service;

import java.util.List;

import com.technath.einventory.entity.Item;

public interface ItemService {
	
	public List<Item> listItems();
	public void addItem(Item item);

}
