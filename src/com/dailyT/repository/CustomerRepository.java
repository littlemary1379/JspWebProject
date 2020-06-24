package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dailyT.db.DBconnection;
import com.dailyT.model.Customer;

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
	
	public int userIDCheck(String userID) {
		final String SQL="select count(userID) from customer where userid=?";
		int result=0;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getInt(1);
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public Customer findByUserIDandPassword(String userID,String password) {
		final String SQL="select custid,userid,nickname,email,address,cellphone,userrole " + 
						"from customer " + 
						"where userid=? and password=?";
		Customer cust=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				cust=Customer.builder()
					.custid(rs.getInt("custid"))
					.userID(rs.getString("userid"))
					.nickname(rs.getString("nickname"))
					.email(rs.getString("email"))
					.address(rs.getString("address"))
					.cellphone(rs.getString("cellphone"))
					.userrole(rs.getString("userrole"))
					.build();
			}
			return cust;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findByUserIDandPassword : "+e.getMessage());
		}
		return null;
		
	}
	
}
