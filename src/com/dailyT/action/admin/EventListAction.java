package com.dailyT.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Event;
import com.dailyT.model.Product;
import com.dailyT.repository.AdminRepository;

public class EventListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdminRepository adminRepository=AdminRepository.getInstance();
		List<Event> events = adminRepository.FindAllEvent();
		
		HttpSession session =request.getSession();
		session.setAttribute("events", events);
	
		RequestDispatcher dis = request.getRequestDispatcher("admin/eventManageList.jsp");
		dis.forward(request, response);
	}
}
