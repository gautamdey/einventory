package com.technath.einventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.technath.einventory.dao.CategoryDAO;
import com.technath.einventory.entity.Category;

public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDAO categoryDAO ;
	@Override
	public List<Category>getAllCategory() {
		List<Category> itemCategory = null ;
		itemCategory = categoryDAO.listCategory();
		if(itemCategory==null){
			itemCategory= new ArrayList<Category>();
		}
		return itemCategory;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		
	}


}
