package com.ak47.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ak47.pojo.CategoryPojo;
import com.ak47.pojo.ResponseDataPojo;
import com.ak47.services.CategoryServices;

@RestController 
@RequestMapping("/v1")
public class CategoryController {

	@Autowired
	CategoryServices categoryService;

	//create category 	
	@RequestMapping (method = RequestMethod.POST, value= "/category")
	public ResponseEntity<CategoryPojo> createCategory(@RequestBody CategoryPojo category) {
		System.out.println("in create category");
		CategoryPojo categ =  this.categoryService.createCategory(category);
		return new ResponseEntity<>(categ, HttpStatus.CREATED);
	}
	
	// get all category 
	@RequestMapping(method = RequestMethod.GET, value= "/category")
	public ResponseEntity<List<CategoryPojo>> getAllCategory(){
		System.out.println("in get all category");
		List<CategoryPojo> categ = this.categoryService.getAll();
		return new ResponseEntity<>(categ, HttpStatus.OK);
	}
	
	// category get by id
	@RequestMapping( method= RequestMethod.GET, value="/category/{id}")
	public ResponseEntity<CategoryPojo> getcategoryById(@PathVariable Integer id) {
		System.out.println("in get by id category");
		CategoryPojo categ = this.categoryService.getById(id);
		return new ResponseEntity<>(categ, HttpStatus.OK);
	}
	
	//update category 
	@RequestMapping( method = RequestMethod.PUT, value = "/category/{id}")
	public ResponseEntity<CategoryPojo> updateCategory(@Valid @RequestBody CategoryPojo category,@PathVariable Integer id){
		System.out.println("in update category");
		CategoryPojo ceteg = this.categoryService.updateCategory(id, category);
		return new ResponseEntity<>( ceteg , HttpStatus.OK);
	}
	
	//delete category
	@RequestMapping( method = RequestMethod.DELETE, value ="/category/{id}")
	public ResponseEntity<ResponseDataPojo> deleteCategory(@PathVariable Integer id){
		System.out.println("in delete category");
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<ResponseDataPojo>(new ResponseDataPojo("Category deleted Successfull", true),HttpStatus.OK);
	}
}
