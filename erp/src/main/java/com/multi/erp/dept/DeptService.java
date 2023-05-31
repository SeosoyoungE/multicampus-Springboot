package com.multi.erp.dept;

import java.util.List;

import com.multi.erp.DTO.DeptDTO;

public interface DeptService {
	int insert(DeptDTO dept);
	List<DeptDTO> getDeptName();
	//전체사원목을 조회하는 메소드
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
	// 부서등록- 부서 일반 등록, 첨부파일 디비
	
	public List<DeptDTO> getSubDeptlist(String uppercode);
}
