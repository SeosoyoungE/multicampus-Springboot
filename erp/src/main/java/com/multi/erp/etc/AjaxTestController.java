package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.erp.DTO.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
@RequestMapping("/ajax")
public class AjaxTestController {
	BoardService service;
	@Autowired
	public AjaxTestController(BoardService service) {
		super();
		this.service = service;
	}
	//작업이 완료되면 뷰를 response하는 방식
	@RequestMapping("/noajax")
	public String noajax(String id, Model model) {
		String msg="";
		if(id.equals("jang")) {
			msg="사용불가능아이디";
		}else {
			msg="사용가능아이디";
		}
		model.addAttribute("msg",msg);
		return "etcview/ajax";
	}
	//ajax요청으로 실행되는 컨트롤러 String결과를 클라이언트에게 전송
	//response는 기존의 방식처럼 view를 response하는 것이 아니므로 response할 데이터의 형식을 리턴타입에 정의
	//뷰를 리턴하지 않고 명시된 타입으로 리턴하겠다는 의미
	//produce속성에 response되는 데이터으 ㅣ형식(MIME type)과 인코딩을 명시
	@RequestMapping(value =  "/ajaxtest01", produces = "application/text;charset=UTF-8")
	@ResponseBody //String이 response body라고 명시해야 뷰로 인식하지 않는다.
	public String ajaxtest(String id) {
		String msg="";
		if(id.equals("jang")) {
			msg="사용불가능아이디";
		}else {
			msg="사용가능아이디";
		}
		return msg;
	}
	
	@RequestMapping(value = "/gugu", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String getgugu(String dan)
	{
		String msg="";
		for(int i=1;i<=9;i++) {
			int dan_int=Integer.parseInt(dan);
			msg+="<h4>"+dan_int+" X "+i+" = "+(dan_int*i)+"</h4>";
		}
		return msg;
	}
	
	@RequestMapping(value = "/exam01",
			produces = "application/json;charset=utf-8")
	@ResponseBody
	public BoardDTO responseObj(String boardno) {
		//리턴타입을 DTO로 명시하면 jackson-databine 라이브러리가 자동으로 json object로 변환해서 리턴된다.
		System.out.println(boardno);
		return service.getBoardInfo(boardno);
	}
	@RequestMapping(value =  "/exam02/getjsondata",
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<BoardDTO> responseJsonArr() {
		//리턴타입을 List로 명시하면 jackson-databine 라이브러리가 자동으로 json Array로 변환해서 리턴된다.
		return service.boardList();
	}
	
	
	
}
