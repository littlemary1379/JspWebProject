package com.dailyT.action.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.OrderList;
import com.dailyT.model.OrderList.OrderLists;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class AddCartAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("principal");
		
		//1. 세션에 장바구니가 기존에 없으면 새 바구니를, 없었으면 바구니에 기존 물품을 추가한다.
		ArrayList<OrderLists> orderList=null;
		if(session.getAttribute("orderlist")==null) {
			orderList=new ArrayList<OrderLists>();
		}else {
			orderList=(ArrayList<OrderLists>)session.getAttribute("orderlist");
		}
		
		//2.buffer을 이용해 데이터를 불러온다.
		BufferedReader br=request.getReader();
		StringBuffer sb=new StringBuffer();
		String input=null;
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
	
		//System.out.println(sb.toString());
		
		Gson gson=new Gson();
		OrderLists order=gson.fromJson(sb.toString(), OrderList.OrderLists.class);
		//System.out.println(order);
		
		//3. 변수를 넣는다.
	
		orderList.add(order);
		System.out.println(orderList);
		
		session.setAttribute("orderlist", orderList);
		
		//4. 페이지로 돌아가 결과를 도출한다.
		Script.ajaxText("result", response);
		
		
	}
}
