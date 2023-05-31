package com.multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.erp.DTO.BoardDTO;
import com.multi.erp.DTO.BoardFileDTO;
//BoardDAO의 메소드를 호출
	// 컨트롤러에서 받은 데이터를 가공해서 DAO에 넘기거나 DAO에서 받은 데이터를 가공해서 컨트롤러로 넘기는 작업
	// 비지니스로직
	//트랜젝션처리
@Service
public class BoardServiceImpl implements BoardService {
	BoardDAO dao;
	public BoardServiceImpl() {}
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}


	@Override
	public int insert(BoardDTO board) {
		return dao.insert(board);
	}

	@Override
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	@Override
	public BoardDTO getBoardInfo(String board_no) {
		BoardDTO dto =  dao.read(board_no);
		System.out.println(dto+"------------------------------");
		return dto;
	}

	@Override
	public int update(BoardDTO board) {
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		return dao.delete(board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		return dao.search(data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		// TODO Auto-generated method stub
		return dao.search(tag, data);
	}
	
	//조건을 판단해서 dao의 적절한 메소드를 호출하기
	@Override
	public List<BoardDTO> findByCategory(String category) {
		List<BoardDTO> list=null;
		if(category!=null) {
			if(category.equals("all")) {
				list=dao.boardList();
			}else {
				list=dao.findByCategory(category);
			}
		}
		return list;
	}
	//게시글등록버튼을 눌렀을때 실행될 메소드
	
	public int insert(BoardDTO board, List<BoardFileDTO> boardfiledtolist) {
		dao.insert(board);
		dao.insertFile(boardfiledtolist);
		return 0;
	}
	
	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		// TODO Auto-generated method stub
		return dao.getFileList(boardno);
	}

	@Override
	public BoardFileDTO getFile(BoardFileDTO inputdata) {
		// TODO Auto-generated method stub
		return dao.getFile(inputdata);
	}

}
