package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dailyT.db.DBconnection;

public class CustomerRepository {
	private static final String TAG="CustomerRepository : ";
	
	//싱글톤 패턴 제작
	private static CustomerRepository instance = new CustomerRepository();
	private CustomerRepository() {}
	public static CustomerRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public int save(String userID, String password, String nickname, String email, String address, String cellphone) {
		final String SQL="insert into customer (custid,userid,password,nickname,email,address,cellphone,userrole,createdate) " + 
				"VALUES (CUSTID_SEQ.nextval,?,?,?,?,?,?,'사용자',sysdate)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			pstmt.setString(3, nickname);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, cellphone);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		}
		return -1;
	}
	
}
