package com.ak47.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ak47.exception.ResourceNotFoundException;
import com.ak47.payload.PostPayload;
import com.ak47.pojo.CategoryPojo;
import com.ak47.pojo.PostPojo;
import com.ak47.pojo.UserPojo;
import com.ak47.repo.CategoryRepo;
import com.ak47.repo.PostRepo;
import com.ak47.repo.UserRepo;

@Service
public class PostServiceIml implements PostServices {

	@Autowired
	private PostRepo postModel;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepo userModel;
	
	@Autowired 
	CategoryRepo categoryModel;
	
	@Override
	public PostPayload createPost(PostPayload postDto, Integer userId, Integer categoryId) {
		long id = userId;
		long catId = categoryId;
		UserPojo user = this.userModel.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		CategoryPojo category = this.categoryModel.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", catId));
		
		PostPojo post = this.modelmapper.map(postDto, PostPojo.class);
		post.setUser(user);
		post.setCatgeory(category);
		PostPojo postCreated = this.postModel.save(post);
		
		return this.modelmapper.map(postCreated, PostPayload.class);
	}

	@Override
	public List<PostPayload> getAllPost(Integer pageSize, Integer pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<PostPojo> getPost = this.postModel.findAll(p);
		List <PostPojo> getAllPost =  getPost.getContent();
		List<PostPayload> collect = getAllPost.stream().map((post)-> this.modelmapper.map(post, PostPayload.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public  PostPayload postGetById(Long id) {
		PostPojo postGet = this.postModel.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));
		return this.modelmapper.map(postGet, PostPayload.class);
	}

	@Override
	public PostPayload updatePost(Integer id, PostPayload postDto) {
		long _id = id;
		PostPojo updatePost =  this.postModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));
		
		updatePost.setPostImage(postDto.getPostImage());
		updatePost.setPostTitle(postDto.getPostTitle());

		PostPojo userPost = this.postModel.save(updatePost);
		
		return  this.modelmapper.map(userPost, PostPayload.class);
	}

	@Override
	public void deletePost(Integer id) {
		long _id = id;
		this.postModel.findById(_id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		this.postModel.deleteById(_id);
	}

}
