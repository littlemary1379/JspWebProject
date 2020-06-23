package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.SHA256;
import com.dailyT.util.Script;

public class JoinProcAction implements Action{
	private static final String TAG="JoinProcAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userID");
		System.out.println(userid);
		//0. 유효성 검사.
		if(request.getParameter("userID").equals(null) ||
			request.getParameter("userID").equals("") ||
			request.getParameter("password").equals(null) ||
			request.getParameter("password").equals("") ||
			request.getParameter("nickname").equals(null) ||
			request.getParameter("nickname").equals("") ||
			request.getParameter("email").equals(null) ||
			request.getParameter("email").equals("") ||
			request.getParameter("address").equals(null) ||
			request.getParameter("address").equals("") ||
			request.getParameter("cellphone").equals(null) ||
			request.getParameter("cellphone").equals("")) {
		
			Script.back("입력한 내용을 다시 확인해주세요", response);
			return;
		}
		
		if(!request.getParameter("password").equals(request.getParameter("passwordcheck"))) {
			Script.back("비밀번호 확인이 일치하지 않습니다. 다시 입력하세요.", response);
			return;
		}
		
		//1. 값을 받아 변수에 넣기.
		String userID=request.getParameter("userID");
		String rawPassword=request.getParameter("password");
		String password=SHA256.encodeSha256(rawPassword);
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String cellphone=request.getParameter("cellphone");
		
		//2.변수를 DB에 삽입
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		int result=customerRepository.save(userID, password, nickname, email, address, cellphone);
		
		//3. DB 결과에 따른 결론 도출
		
		if(result==1) {
			Script.href("회원가입에 성공하셨습니다.", "index.jsp", response);
		}else {
			Script.back("회원가입에 실패하셨습니다.", response);
		}
	}
}
