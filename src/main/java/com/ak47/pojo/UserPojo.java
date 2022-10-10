package com.ak47.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name= "users")
public class UserPojo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique= true)
	@Email
	@NotNull
	@NotEmpty
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "age")
	private int age;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL)
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
		return "UserPojo [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", address=" + address + ", post=" + post + "]";
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

}
