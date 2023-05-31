package com.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.erp.DTO.DeptDTO;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDAO dao;
	
	@Override
	public int insert(DeptDTO dept) {
		return dao.insert(dept);
	}

	@Override
	public List<DeptDTO> getDeptName() {
		return null;
	}

	@Override
	public List<DeptDTO> select() {
		return dao.select();
	}

	@Override
	public int delete(String deptno) {
		return dao.delete(deptno);
	}

	@Override
	public DeptDTO read(String deptno) {
		return dao.read(deptno);
	}

	@Override
	public int update(DeptDTO dept) {
		return dao.update(dept);
	}

	@Override
	public List<DeptDTO> getSubDeptlist(String uppercode) {
		// TODO Auto-generated method stub
		return dao.getSubDeptlist(uppercode);
	}



}
