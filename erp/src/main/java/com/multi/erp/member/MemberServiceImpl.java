package com.multi.erp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.erp.DTO.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	MemberDAO dao;
	public MemberServiceImpl() {
		
	}
	
	@Autowired
	public MemberServiceImpl(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		return dao.getTreeEmpList(deptno);
	}

	@Override
	public int insert(MemberDTO user, MultipartFile file, String realpath, String filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
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

	// 컨트롤러 
	@Override
	public MemberDTO login(MemberDTO loginUser) {
		MemberDTO user =dao.login(loginUser);
		System.out.println(user);
		//db에서 가져온 값에서 menupath를 가공해서 뷰의 이름을 사용
		if(user!=null) {
			String menupath = user.getMenupath();
			menupath=menupath.substring(menupath.indexOf("/")+1,menupath.indexOf("_"));
			user.setMenupath(menupath);
		}
		System.out.println("후: "+user);
		return user;
	}

	@Override
	public int insert(MemberDTO user) {
		return dao.insert(user);
	}

}
