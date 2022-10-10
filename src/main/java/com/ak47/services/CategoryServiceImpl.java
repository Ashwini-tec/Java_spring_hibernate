package com.ak47.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak47.exception.ResourceNotFoundException;
import com.ak47.payload.CategoryPayload;
import com.ak47.pojo.CategoryPojo;
import com.ak47.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	CategoryRepo categoryModel;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CategoryPayload createCategory(CategoryPojo category) {
		CategoryPojo cate = this.categoryModel.save(category);
		CategoryPayload cat = this.modelMapper.map(cate, CategoryPayload.class);
		return cat;
	}

	@Override
	public List<CategoryPayload> getAll() {
		List<CategoryPojo> categ = this.categoryModel.findAll();
		List<CategoryPayload> categAll = categ.stream().map((cate)-> this.modelMapper.map(cate, CategoryPayload.class)).collect(Collectors.toList());
		return categAll;
	}

	@Override
	public CategoryPayload getById(Integer id) {
		long _id = id;
		CategoryPojo categ = this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
		CategoryPayload cate = this.modelMapper.map(categ, CategoryPayload.class);
		return cate;
	}

	@Override
	public CategoryPayload updateCategory(Integer id, CategoryPojo category) {
		long _id = id;
		CategoryPojo categoryData = this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category","id",id));
		
		categoryData.setCategoryName(category.getCategoryName());
		categoryData.setCategoryTitle(category.getCategoryTitle());
		
		
		CategoryPojo categ = this.categoryModel.save(categoryData);
		CategoryPayload cate = this.modelMapper.map(categ, CategoryPayload.class);
		return cate;
	}

	@Override
	public void deleteCategory(Integer id) {
		long _id= id;
		this.categoryModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
		this.categoryModel.deleteById(_id);
	}

}
