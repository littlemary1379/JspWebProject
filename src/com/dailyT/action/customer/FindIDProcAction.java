package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.Script;
import com.dailyT.util.SendMail;

import oracle.net.aso.c;

public class FindIDProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0.유효성 검사
		
		if(request.getParameter("username").equals(null)||
			request.getParameter("username").equals("")||
			request.getParameter("email").equals(null)||
			request.getParameter("email").equals("")){
			Script.back("빈 칸을 정확히 입력하세요", response);
			
		}
		
		//1. 변수에 파라메터 값 넣기
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		
		//2. 입력받은 파라메터로 DB 접근 -> 일치하는 유저가 있는지 확인하고, ID값 가져오기
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		String userID=customerRepository.FindIDByUsernameAndEmail(username, email);
		System.out.println(userID);
		
		//3. 가져온 ID 값이 있을 경우, 메일 발송하기
		
		if(userID!=null) {
			SendMail.gmailSend(username, email, userID);
			Script.href("입력하신 이메일로 아이디를 발송했습니다.", "/DailyT/cust?cmd=login", response);
		}else {
			Script.back("입력하신 정보와 일치하는 회원이 없습니다.", response);
		}
		
	}
}
