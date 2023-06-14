package com.multi.aopPro.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
	TransactionDAO dao;
	@Autowired
	public TransactionService(TransactionDAO dao) {
		super();
		this.dao = dao;
	}
	@Transactional
	public void serviceTest() {
		dao.test();
		dao.update();
	}
}
