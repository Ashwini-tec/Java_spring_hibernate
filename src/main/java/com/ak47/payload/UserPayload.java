package com.ak47.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserPayload {

	private long id;
	
	private String name;
	
	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private int age;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	public UserPayload() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserPayload [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", address=" + address
				+ "]";
	}

}
