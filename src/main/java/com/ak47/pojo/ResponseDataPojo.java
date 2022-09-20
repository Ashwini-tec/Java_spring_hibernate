package com.ak47.pojo;

public class ResponseDataPojo {

	private String message;
	private boolean success;
	public ResponseDataPojo() {
		super();
	}
	public ResponseDataPojo(String message2, boolean b) {
		// TODO Auto-generated constructor stub
		this.message = message2;
		this.success = b;
	}
	@Override
	public String toString() {
		return "ResponseDataPojo [message=" + message + ", success=" + success + "]";
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
