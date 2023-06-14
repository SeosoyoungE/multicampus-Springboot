package com.multi.jpaPro.exam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;
@Service
@Transactional
public class JPAServiceImpl implements JPAService {
	
	JPADAO dao;
	
	@Autowired
	public JPAServiceImpl(JPADAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public BoardDTO board_insert(BoardDTO board) {
		return dao.board_insert(board);
	}

	@Override
	public Dept getDept(String deptno) {
		return dao.getDept(deptno);
	}

	@Override
	public void update(BoardDTO updatedata) {
		dao.update(updatedata);
		
	}

	@Override
	public List<BoardDTO> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Optional<BoardDTO> getBoard(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String board_no) {
		dao.delete(board_no);
	}

}
