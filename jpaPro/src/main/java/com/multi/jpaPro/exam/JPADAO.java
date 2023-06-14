package com.multi.jpaPro.exam;

import java.util.List;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

public interface JPADAO {
	public BoardDTO board_insert(BoardDTO board);
	//부서번호로 조회하기
	public Dept getDept(String deptno);
	public void update(BoardDTO updatedata);
	public void delete(String board_no);
	//전체목록조회
	public List<BoardDTO> findAll() ;
}
