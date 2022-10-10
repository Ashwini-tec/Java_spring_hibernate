package com.ak47.services;

import java.util.List;

import com.ak47.pojo.CategoryPojo;

public interface CategoryServices {

	CategoryPojo createCategory(CategoryPojo category);
	List<CategoryPojo> getAll();
	CategoryPojo getById(Integer id);
	CategoryPojo updateCategory(Integer id, CategoryPojo category);
	void deleteCategory(Integer id);
	
}
