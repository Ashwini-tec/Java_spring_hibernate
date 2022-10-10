package com.ak47.payload;

import javax.validation.constraints.NotEmpty;

public class CategoryPayload {

	private long id;
	
	@NotEmpty
	private String categoryName;

	@NotEmpty
	private String categoryTitle;
	
	public CategoryPayload() {
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

	@Override
	public String toString() {
		return "CategoryPayload [id=" + id + ", categoryName=" + categoryName + ", categoryTitle=" + categoryTitle
				+ "]";
	}

	
}
