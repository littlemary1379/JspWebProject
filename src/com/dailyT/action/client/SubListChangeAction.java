package com.dailyT.action.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.model.SubProduct;
import com.dailyT.repository.ClientRepository;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class SubListChangeAction implements Action {
	private static final String TAG="SubListChangeAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. season 파라메터 받아오기
		String season=request.getParameter("season");
		System.out.println(TAG+season);
		
		//2. 파라메터에 따라 다른 DB값 호출하기
		
		ClientRepository clientRepository=ClientRepository.getInstance();
		
		//season에서 받아오는 값이 '전체'라면 전체를, '기본'이라면 판매종료 기간이 없는 값, '시즌'이라면 판매종료 기간이 있는 값을 도출
		if(season.equals("전체")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindAllSubProduct();
			
			Gson gson=new Gson();
			String result=gson.toJson(subProducts);
			Script.ajaxJson(result, response);
			
		}else if(season.equals("정기")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindOriginSubProduct();
			Gson gson=new Gson();
			String result=gson.toJson(subProducts);
			Script.ajaxJson(result, response);
			
		}else if(season.equals("시즌")) {
			System.out.println(TAG+season+" 값 확인됨.");
			List<SubProduct> subProducts=clientRepository.FindSeasonSubProduct();
			Gson gson=new Gson();
			String result=gson.toJson(subProducts);
			Script.ajaxJson(result, response);
			
		}
		
		
	}
}
