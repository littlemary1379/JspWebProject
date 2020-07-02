package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.OrderList;

public class NonUserOrderAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인증 세션이 있을 때는 바로 주문 페이지로, 인증 세션이 없으면 로그인/비회원 확인 페이지로 이동
		HttpSession session=request.getSession();
		
		if(session.getAttribute("principal")==null) {
			session.setAttribute("custid", 0);
			RequestDispatcher dis=request.getRequestDispatcher("order/orderPage.jsp");
			dis.forward(request, response);
		}else {
			return;
		}
		
	}
}
