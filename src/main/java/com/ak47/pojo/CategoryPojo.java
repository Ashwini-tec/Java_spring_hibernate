package com.ak47.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="category")
public class CategoryPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String categoryName;
	
	@Column(name = "title")
	@NotEmpty
	private String categoryTitle;
	
	@OneToMany(mappedBy = "catgeory", cascade= CascadeType.ALL)
	private List<PostPojo> post = new ArrayList<>();
	


	/**
	 * @return the post
	 */
	public List<PostPojo> getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(List<PostPojo> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "CategoryPojo [id=" + id + ", categoryName=" + categoryName + ", categoryTitle=" + categoryTitle
				+ ", post=" + post + "]";
	}

	public CategoryPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return categoryTitle;
	}

	/**
	 * @param categoryTitle the categoryTitle to set
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	
	
}
