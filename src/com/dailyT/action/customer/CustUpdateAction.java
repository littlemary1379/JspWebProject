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

public class CustUpdateAction implements Action{
	private static final String TAG="CustUpdateAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 유효성 검사
		HttpSession session=request.getSession();
		if(session.getAttribute("principal")==null) {
			return;
		}
		
		//1. 세션에 있는 custid 값과 비밀번호를 이용해 기존 비밀번호를 가져오기
		Customer customer=(Customer)session.getAttribute("principal");
		int custid=customer.getCustid();
		
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		String resultPassword=customerRepository.FindPWByCustid(custid);
		
		//2.입력받은 비밀번호를 해싱하기
		String rawPassword=request.getParameter("password");
		String password=SHA256.encodeSha256(rawPassword);
	
		//3.해싱한 비밀번호를 대조하여 일치하면 수정 페이지로, 아니라면 되돌아가기
		if(password.equals(resultPassword)) {
			Script.href("customer/update.jsp", response);
		}else {
			Script.back("비밀번호가 일치하지 않습니다.", response);
		}
		
	}
}
