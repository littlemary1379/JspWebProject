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
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class ToolListAction implements Action {
	private static final String TAG="ToolListAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");

		ClientRepository clientRepository=ClientRepository.getInstance();
		if(category.equals("all")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindAllToolProduct();
			
			request.setAttribute("products", products);
			//System.out.println("products : "+products.get(0).getProPhoto());
			
			RequestDispatcher dis = request.getRequestDispatcher("client/tool.jsp");
			dis.forward(request, response);
			
		}else if(category.equals("package")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectToolProduct("패키지");
			
			request.setAttribute("products", products);
			
			RequestDispatcher dis = request.getRequestDispatcher("client/tool.jsp");
			dis.forward(request, response);
			
		}else if(category.equals("tool")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct("다구");
			
			request.setAttribute("products", products);
			
			RequestDispatcher dis = request.getRequestDispatcher("client/tool.jsp");
			dis.forward(request, response);
			
		}
		
	}
}
