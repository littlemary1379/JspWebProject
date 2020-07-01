package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.repository.OrderRepository;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class sameOrderAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1.custid 가져오기
		int custid=Integer.parseInt(request.getParameter("custid"));
		//System.out.println(custid);
		
		
		//2.이걸 바탕으로 데베에 접속해서 주소, 이름, 휴대폰 번호 가져오기
		OrderRepository orderRepository=OrderRepository.getInstance();
		Customer sameOrder=orderRepository.FindCustomerById(custid);
		
		
		//3.이걸 ajax로 가져가기
		if (sameOrder!=null) {
			Gson gson=new Gson();
			String jsonSameOrder=gson.toJson(sameOrder);
			Script.ajaxJson(jsonSameOrder, response);
		}else {
			Script.ajaxText("error", response);
		}
	}
}
