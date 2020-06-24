package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.SHA256;
import com.dailyT.util.Script;

public class LoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 유효성 검사
		
		if (request.getParameter("userID").equals(null)||
			request.getParameter("userID").equals("")||
			request.getParameter("password").equals(null)||
			request.getParameter("password").equals("")) {
			Script.back("아이디와 비밀번호를 입력해주세요.", response);
		}
		
		//1. 변수에 post 값 가져오기.
		String userID = request.getParameter("userID");
		String rawPassword=request.getParameter("password");
		String password=SHA256.encodeSha256(rawPassword);
		
		//2. 데이터베이스에 유저와 일치하는 값이 있는지 확인하고, 모델에 유저의 정보 넣기
		
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		Customer cust=customerRepository.findByUserIDandPassword(userID, password);
		
		//3. 세션에 받아온 모델 값을 넣어서 세션 유지시키기
		
		if (cust!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("principal", cust);
			
			Script.href("로그인에 성공하셨습니다.", "index.jsp", response);
		}else {
			Script.back("로그인에 실패하셨습니다.", response);
		}
	}
}
