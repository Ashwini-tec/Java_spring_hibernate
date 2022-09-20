package com.ak47.services;

import java.util.List;
import com.ak47.pojo.UserPojo;

public interface UserServices {

	UserPojo createUser(UserPojo user);
	UserPojo updateUser(UserPojo user, Integer id);
	UserPojo getById(Integer user);
	List<UserPojo> getAll();
	void deleteUser(Integer userId);
}
