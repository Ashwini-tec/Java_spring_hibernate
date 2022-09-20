package com.ak47.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5344320715962995240L;
	private String comment;
	private long id;
	private String fieldValue;

	public ResourceNotFoundException(String comment, String fieldName, long id) {
		super(String.format("%s not found with %s : '%s'", comment, fieldName, id));
		this.comment = comment;
		this.id = id;
		this.fieldValue = fieldName;
	}

	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}