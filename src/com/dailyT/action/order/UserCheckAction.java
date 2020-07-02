package com.dailyT.action.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.OrderList.OrderLists;
import com.dailyT.util.Script;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존 장바구니 값을 새 세션에 저장하기
		HttpSession session=request.getSession();

		BufferedReader br=request.getReader();
		StringBuilder sb=new StringBuilder();
		String input=null;
		
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
		System.out.println(sb);
		Gson gson=new Gson();
		Type token = TypeToken.getParameterized(ArrayList.class, OrderLists.class, OrderLists.class).getType();
		ArrayList<OrderLists> carts = gson.fromJson(sb.toString(), token);
		System.out.println(carts);

		session.setAttribute("orderlist", carts);

		
		//System.out.println(cartList);
		
		//인증 세션이 있을 때는 바로 주문 페이지로, 인증 세션이 없으면 로그인/비회원 확인 페이지로 이동
		
		
		if(session.getAttribute("principal")==null) {
			System.out.println("세션 없음");
			Script.ajaxText("0", response);
			
		}else {
			System.out.println("세션 있음");
			Script.ajaxText("1", response);
		}
		
	}
}
