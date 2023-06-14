package com.multi.aopPro.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionBasicTest {
	public static void main(String[] args) {
			String url = "jdbc:mysql://127.0.0.1:3306/erp?serverTimezone=UTC";
			String user = "erp";
			String password = "erp";
			String sql ="";
			Connection con =null;
			PreparedStatement ptmt =null;
			
			boolean state=false;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				//트랜잭션의 시작 - autocommit 해제
				con.setAutoCommit(false);
				// 세 개의 sql문을 트랜잭션으로 처리
				
				sql = "insert into test values('test71','1234','서울','장동건',10000)";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
				
			
				sql =  "insert into test values('test72','1234','인천','이민호',10000)";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
				
				
				sql =  "insert into test values('test73','1234','군산','장기용',10000";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
			
				//이 line이 실행되면 문제없이 처리되었음을 의미
				state=true;
			}catch(ClassNotFoundException e){
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				//state값을 판단해서 오류이거나 정상실행 상태때 finally블럭안에서 db에 최종 반영되도록 처리
				try {
					if(state) {
					con.commit();
					} else {
						con.rollback();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

	}

}
