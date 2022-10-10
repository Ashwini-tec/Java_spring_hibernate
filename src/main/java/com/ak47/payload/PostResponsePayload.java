package com.ak47.payload;

import java.util.List;

public class PostResponsePayload {

	private Integer pageNumber;
	private Integer pageSize;
	private Boolean isNext;
	private List<PostPayload> content;
	private Integer totalPage;
	private long totalElement;
	
	public PostResponsePayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the isNext
	 */
	public Boolean getIsNext() {
		return isNext;
	}
	/**
	 * @param isNext the isNext to set
	 */
	public void setIsNext(Boolean isNext) {
		this.isNext = isNext;
	}
	/**
	 * @return the content
	 */
	public List<PostPayload> getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(List<PostPayload> content) {
		this.content = content;
	}
	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalElement
	 */
	public long getTotalElement() {
		return totalElement;
	}
	/**
	 * @param l the totalElement to set
	 */
	public void setTotalElement(long l) {
		this.totalElement = l;
	}
	@Override
	public String toString() {
		return "ResponsePayload [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", isNext=" + isNext
				+ ", content=" + content + ", totalPage=" + totalPage + ", totalElement=" + totalElement + "]";
	}
	
	
}
