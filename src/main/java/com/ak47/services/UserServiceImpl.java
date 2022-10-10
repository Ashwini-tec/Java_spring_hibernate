package com.ak47.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ak47.exception.ResourceAlreadyExistException;
import com.ak47.exception.ResourceNotFoundException;
import com.ak47.pojo.UserPojo;
import com.ak47.repo.UserRepo;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userModel;
	
	@Override
	public UserPojo createUser(UserPojo user) {
		UserPojo data = this.userModel.findByEmail(user.getEmail());
		if(data != null) {
			if(!data.getEmail().isEmpty()) {
				throw new ResourceAlreadyExistException("User", "email", user.getEmail());
			}
		}
		UserPojo userData = this.userModel.save(user);
		return userData;
	}

	@Override
	public UserPojo updateUser(UserPojo user, Integer id)  {
		long _id = id;
		UserPojo userData = this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

		userData.setName(user.getName());
		userData.setAge(user.getAge());
		userData.setEmail(user.getEmail());
		userData.setPassword(user.getPassword());
		userData.setAddress(user.getAddress());
		
		UserPojo data = this.userModel.save(userData);
		return data;
	}

	@Override
	public UserPojo getById(Integer id) {
		long _id = id;
		UserPojo userData = this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		return userData;
	}

	@Override
	public List<UserPojo> getAll(Integer pageSize, Integer pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<UserPojo> userData = this.userModel.findAll(p);
		List<UserPojo> allUser = userData.getContent();
		return allUser;
	}

	@Override
	public void deleteUser(Integer id) {
		long _id = id;
		this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		this.userModel.deleteById(_id);
	}

}
