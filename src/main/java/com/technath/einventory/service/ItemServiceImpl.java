package com.technath.einventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technath.einventory.dao.ItemDAO;
import com.technath.einventory.entity.Item;
import com.technath.einventory.entity.Supplier;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO itemDAO ;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}



	@Override
	public List<Item> listItems() {
		List<Item> itemList = null ;
		itemList = itemDAO.listItem();
		if(itemList==null){
			itemList= new ArrayList<Item>();
		}
		return itemList;
	}

	@Override
	public void addItem(Item item) {
		itemDAO.addItem(item);
	}



	@Override
	public List<Item> listItemsBySupplier(Supplier supplier) {
		List<Item> itemList = null ;
		itemList = itemDAO.listItemBySupplier(supplier);
		if(itemList==null){
			itemList= new ArrayList<Item>();
		}
		return itemList;
	}

}
