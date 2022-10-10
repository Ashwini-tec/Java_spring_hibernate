package com.ak47.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak47.pojo.CategoryPojo;

public interface CategoryRepo extends JpaRepository<CategoryPojo, Long> {

}
