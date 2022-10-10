package com.ak47.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostPojo {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column( name = "title")
	private String postTitle;
	
	@Column(name = "image")
	private String postImage;
	
	@ManyToOne
	private CategoryPojo catgeory;

	@ManyToOne
	private UserPojo user;

	
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

	/**
	 * @param postImage the postImage to set
	 */
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	/**
	 * @return the catgeory
	 */
	public CategoryPojo getCatgeory() {
		return catgeory;
	}

	/**
	 * @param catgeory the catgeory to set
	 */
	public void setCatgeory(CategoryPojo catgeory) {
		this.catgeory = catgeory;
	}

	/**
	 * @return the user
	 */
	public UserPojo getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserPojo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostPojo [id=" + id + ", postTitle=" + postTitle + ", postImage=" + postImage + ", catgeory=" + catgeory
				+ ", user=" + user + "]";
	}
	
	
}
