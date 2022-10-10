package com.ak47.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ak47.pojo.PostPojo;

public interface PostRepo  extends JpaRepository<PostPojo, Long>{

}
