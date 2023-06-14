package com.multi.jpaPro.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

@Repository
public class SpringDataJPADAOImpl implements SpringDataJPADAO {
	SpringDataDeptRepository repository;
	@Autowired
	public SpringDataJPADAOImpl(SpringDataDeptRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public BoardDTO board_insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept getDept(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO updatedata) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String board_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> findAll(int pageNo) {
		PageRequest pageRequest=PageRequest.of(pageNo, 5,Sort.by(Sort.Direction.ASC,"boardNo"));
		Page<BoardDTO> page= repository.findAll(pageRequest);
		List<BoardDTO> list=page.getContent();
		return list;
	}

}
