package com.ak47.payload;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.ak47.pojo.CategoryPojo;
import com.ak47.pojo.UserPojo;

public class PostPayload {

	private long id;
	
	@NotEmpty
	private String postTitle;
	
	@NotEmpty
	private String postImage;
	
	private CategoryPayload catgeory;

	/**
	 * @return the catgeory
	 */
	public CategoryPayload getCatgeory() {
		return catgeory;
	}

	/**
	 * @param catgeory the catgeory to set
	 */
	public void setCatgeory(CategoryPayload catgeory) {
		this.catgeory = catgeory;
	}

	/**
	 * @return the user
	 */
	public UserPayload getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserPayload user) {
		this.user = user;
	}



	private UserPayload user;

	/**
	 * @param postImage the postImage to set
	 */
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the postTitle
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * @param postTitle the postTitle to set
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	/**
	 * @return the postImage
	 */
	public String getPostImage() {
		return postImage;
	}

	

	@Override
	public String toString() {
		return "PostPayload [id=" + id + ", postTitle=" + postTitle + ", postImage=" + postImage + ", catgeory="
				+ catgeory + ", user=" + user + "]";
	}
	
	
	
}
