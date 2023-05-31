package com.multi.erp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.erp.DTO.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	SqlSession sqlSessionTemplate;
	public MemberDAOImpl() {
		
	}
	
	@Autowired
	public MemberDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		return sqlSessionTemplate.selectList("com.multi.erp.member.treedata", deptno);
	}

	@Override
	public int insert(MemberDTO user) {
		System.out.println("매퍼전: "+user);
		return sqlSessionTemplate.insert("com.multi.erp.member.insert", user);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO login(MemberDTO loginUser) {
		
		return sqlSessionTemplate.selectOne("com.multi.erp.member.login",loginUser);
	}

	@Override
	public boolean idCheck(String id) {
		if(sqlSessionTemplate.selectOne("com.multi.erp.member.idcheck",id)	==null) {
			return true;
		}
		return false;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
