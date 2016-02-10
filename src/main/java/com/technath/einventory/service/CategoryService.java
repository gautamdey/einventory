package com.technath.einventory.service;

import java.util.List;

import com.technath.einventory.entity.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();
	public void addCategory(Category category);
}
