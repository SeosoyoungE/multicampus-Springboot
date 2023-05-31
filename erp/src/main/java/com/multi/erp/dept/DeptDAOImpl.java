package com.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.erp.DTO.DeptDTO;
@Repository
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	JdbcTemplate template;
	@Override
	public List<DeptDTO> getDeptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptDTO dept) {
		String sql = "INSERT INTO dept VALUES(?,?,?,null,?,?,?,?,?,?,?)";
		return template.update(sql, dept.getDeptno(),dept.getDeptname(),dept.getDeptStartDay(),dept.getDeptlevel(),dept.getDeptstep()
				,dept.getDeptuppercode(),dept.getJob_category(),dept.getMgr_id(),dept.getDeptaddr(),dept.getDepttel());
	}

	@Override
	public List<DeptDTO> select() {
		// jdbc작업할 떄 작성했던 모든 코드가 query 메소드 내부에서 자동으로처리
		// 매번 달라지는 sql문과 조회한 레코드를 어떤 dto에 매핑할 것인지 정보를 담고 있는 
		// RowMapper객체만 넘겨주면 자동으로 모든 레코드를 List로 만들어서 리턴
		return template.query("SELECT * FROM dept;", new DeptRowMapper());
	}

	@Override
	public int delete(String deptno) {
		// TODO Auto-generated method stub
		return template.update("DELETE FROM dept WHERE deptno = ?", deptno);
		
	}

	@Override
	public DeptDTO read(String deptno) {
		return template.queryForObject("SELECT * FROM dept WHERE deptno = ?", new Object[] { deptno }, new DeptRowMapper());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql = "UPDATE dept SET mgr_id=?, deptaddr=?, depttel=? WHERE deptno=?";
		return template.update(sql, dept.getMgr_id(), dept.getDeptaddr(), dept.getDepttel(), dept.getDeptno());
	}

	@Override
	public List<DeptDTO> getSubDeptlist(String uppercode) {
		return template.query("select * from dept where deptuppercode=?", new Object[] {uppercode},new DeptRowMapper());
	}



}
