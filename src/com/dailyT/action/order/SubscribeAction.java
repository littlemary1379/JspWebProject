package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.util.Script;

public class SubscribeAction implements Action {
	private static final String TAG="SubscribeAction : ";

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 유효성 검사
		HttpSession session=request.getSession();
		if(session.getAttribute("principal")==null) {
			Script.back("로그인이 필요한 서비스입니다.", response);
			return;
		}
		
		//1. 입력받은 정보를 가지고 주문창으로 이동
		String subscribeKind=request.getParameter("subName");
		String buyTerm=request.getParameter("subscribe-buy-term");
		Customer customer=(Customer)session.getAttribute("principal");
		int custid=customer.getCustid();
		System.out.println(TAG+subscribeKind);
		
		request.setAttribute("buyTerm", buyTerm);
		request.setAttribute("custid", custid);
		request.setAttribute("subscribeKind", subscribeKind);
		
		RequestDispatcher dis=request.getRequestDispatcher("order/subscribe.jsp");
		dis.forward(request, response);
		
	}

}
