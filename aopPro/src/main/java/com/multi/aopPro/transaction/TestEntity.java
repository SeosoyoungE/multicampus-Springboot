package com.multi.aopPro.transaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
	@Id
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Integer point;
	public TestEntity() {
		
	}
	public TestEntity(String id, String pass, String name, String addr, Integer point) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", point=" + point
				+ "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}

}
