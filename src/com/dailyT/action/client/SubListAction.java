package com.dailyT.action.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.repository.AdminRepository;
import com.dailyT.repository.ClientRepository;

public class SubListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientRepository clientRepository=ClientRepository.getInstance();
		List<SubProduct> subProducts=clientRepository.FindAllSubProduct();
		
		
		request.setAttribute("subProducts", subProducts);
	
		RequestDispatcher dis = request.getRequestDispatcher("client/subscribe.jsp");
		dis.forward(request, response);
	}
}
