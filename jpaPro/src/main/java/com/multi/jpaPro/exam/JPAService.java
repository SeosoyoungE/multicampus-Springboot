package com.multi.jpaPro.exam;

import java.util.List;
import java.util.Optional;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

public interface JPAService {
	//게시글등록하기
	public BoardDTO board_insert(BoardDTO board);
	//부서번호로 조회하기
	public Dept getDept(String deptno);
	//게시글 삭제
	public void delete(String board_no);
	//게시글수정하기
	public void update(BoardDTO updatedata);
	public List<BoardDTO> findAll() ;
	public Optional<BoardDTO> getBoard(String board_no);
	public List<BoardDTO> findAll(int pageNo);
}
