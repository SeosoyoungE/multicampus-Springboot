package com.multi.jpaPro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.jpaPro.domain.Dept;
import com.multi.jpaPro.repository.DeptRepository;

@SpringBootTest
class Jpatest_dept {
	
	@Autowired
	DeptRepository repository;
	
	@Test
	void insert() {
		repository.save(new Dept("2222", "2번부서", null, "2222"));
	}

}
