package com.dailyT.action.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dailyT.action.Action;
import com.dailyT.repository.CustomerRepository;

public class UserIDCheckAction implements Action {
	private static final String TAG="UserIDCheckAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//0. 유효성 검사
		
		if(request.getParameter("userID").equals(null) ||
			request.getParameter("userID").equals("")) {
			return;
		}
		
		String userID=request.getParameter("userID");
		System.out.println(TAG+userID);
		
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		int result=customerRepository.userIDCheck(userID);
		
		PrintWriter out=response.getWriter();
		out.print(result);
	}
}
