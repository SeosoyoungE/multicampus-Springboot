package com.multi.jpaPro.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Setter
@Getter
@ToString*/
@Data
//전체 멤버변수를 매개변수로 하는 생성자 정의
@AllArgsConstructor 
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "dept")
public class Dept {
	@NonNull
	@Id
	private String deptno;
	@NonNull
	private String deptname;
	private String deptstartday;
//	@Transient
	@Column(name = "deptendday")
	private String deptEndDay;
	private String deptlevel;
	private String deptstep;
	private String deptuppercode;
	private String job_category;
	private String mgr_id;
	private String deptaddr;
	private String depttel;
	public Dept(@NonNull String deptname, String deptlevel, String deptstep) {
		super();
		this.deptname = deptname;
		this.deptlevel = deptlevel;
		this.deptstep = deptstep;
	}
	public Dept(@NonNull String deptno, @NonNull String deptname, String deptstartday, String depttel) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.deptstartday = deptstartday;
		this.depttel = depttel;
	}
	
	
	
}
