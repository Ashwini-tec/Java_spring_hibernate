package com.ak47.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak47.payload.PostPayload;
import com.ak47.payload.PostResponsePayload;
import com.ak47.pojo.ResponseDataPojo;
import com.ak47.services.PostServices;

@RestController
@RequestMapping("/v1")
public class PostController {

	@Autowired
	PostServices postService;
	
	@RequestMapping( method = RequestMethod.POST , value ="/userPost/user/{userId}/category/{catId}")
	public ResponseEntity<PostPayload> createPost(
			@Valid @RequestBody PostPayload post, 
			@PathVariable Integer userId,
			@PathVariable Integer catId
			){
		PostPayload userPost = this.postService.createPost(post, userId, catId);
		return new ResponseEntity<>(userPost, HttpStatus.CREATED);
	}
	
	@RequestMapping( method = RequestMethod.GET, value ="/userPost")
	public ResponseEntity<PostResponsePayload> getAllPost(
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "orderedBy", defaultValue = "id", required = false) String orderType,
			@RequestParam(value = "sortDir", defaultValue = "acc", required = false) String sortDir
			){
		PostResponsePayload userPost = this.postService.getAllPost(pageSize, pageNumber, orderType, sortDir);
		return new ResponseEntity<>(userPost, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/userPost/{id}")
	public ResponseEntity<PostPayload> getById(@PathVariable Long id){
		PostPayload userPost = this.postService.postGetById(id);
		return new ResponseEntity<>(userPost, HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value= "/userPost/{id}")
	public ResponseEntity<PostPayload> updatePost(@PathVariable Integer id, @Valid @RequestBody PostPayload post ){
		PostPayload userPost = this.postService.updatePost(id, post);
		return new ResponseEntity<>(userPost, HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value="/userPost/{id}")
	public ResponseEntity<ResponseDataPojo> deletePost(@PathVariable Integer id){
		this.postService.deletePost(id);
		return new ResponseEntity<ResponseDataPojo>(new ResponseDataPojo("Post Deleted Successfully", true), HttpStatus.OK);
	}
}
