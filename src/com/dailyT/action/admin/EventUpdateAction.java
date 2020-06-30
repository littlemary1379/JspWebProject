package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Product;
import com.dailyT.repository.AdminRepository;

public class EventUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int proId=Integer.parseInt(request.getParameter("proId"));
		System.out.println(proId);
		
		AdminRepository adminRepository=AdminRepository.getInstance();
		Product product=adminRepository.findProductByProID(proId);
		
		if(product!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("product", product);
			RequestDispatcher dis = request.getRequestDispatcher("admin/productUpdate.jsp");
			dis.forward(request, response);
		}

	}
}
