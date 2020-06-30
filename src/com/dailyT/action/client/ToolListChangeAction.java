package com.dailyT.action.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.repository.ClientRepository;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class ToolListChangeAction implements Action {
	private static final String TAG="ToolListChangeAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. category 파라메터 받아오기
		String category=request.getParameter("category");
		System.out.println(TAG+category);
		
		//2. 파라메터에 따라 다른 DB값 호출하기
		
		ClientRepository clientRepository=ClientRepository.getInstance();
		
		//category에서 받아오는 값이 '전체' 라면 도구 전체를, '다구'라면 다구만, '스타터팩'라면 패키지만 호출
		if(category.equals("전체")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindAllToolProduct();
			
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}else if(category.equals("패키지")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct(category);
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}else if(category.equals("다구")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct(category);
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}
		
	}
}
