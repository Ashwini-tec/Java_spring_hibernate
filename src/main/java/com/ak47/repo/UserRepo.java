package com.ak47.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ak47.pojo.UserPojo;

public interface UserRepo extends JpaRepository<UserPojo, Long> {
	public UserPojo findByEmail(String email);

}
