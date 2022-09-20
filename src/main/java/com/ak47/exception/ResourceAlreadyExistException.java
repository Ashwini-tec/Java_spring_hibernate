package com.ak47.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1535434343434L;
	private String message;
	private String fieldName;
	private String value;

	public ResourceAlreadyExistException(String message, String fieldName, String value) {
		super(String.format("%s already exist in data base with %s :' %s'", message, fieldName, value));
		this.message = message;
		this.fieldName = fieldName;
		this.value = value;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	public ResourceAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResourceAlreadyExistException [message=" + message + ", fieldName=" + fieldName + ", value=" + value
				+ "]";
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
