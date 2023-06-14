package com.multi.jpaPro.exam;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

@Repository
public class JPADAOImpl implements JPADAO {
	private EntityManager entityManager;

	@Autowired
	public JPADAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public BoardDTO board_insert(BoardDTO board) {
		entityManager.persist(board);
		return board;
	}

	@Override
	public Dept getDept(String deptno) {
		Dept dept=entityManager.find(Dept.class, deptno);
		return dept;
	}

	@Override
	public void update(BoardDTO updatedata) {
		BoardDTO data=entityManager.find(BoardDTO.class, updatedata.getBoardNo());
		data.setTitle(updatedata.getTitle());
		data.setContent(updatedata.getContent());
	}

	@Override
	public List<BoardDTO> findAll() {
		//String jpql="select board from BoardDTO as board where board.board_no=1";
		String jpql="select board from BoardDTO as board";
		List<BoardDTO> list= entityManager.createQuery(jpql,BoardDTO.class).getResultList();
		return list;
	}

	@Override
	public void delete(String boardNo) {
		//1. 삭제할 엔티티를 조회
		BoardDTO data=entityManager.find(BoardDTO.class, boardNo);
		//2. 조회된 엔티티를 삭제
		entityManager.remove(data);
	}

}
