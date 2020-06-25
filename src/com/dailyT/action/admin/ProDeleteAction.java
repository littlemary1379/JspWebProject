package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.AdminRepository;
import com.dailyT.util.Script;

public class ProDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 파라메터 받기
		int proId=Integer.parseInt(request.getParameter("proId"));
		
		//2. DB에 접근하여 삭제 시도
		AdminRepository adminRepository=AdminRepository.getInstance();
		int result=adminRepository.deletePro(proId);
		
		//3. 정상삭제 되었으면 1, 아니라면 -1을 ajax에 전달
		
		Script.ajaxText(result+"", response);
		
	}
}
