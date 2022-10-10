package com.ak47.services;

import java.util.List;

import com.ak47.payload.CategoryPayload;
import com.ak47.pojo.CategoryPojo;

public interface CategoryServices {

	CategoryPayload createCategory(CategoryPojo category);
	List<CategoryPayload> getAll();
	CategoryPayload getById(Integer id);
	CategoryPayload updateCategory(Integer id, CategoryPojo category);
	void deleteCategory(Integer id);
	
}
