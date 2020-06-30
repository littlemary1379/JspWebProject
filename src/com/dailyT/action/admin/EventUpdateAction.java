package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Event;
import com.dailyT.model.Product;
import com.dailyT.repository.AdminRepository;

public class EventUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int eventId=Integer.parseInt(request.getParameter("eventId"));
		System.out.println(eventId);
		
		AdminRepository adminRepository=AdminRepository.getInstance();
		Event event=adminRepository.findEventByEventId(eventId);
		
		if(event!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("event", event);
			RequestDispatcher dis = request.getRequestDispatcher("admin/eventUpdate.jsp");
			dis.forward(request, response);
		}

	}
}
