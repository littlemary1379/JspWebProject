package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.repository.AdminRepository;

public class SubUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int subId=Integer.parseInt(request.getParameter("subId"));
		System.out.println(subId);
		
		AdminRepository adminRepository=AdminRepository.getInstance();
		SubProduct subproduct=adminRepository.findSubProductBySubID(subId);
		
		if(subproduct!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("subproduct", subproduct);
			RequestDispatcher dis = request.getRequestDispatcher("admin/subUpdate.jsp");
			dis.forward(request, response);
		}

	}
}
