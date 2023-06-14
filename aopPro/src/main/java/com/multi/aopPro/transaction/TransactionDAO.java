package com.multi.aopPro.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAO {
	TestRepostitory repository;
	@Autowired
	public TransactionDAO(TestRepostitory repository) {
		super();
		this.repository = repository;
	}
	public void test() {
		repository.save(new TestEntity("test3","1234","트랜","자바",10000));
		
	}
	public void update() {
		TestEntity en =  repository.findById("test3").orElseThrow(()-> new RuntimeException());
		en.setAddr("자바동");
		repository.save(en);
	}
}
