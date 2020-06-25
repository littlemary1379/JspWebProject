package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dailyT.db.DBconnection;
import com.dailyT.model.Customer;

public class AdminRepository {
	private static final String TAG="AdminRepository : ";
	
	//싱글톤 패턴 제작
	private static AdminRepository instance = new AdminRepository();
	private AdminRepository() {}
	public static AdminRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public int proSave(String proname,int proPrice, int proSale, String prokind, String proDate, String proPhoto,String proContent) {
		final String SQL="insert into Product (proid,proname,proPrice,prosale,prokind,proDate,proPhoto,proContent) " + 
				"VALUES (PRODUCT_SEQ.nextval,?,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, proname);
			pstmt.setInt(2, proPrice);
			pstmt.setInt(3, proSale);
			pstmt.setString(4, prokind);
			pstmt.setString(5, proDate);
			pstmt.setString(6, proPhoto);
			pstmt.setString(7, proContent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(TAG+"proSave : "+e.getMessage());
		}
		return -1;
	}
	
	public int subSave(String subName,int subPrice, int subSale, String subDate, String subPhoto,String subContent) {
		final String SQL="insert into subProduct (subid,subName,subPrice,subSale,subDate,subPhoto,subContent) " + 
				"VALUES (SUBPRODUCT_SEQ.nextval,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, subName);
			pstmt.setInt(2, subPrice);
			pstmt.setInt(3, subSale);
			pstmt.setString(4, subDate);
			pstmt.setString(5, subPhoto);
			pstmt.setString(6, subContent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		}
		return -1;
	}
	
	public int custUpdate(String nickname, String email, String address, String cellphone, String userID) {
		final String SQL="update customer set nickname=?, email=?, address=?, cellphone=? where userid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, nickname);
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setString(4, cellphone);
			pstmt.setString(5, userID);
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"custUpdate : "+e.getMessage());
			// TODO: handle exception
		}
		return -1;
	}
	
	public String FindPWByCustid(int custid) {
		final String SQL="select password from customer where custid=?";
		String resultPassword=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				resultPassword=rs.getString("password");
				return resultPassword;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int resetPW(String password, String userID) {
		final String SQL="update customer set password=? where userid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setString(2, userID);
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
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
	
	public String FindIDByUsernameAndEmail(String username,String email) {
		final String SQL="select userID from customer where username=? and email=?";
		String result=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getString("userID");
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int FindIDByUserIDandUsernameAndEmail(String username, String userID, String email) {
		final String SQL="select count(*) from customer where username=? and userID=? and email=?";
		int result=0;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, userID);
			pstmt.setString(3, email);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getInt(1);
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public Customer findByUserIDandPassword(String userID,String password) {
		final String SQL="select custid,userid,username,nickname,email,address,cellphone,userrole " + 
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
					.username(rs.getString("username"))
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
