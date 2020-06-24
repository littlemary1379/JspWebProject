package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.SHA256;
import com.dailyT.util.Script;

public class CustUpdateProcAction implements Action{
	private static final String TAG="JoinProcAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 유효성 검사.
		if( request.getParameter("nickname").equals(null) ||
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
		
		
		//1. 값을 받아 변수에 넣기.
		String userID=request.getParameter("userID");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String cellphone=request.getParameter("cellphone");
		
		//2.변수를 DB에 삽입
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		int result=customerRepository.custUpdate(nickname, email, address, cellphone, userID);
		
	
		//3. DB 결과에 따른 결론 도출
		if (result==1) {
			Script.href("회원정보 수정이 완료되었습니다","/DailyT/index?cmd=home",response);
		}else {
			Script.back("회원정보 수정에 실패하였습니다.", response);
		}
	}
}
