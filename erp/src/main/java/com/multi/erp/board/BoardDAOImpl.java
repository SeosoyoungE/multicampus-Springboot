package com.multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.erp.DTO.BoardDTO;
import com.multi.erp.DTO.BoardFileDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	//Mybatis의 핵심클래스를 이용해서 sql문을 실행
	SqlSession sqlSessionTemplate;
	public BoardDAOImpl() {}
	
	@Autowired
	public BoardDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public int insert(BoardDTO board) {
		//SqlSession의 insert메소드는 insert SQL명령문을 실행하기 위해 제공되는 메소드
		//insert(statement,파라미터객체)
		//statement가 매퍼에 정의한 sql문을 구분하는 id명 - 네임스페이스명, id명
		return sqlSessionTemplate.insert("com.multi.erp.board.insert", board); 
	}

	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.multi.erp.board.selectall");
	}

	@Override
	public BoardDTO read(String board_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.multi.erp.board.read",board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("com.multi.erp.board.update",board);
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("com.multi.erp.board.delete",board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		return sqlSessionTemplate.selectList("com.multi.erp.board.search",data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		List<BoardDTO> list =null;
		System.out.println(tag+",======================="+data);
		Map<String, String> map=new HashMap<String, String>();
		map.put("tag", tag);
		map.put("data", data);
		list=sqlSessionTemplate.selectList("com.multi.erp.board.dynamicsearch",map);
		return list;
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = sqlSessionTemplate.selectList("com.multi.erp.board.categorySearch",category);
		System.out.println("=====dao====="+list.size());
		return list;
	}

	@Override
	public int insertFile(List<BoardFileDTO> boardfiledtolist) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("com.multi.erp.board.fileinsert",boardfiledtolist);
	}

	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		return sqlSessionTemplate.selectList("com.multi.erp.board.fileselect",boardno);
	}

	@Override
	public BoardFileDTO getFile(BoardFileDTO inputdata) {
		return sqlSessionTemplate.selectOne("com.multi.erp.board.getfileinfo", inputdata);
	}
	
}
