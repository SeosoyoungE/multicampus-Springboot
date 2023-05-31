package com.multi.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.erp.DTO.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
public class IndexController {
	BoardService service;
	
	@Autowired
	public IndexController(BoardService service) {
		super();
		this.service = service;
	}
	@RequestMapping("/index.do")
	public String index(Model model) {
		List<BoardDTO> boardlist=service.findByCategory("게시판");
		model.addAttribute("boardlist",boardlist);
		return "index";
	}
	
	
	@RequestMapping("/menu/board.do")
	public String board() {
		
		return "menu/board";
	}
}
