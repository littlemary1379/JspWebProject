package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dailyT.db.DBconnection;
import com.dailyT.dto.proReplyView;
import com.dailyT.dto.subReplyView;
import com.dailyT.model.Customer;
import com.dailyT.model.ProReply;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.model.SubReply;

public class ClientRepository {
	private static final String TAG="AdminRepository : ";
	
	//싱글톤 패턴 제작
	private static ClientRepository instance = new ClientRepository();
	private ClientRepository() {}
	public static ClientRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	
	public int deleteSubReply(int replyid) {
		final String SQL="delete from subreply where replyid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, replyid);
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteSubReply : "+e.getMessage());
		}
		return -1;
	}
	
	public List<subReplyView> findSubReply(int subid) {
		final String SQL="select replyid,subreply.custid,nickname,score,content " + 
				"from subreply,customer " + 
				"where subreply.custid=customer.custid and subid=? order by replyid desc";
		List<subReplyView> subReplies=new ArrayList<>();
		subReplyView subReply=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subReply=subReplyView.builder()
						.replyid(rs.getInt("replyid"))
						.custid(rs.getInt("custid"))
						.nickname(rs.getString("nickname"))
						.score(rs.getInt("score"))
						.content(rs.getString("content"))
						.build();
				subReplies.add(subReply);
			}
			
			return subReplies;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"findSubReply : "+e.getMessage());
		}
		return null;
	}
	
	public int subReplySave(SubReply subReply) {
		final String SQL="insert into subReply (replyid,custid,subid,score,content) " + 
				"VALUES (subreply_SEQ.nextval,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subReply.getCustid());
			pstmt.setInt(2, subReply.getSubid());
			pstmt.setInt(3, subReply.getScore());
			pstmt.setString(4, subReply.getContent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"subReplySave : "+e.getMessage());
		}
		return -1;
	}
		
	public SubProduct findSubProductBySubID(int subId) {
		final String SQL="select subId, subname,subPrice,subsale,subDate,subPhoto,subPreview,subContent from subproduct where subId=?";

		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subId"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subPrice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subphoto"))
						.subPreview(rs.getString("subPreview"))
						.subContent(rs.getString("subcontent"))
						.build();
				return subproduct;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findSubProductBySubID : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindAllSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindOriginSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct where subdate is null";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindSeasonSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct where subdate is not null";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindSeasonSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public int deleteProReply(int replyid) {
		final String SQL="delete from proreply where replyid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, replyid);
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteProReply : "+e.getMessage());
		}
		return -1;
	}
	
	public int proReplySave(ProReply proReply) {
		final String SQL="insert into proReply (replyid,custid,proid,score,content) " + 
				"VALUES (proreply_SEQ.nextval,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, proReply.getCustid());
			pstmt.setInt(2, proReply.getProid());
			pstmt.setInt(3, proReply.getScore());
			pstmt.setString(4, proReply.getContent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"proReplySave : "+e.getMessage());
		}
		return -1;
	}
	
	public List<proReplyView> findProReply(int proid) {
		final String SQL="select replyid,proreply.custid,nickname,score,content " + 
				"from proreply,customer " + 
				"where proreply.custid=customer.custid and proid=? order by replyid desc";
		List<proReplyView> proReplies=new ArrayList<>();
		proReplyView proReply=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, proid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				proReply=proReplyView.builder()
						.replyid(rs.getInt("replyid"))
						.custid(rs.getInt("custid"))
						.nickname(rs.getString("nickname"))
						.score(rs.getInt("score"))
						.content(rs.getString("content"))
						.build();
				proReplies.add(proReply);
			}
			
			return proReplies;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"findSubReply : "+e.getMessage());
		}
		return null;
	}
	
	public Product findProductByProID(int proId) {
		final String SQL="select proId, proname,proPrice,prosale,prokind,proStock,proDate,proPhoto,preview,proContent from product where proId=?";

		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, proId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proId"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("prosale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("prostock"))
						.proDate(rs.getString("prodate"))
						.proPhoto(rs.getString("prophoto"))
						.preview(rs.getString("preview"))
						.proContent(rs.getString("procontent"))
						.build();
				return product;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Product> FindAllProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate,proPhoto,preview from product";
		List<Product> products=new ArrayList<>();
		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proid"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("proSale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("proStock"))
						.proDate(rs.getString("proDate"))
						.proPhoto(rs.getString("proPhoto"))
						.preview(rs.getString("preview"))
						.build();
				products.add(product);
			}
			
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<Product> FindBlackTeaProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate,proPhoto,preview from product where prokind='홍차'";
		List<Product> products=new ArrayList<>();
		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proid"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("proSale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("proStock"))
						.proDate(rs.getString("proDate"))
						.proPhoto(rs.getString("proPhoto"))
						.preview(rs.getString("preview"))
						.build();
				products.add(product);
			}
			
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<Product> FindGreenTeaProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate,proPhoto,preview from product where prokind='녹차'";
		List<Product> products=new ArrayList<>();
		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proid"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("proSale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("proStock"))
						.proDate(rs.getString("proDate"))
						.proPhoto(rs.getString("proPhoto"))
						.preview(rs.getString("preview"))
						.build();
				products.add(product);
			}
			
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<Product> FindWhiteTeaProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate,proPhoto,preview from product where prokind='백차'";
		List<Product> products=new ArrayList<>();
		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proid"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("proSale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("proStock"))
						.proDate(rs.getString("proDate"))
						.proPhoto(rs.getString("proPhoto"))
						.preview(rs.getString("preview"))
						.build();
				products.add(product);
			}
			
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllProduct : "+e.getMessage());
		}
		return null;
	}
	
	public int proSave(String proname,int proPrice, int proSale, String prokind, int proStock, String proDate, String proPhoto,String preview,String proContent) {
		final String SQL="insert into Product (proid,proname,proPrice,prosale,prokind,proStock,proDate,proPhoto,preview,proContent) " + 
				"VALUES (PRODUCT_SEQ.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, proname);
			pstmt.setInt(2, proPrice);
			pstmt.setInt(3, proSale);
			pstmt.setString(4, prokind);
			pstmt.setInt(5, proStock);
			pstmt.setString(6, proDate);
			pstmt.setString(7, proPhoto);
			pstmt.setString(8, preview);
			pstmt.setString(9, proContent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"proSave : "+e.getMessage());
		}
		return -1;
	}
		
	public int productUpdate(String proname,int proPrice, int proSale, String prokind, int proStock, String proDate, String proPhoto,String preview,String proContent, int proid) {
		final String SQL="update product set proname=?, proPrice=?, proSale=?, prokind=?, proStock=?, proDate=?, proPhoto=?,preview=?, proContent=? where proid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, proname);
			pstmt.setInt(2, proPrice);
			pstmt.setInt(3, proSale);
			pstmt.setString(4, prokind);
			pstmt.setInt(5, proStock);
			pstmt.setString(6, proDate);
			pstmt.setString(7, proPhoto);
			pstmt.setString(8, preview);
			pstmt.setString(9, proContent);
			pstmt.setInt(10, proid);
			
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"productUpdate : "+e.getMessage());
			
		}
		return -1;
	}
	
	public int subproductUpdate(String subName,int subPrice, int subSale, String subDate, String subPhoto,String subPreview,String subContent, int subid) {
		final String SQL="update subproduct set subName=?, subPrice=?, subSale=?, subDate=?, subPhoto=?, subPreview=?,subContent=? where subid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, subName);
			pstmt.setInt(2, subPrice);
			pstmt.setInt(3, subSale);
			pstmt.setString(4, subDate);
			pstmt.setString(5, subPhoto);
			pstmt.setString(6, subPreview);
			pstmt.setString(7, subContent);
			pstmt.setInt(8, subid);
			
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"subproductUpdate : "+e.getMessage());
		
		}
		return -1;
	}
	

	

	
}
