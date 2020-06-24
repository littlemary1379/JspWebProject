package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;

public class PWCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0. 유효성 검사
		HttpSession session=request.getSession();
		if(session.getAttribute("principal")==null) {
			return;
		}
		RequestDispatcher dis = request.getRequestDispatcher("customer/pwCheck.jsp");
		dis.forward(request, response);
	}
}
