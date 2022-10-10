package com.ak47.services;

import com.ak47.payload.PostPayload;
import java.util.List;

public interface PostServices {

	public PostPayload createPost(PostPayload post, Integer userId, Integer categoryId);
	public List<PostPayload> getAllPost(Integer pageSize, Integer pageNumber);
	public PostPayload postGetById(Long id);
	public PostPayload updatePost(Integer id, PostPayload post);
	public void deletePost(Integer id);
}
