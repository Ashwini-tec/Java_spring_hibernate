package com.ak47.services;

import com.ak47.payload.PostPayload;
import com.ak47.payload.PostResponsePayload;


public interface PostServices {

	public PostPayload createPost(PostPayload post, Integer userId, Integer categoryId);
	public PostResponsePayload getAllPost(Integer pageSize, Integer pageNumber, String orderType,String sortDir);
	public PostPayload postGetById(Long id);
	public PostPayload updatePost(Integer id, PostPayload post);
	public void deletePost(Integer id);
}
