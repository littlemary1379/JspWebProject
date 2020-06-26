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

public class SubListAction implements Action {
	private static final String TAG="SubListAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String season=request.getParameter("season");

		ClientRepository clientRepository=ClientRepository.getInstance();
		if(season.equals("all")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindAllSubProduct();
			
			request.setAttribute("subProducts", subProducts);
			
			RequestDispatcher dis = request.getRequestDispatcher("client/subscribe.jsp");
			dis.forward(request, response);
			
		}else if(season.equals("origin")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindOriginSubProduct();
			
			request.setAttribute("subProducts", subProducts);
			
			RequestDispatcher dis = request.getRequestDispatcher("client/subscribe.jsp");
			dis.forward(request, response);
			
		}else if(season.equals("season")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindSeasonSubProduct();
			
			request.setAttribute("subProducts", subProducts);
			
			RequestDispatcher dis = request.getRequestDispatcher("client/subscribe.jsp");
			dis.forward(request, response);
			
		}
		
		

	}
}
