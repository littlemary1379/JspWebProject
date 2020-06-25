package com.dailyT.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Product;
import com.dailyT.repository.AdminRepository;

public class ProListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdminRepository adminRepository=AdminRepository.getInstance();
		List<Product> products = adminRepository.FindAllProduct();
		
		HttpSession session =request.getSession();
		session.setAttribute("products", products);
	
		RequestDispatcher dis = request.getRequestDispatcher("admin/productManageList.jsp");
		dis.forward(request, response);
	}
}
