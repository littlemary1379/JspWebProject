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

public class ProListChangeAction implements Action {
	private static final String TAG="ProListChangeAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. season 파라메터 받아오기
		String category=request.getParameter("category");
		System.out.println(TAG+category);
		
		//2. 파라메터에 따라 다른 DB값 호출하기
		
		ClientRepository clientRepository=ClientRepository.getInstance();
		
		//category에서 받아오는 값이 '전체' 라면 잎차 전체를, '홍차'라면 홍차만, '녹차'라면 녹차만, '백차'라면 백차만 도출
		if(category.equals("전체")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindAllTeaProduct();
			
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}else if(category.equals("홍차")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct(category);
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}else if(category.equals("녹차")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct(category);
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}else if(category.equals("백차")) {
			System.out.println(TAG+category+" 값 확인됨.");
			List<Product> products=clientRepository.FindSelectTeaProduct(category);
			Gson gson=new Gson();
			String result=gson.toJson(products);
			Script.ajaxJson(result, response);
			
		}
		
		
	}
}
