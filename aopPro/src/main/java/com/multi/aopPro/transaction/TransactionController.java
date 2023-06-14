package com.multi.aopPro.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionController {
	TransactionService service;
	@Autowired
	public TransactionController(TransactionService service) {
		super();
		this.service = service;
	}
	@GetMapping("/main")
	public String index() {
		return "index";
	}
	@RequestMapping("/transaction/test")
	public String test() {
		service.serviceTest();
		return "index";
	}
}
