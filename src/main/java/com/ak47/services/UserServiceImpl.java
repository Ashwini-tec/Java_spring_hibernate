package com.ak47.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ak47.exception.ResourceAlreadyExistException;
import com.ak47.exception.ResourceNotFoundException;
import com.ak47.payload.UserPayload;
import com.ak47.pojo.UserPojo;
import com.ak47.repo.UserRepo;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userModel;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserPayload createUser(UserPojo user) {
		UserPojo data = this.userModel.findByEmail(user.getEmail());
		if(data != null) {
			if(!data.getEmail().isEmpty()) {
				throw new ResourceAlreadyExistException("User", "email", user.getEmail());
			}
		}
		UserPojo userData = this.userModel.save(user);
		UserPayload userInfo = this.modelMapper.map(userData, UserPayload.class);
		return userInfo;
	}

	@Override
	public UserPayload updateUser(UserPojo user, Integer id)  {
		long _id = id;
		UserPojo userData = this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	
		userData.setName(user.getName());
		userData.setAge(user.getAge());
		userData.setPassword(user.getPassword());
		userData.setAddress(user.getAddress());
	
		UserPojo data = this.userModel.save(userData);
		UserPayload info = this.modelMapper.map(data, UserPayload.class);
		return info;
	}

	@Override
	public UserPayload getById(Integer id) {
		long _id = id;
		UserPojo userData = this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		UserPayload info = this.modelMapper.map(userData, UserPayload.class);
		return info;
	}

	@Override
	public List<UserPayload> getAll(Integer pageSize, Integer pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<UserPojo> userData = this.userModel.findAll(p);
		List<UserPojo> allUser = userData.getContent();
		List<UserPayload> userInfo =  allUser.stream().map((user) -> this.modelMapper.map(user, UserPayload.class)).collect(Collectors.toList());
		return userInfo;
	}

	@Override
	public void deleteUser(Integer id) {
		long _id = id;
		this.userModel.findById(_id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		this.userModel.deleteById(_id);
	}

}
