package com.multi.jpaPro.exam;

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
public class JPAController {
	JPAService service;

	@Autowired
	public JPAController(JPAService service) {
		super();
		this.service = service;
	}

	@RequestMapping("")
	public String index() {
		return "thymeleaf/index";
	}

	// insert - 게시판등록하기뷰
	@GetMapping("/board/write")
	public String boardwritepage() {
		return "thymeleaf/exam/board_write";
	}

	// insert - 게시판등록하기기능
	@PostMapping("/board/write")
	public String boardwrite(BoardDTO board) {
		service.board_insert(board);
		return "thymeleaf/index";
	}

	// 부서번호로 조회하기
	@GetMapping("/dept/getInfo")
	public String getDept(String deptno) {
		Dept dept = service.getDept(deptno);
		System.out.println("조회한 부서:" + dept);
		return "thymeleaf/index";
	}

	// 게시글수정하기
	@PostMapping("/dept/update")
	public String update(BoardDTO updateInfo) {
		service.update(updateInfo);
		return "thymeleaf/index";
	}

	// 게시글삭제
	@GetMapping("/board/delete")
	public String delete(String boardNo) {
		service.delete(boardNo);
		return "thymeleaf/index";
	}

	// 게시글전체목록 조회

	@GetMapping("/board/list")
	public String findAll(Model model) {
		List<BoardDTO> list = service.findAll();
		 model.addAttribute("boardlist",list);
		System.out.println("=======================================================");
		System.out.println(list);
		return "thymeleaf/exam/boardlist";
	} // spring data jpa1
	/*
	 * @GetMapping("/springdata/board/list") public String jpafindAll(Model model) {
	 * List<BoardDTO> list = service2.findAll();
	 * model.addAttribute("boardlist",list);
	 * System.out.println("=======================================================")
	 * ; System.out.println(list); return "thymeleaf/exam/boardlist"; } //spring
	 * data 페이징처리
	 * 
	 * @GetMapping("/page/board/list") public String jpafindAll_page(Model
	 * model,String pageNo) { List<BoardDTO> list =
	 * service2.findAll(Integer.parseInt(pageNo));
	 * model.addAttribute("boardlist",list);
	 * System.out.println("=======================================================")
	 * ; System.out.println(list); return "thymeleaf/exam/boardlist"; }
	 */
}
