package com.ak47.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ak47.services.UserServices;
import com.ak47.payload.UserPayload;
import com.ak47.pojo.ResponseDataPojo;
import com.ak47.pojo.UserPojo;


@Controller
@RequestMapping("/v1")
public class UserController {

		@Autowired
		UserServices userService;
		
		/********** get list of all user *********/ 
		@RequestMapping(method = RequestMethod.GET, value = "/user")
		@ResponseBody
		public  ResponseEntity<List<UserPayload>> getAllUser(
				@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize, 
				@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber
				) {
			
			System.out.println("In get all User");
			List<UserPayload> _userData = this.userService.getAll(pageSize, pageNumber);
			return new ResponseEntity<>(_userData,HttpStatus.CREATED);
			
		}
		
		/**************** create user **************/ 		
		@RequestMapping(method = RequestMethod.POST, value = "/user")
		@ResponseBody
		public ResponseEntity<UserPayload> registerUser(@Valid @RequestBody UserPojo userData) {	
				UserPayload _userData = this.userService.createUser(userData);
				System.out.println("In register User");
				return new ResponseEntity<>(_userData,HttpStatus.CREATED);
		}

		/****************** update user *************/ 		
		@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
		@ResponseBody
		public ResponseEntity<UserPayload>  UpdateUser(@Valid @RequestBody UserPojo userData, @PathVariable Integer id) {
			System.out.println("In update User");
			UserPayload _userData = this.userService.updateUser(userData, id);
			return new ResponseEntity<>(_userData,HttpStatus.CREATED);
		}
		
		/******************* getById user *************/		
		@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
		@ResponseBody
		public ResponseEntity<UserPayload> getbyId(@PathVariable Integer id) {
			System.out.println("In get by id  User");
			UserPayload _userData = this.userService.getById(id);
			return new ResponseEntity<>(_userData, HttpStatus.OK);
	
		}
		
		/******************* delete user *************/		
		@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
		@ResponseBody
		public ResponseEntity<ResponseDataPojo> deleteUser(@PathVariable Integer id) {
			System.out.println("In delete  User");
			this.userService.deleteUser(id);
			return new ResponseEntity<ResponseDataPojo>(new ResponseDataPojo("user deleted Successfully", true), HttpStatus.OK);
			
		}
}