package com.multi.erp.DTO;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Alias("dept")
public class DeptDTO {
	@NonNull
	private String deptno;
	@NonNull
	private String deptname;
	private String deptStartDay;
	private String deptEndDay;
	private String deptlevel;
	private String deptstep;
	private String deptuppercode;
	private String job_category;
	private String mgr_id;
	private String deptaddr;
	private String depttel;

}
