package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.OrderList;

public class UserOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") != null) {
			
			Customer customer=(Customer)session.getAttribute("principal");
			int custid=customer.getCustid();
			session.setAttribute("custid", custid);
			
			if (session.getAttribute("orderlist") != null) {
				
				
				RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
				dis.forward(request, response);
			}else {
				System.out.println("세션 비었는디?");
				RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
				dis.forward(request, response);
			}
		}
	}
}
