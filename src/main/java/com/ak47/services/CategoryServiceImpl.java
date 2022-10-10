package com.ak47.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak47.exception.ResourceNotFoundException;
import com.ak47.pojo.CategoryPojo;
import com.ak47.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	CategoryRepo categoryModel;
	
	@Override
	public CategoryPojo createCategory(CategoryPojo category) {
		CategoryPojo cate = this.categoryModel.save(category);
		return cate;
	}

	@Override
	public List<CategoryPojo> getAll() {
		List<CategoryPojo> categ = this.categoryModel.findAll();
		return categ;
	}

	@Override
	public CategoryPojo getById(Integer id) {
		long _id = id;
		CategoryPojo categ = this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
		return categ;
	}

	@Override
	public CategoryPojo updateCategory(Integer id, CategoryPojo category) {
		long _id = id;
		CategoryPojo categoryData = this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category","id",id));
		
		categoryData.setCategoryName(category.getCategoryName());
		categoryData.setCategoryTitle(category.getCategoryTitle());
		
		
		CategoryPojo categ = this.categoryModel.save(categoryData);
		return categ;
	}

	@Override
	public void deleteCategory(Integer id) {
		long _id= id;
		this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
		this.categoryModel.deleteById(_id);
	}

}
