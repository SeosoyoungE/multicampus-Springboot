package com.multi.jpaPro.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

@Controller
@RequestMapping("/alldbtest")
public class SpringDataJPAController {
	SpringDataJPAService service;

	// spring data jpa1
	@Autowired
	public SpringDataJPAController(SpringDataJPAService service) {
		super();
		this.service = service;
	}

	@GetMapping("/springdata/board/list")
	public String jpafindAll(Model model) {
		List<BoardDTO> list = service.findAll();
		model.addAttribute("boardlist", list);
		System.out.println("=======================================================");
		System.out.println(list);
		return "thymeleaf/exam/boardlist";
	}
	// spring

	@GetMapping("/page/board/list")
	public String jpafindAll_page(Model model, String pageNo) {
		List<BoardDTO> list = service.findAll(Integer.parseInt(pageNo));
		model.addAttribute("boardlist", list);
		System.out.println("=======================================================");
		System.out.println(list);
		return "thymeleaf/exam/boardlist";
	}

}
