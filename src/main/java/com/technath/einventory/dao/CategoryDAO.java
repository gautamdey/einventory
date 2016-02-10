package com.technath.einventory.dao;

import java.util.List;

import com.technath.einventory.entity.Category;


public interface CategoryDAO{

	public void addCategory(Category category);
	public void updateCategory(Category category);
	public List<Category> listCategory();
	

}


