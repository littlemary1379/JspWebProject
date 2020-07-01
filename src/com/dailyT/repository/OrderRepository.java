package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dailyT.db.DBconnection;
import com.dailyT.model.Customer;
import com.dailyT.model.Event;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;

public class OrderRepository {
	private static final String TAG="OrderRepository : ";
	
	//싱글톤 패턴 제작
	private static OrderRepository instance = new OrderRepository();
	private OrderRepository() {}
	public static OrderRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public int subscribeSave(int custid, String subscribeName, String subscribeDate, int subscribeTerm, String subscribeAddr, String subscribePhone) {
		final String SQL="insert into subscribe (subscribeId,custid,subscribeName,subscribeDate,subscribeTerm,subscribeAddr,subscribePhone) " + 
				"VALUES (subscribe_SEQ.nextval,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			pstmt.setString(2, subscribeName);
			pstmt.setString(3, subscribeDate);
			pstmt.setInt(4, subscribeTerm);
			pstmt.setString(5, subscribeAddr);
			pstmt.setString(6, subscribePhone);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"subscribeSave : "+e.getMessage());
		}
		return -1;
	}
	
	public Customer FindCustomerById(int custid) {
		final String SQL="select username,address,cellphone from customer where custid=?" ;
		Customer customer=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				customer=Customer.builder()
						.username(rs.getString("username"))
						.address(rs.getString("address"))
						.cellphone(rs.getString("cellphone"))
						.build();
			}
			
			return customer;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindCustomerById : "+e.getMessage());
		}
		return null;
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
			System.out.println(TAG+"findSubProductByProID : "+e.getMessage());
		}
		return null;
	}
	
	public Event findEventByEventId(int eventId) {
		final String SQL="select eventid,eventname,eventstartdate,eventfinishdate,eventpreview,eventcontent from eventlist where eventId=?";

		Event event=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, eventId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				event=Event.builder()
						.eventId(rs.getInt("eventid"))
						.eventName(rs.getString("eventname"))
						.eventStartDate(rs.getString("eventstartdate"))
						.eventFinishDate(rs.getString("eventfinishdate"))
						.eventPreview(rs.getString("eventpreview"))
						.eventContent(rs.getString("eventcontent"))
						.build();
				return event;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findEventByEventId : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindAllSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate from subproduct";
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
	
	public List<Product> FindAllProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate from product";
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
	
	public List<Event> FindAllEvent() {
		final String SQL="select eventid,eventname,eventstartdate,eventfinishdate from eventlist";
		List<Event> events=new ArrayList<>();
		Event event=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				event=Event.builder()
						.eventId(rs.getInt("eventid"))
						.eventName(rs.getString("eventname"))
						.eventStartDate(rs.getString("eventstartdate"))
						.eventFinishDate(rs.getString("eventfinishdate"))
						.build();
				events.add(event);
			}
			
			return events;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllEvent : "+e.getMessage());
		}
		return null;
	}
	
	public int eventSave(String eventname, String eventStartDate,String eventFinishDate, String eventBanner,String eventpreview,String eventContent) {
		final String SQL="insert into eventlist (eventid,eventname,eventStartDate,eventFinishDate,eventBanner,eventpreview,eventContent) " + 
				"VALUES (eventlist_SEQ.nextval,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, eventname);
			pstmt.setString(2, eventStartDate);
			pstmt.setString(3, eventFinishDate);
			pstmt.setString(4, eventBanner);
			pstmt.setString(5, eventpreview);
			pstmt.setString(6, eventContent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"eventSave : "+e.getMessage());
		}
		return -1;
	}
	

	
	public int subSave(String subName,int subPrice, int subSale, String subDate, String subPhoto,String subPreview,String subContent) {
		final String SQL="insert into subProduct (subid,subName,subPrice,subSale,subDate,subPhoto,subPreview,subContent) " + 
				"VALUES (SUBPRODUCT_SEQ.nextval,?,?,?,?,?,?,?)";
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
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"subSave : "+e.getMessage());
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
	
	public int eventUpdate(String eventname, String eventStartDate,String eventFinishDate, String eventBanner,String eventpreview,String eventContent, int eventId) {
		final String SQL="update eventlist set eventname=?, eventStartDate=?, eventFinishDate=?, eventBanner=?, eventpreview=?, eventContent=? where eventid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, eventname);
			pstmt.setString(2, eventStartDate);
			pstmt.setString(3, eventFinishDate);
			pstmt.setString(4, eventBanner);
			pstmt.setString(5, eventpreview);
			pstmt.setString(6, eventContent);
			pstmt.setInt(7, eventId);
			
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"eventUpdate : "+e.getMessage());
		
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
