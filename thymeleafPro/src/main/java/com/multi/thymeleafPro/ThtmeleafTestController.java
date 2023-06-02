package com.multi.thymeleafPro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th")
public class ThtmeleafTestController {
	
	@GetMapping("/index")
	public String index() {
		return "thymeleaf/index";
	}
	@GetMapping("/printmodel")
	public String printModelAttr(Model model) {
		model.addAttribute("msg","thymeleaf이용하기");
		model.addAttribute("data","erp");
		return "thymeleaf/basic/attr_test";
	}
	@GetMapping("/formtest")
	public String formTest(Model model,String test1,String erp) {
		System.out.println("test1: "+test1);
		System.out.println("erp: "+erp);
		return "thymeleaf/basic/attr_test";
	}
	@GetMapping("/iftest")
	public String ifTest(Model model) {
		model.addAttribute("myval", 100);
		return "thymeleaf/basic/iftest";
	}
	@GetMapping("/sharedObjTest")
	public String sharedObjTest(Model model) {
		PersonDTO p1=new PersonDTO("bts1","진",95);
		PersonDTO p2=new PersonDTO("bts2","진",80);
		PersonDTO p3=new PersonDTO("bts3","진",90);
		List<PersonDTO> personlist=new ArrayList<>();
		personlist.add(p1);
		personlist.add(p2);
		personlist.add(p3);
		model.addAttribute("personlist", personlist);
		model.addAttribute("person", p1);
		return "thymeleaf/basic/printobj";
	}
}
