package com.ak47.services;

import java.util.List;

import com.ak47.payload.UserPayload;
import com.ak47.pojo.UserPojo;

public interface UserServices {

	UserPayload createUser(UserPojo user);
	UserPayload updateUser(UserPojo user, Integer id);
	UserPayload getById(Integer user);
	List<UserPayload> getAll(Integer pageSize, Integer pagerNumber);
	void deleteUser(Integer userId);
}
