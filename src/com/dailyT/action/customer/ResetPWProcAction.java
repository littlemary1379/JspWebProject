package com.dailyT.action.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.SHA256;
import com.dailyT.util.Script;

public class ResetPWProcAction implements Action {
	private static final String TAG = "ResetPWProcAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 유효성 검사
		HttpSession session=request.getSession();
		if(session.getAttribute("FindPWSession")==null) {
			System.out.println(TAG+"세션 오류");
			return;
		}
		
		//1. 파라메터에서 값 가져오기
		String userID=session.getAttribute("FindPWSession").toString();
		String rawPassword=request.getParameter("resetPW");
		String passwordCheck=request.getParameter("resetPWCheck");
		
		//2. 이 비밀번호가 서로 같지 않을 경우, 원래 화면으로 되돌리기
		if(!rawPassword.equals(passwordCheck)) {
			Script.back("입력하신 비밀번호가 서로 일치하지 않습니다.", response);
			return;
		}
		
		//3. 비밀번호가 일치할 경우, 비밀번호 해싱 후 DB에 접근하여 비밀번호 업데이트 하기
		String password=SHA256.encodeSha256(rawPassword);
		CustomerRepository customerRepository=CustomerRepository.getInstance();
		int result=customerRepository.resetPW(password, userID);
		System.out.println(TAG+"result : "+result);
		
		//4. 정상적으로 업데이트가 되었으면 로그인 화면, 업데이트 되지 않을경우 되돌아가기
		if(result==1) {
			Script.href("비밀번호가 성공적으로 변경되었습니다.", "/DailyT/cust?cmd=login", response);
		}else {
			Script.back("비밀번호 변경에 실패했습니다.", response);
		}
		
		
		}
}
