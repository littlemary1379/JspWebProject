package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;

public class EventregAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=request.getRequestDispatcher("admin/eventRegist.jsp");
		dis.forward(request, response);
		
	}
}
