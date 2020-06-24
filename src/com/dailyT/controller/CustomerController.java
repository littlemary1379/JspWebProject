package com.dailyT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.customer.FindIDAction;
import com.dailyT.action.customer.FindIDProcAction;
import com.dailyT.action.customer.FindPWAction;
import com.dailyT.action.customer.FindPWProcAction;
import com.dailyT.action.customer.JoinAction;
import com.dailyT.action.customer.JoinProcAction;
import com.dailyT.action.customer.LoginAction;
import com.dailyT.action.customer.LoginProcAction;
import com.dailyT.action.customer.LogoutAction;
import com.dailyT.action.customer.ResetPWAction;
import com.dailyT.action.customer.ResetPWProcAction;
import com.dailyT.action.customer.UserIDCheckAction;



@WebServlet("/cust")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG="CustomerController : ";

    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cmd=request.getParameter("cmd");
		System.out.println(TAG+cmd);
		Action action=router(cmd);
		action.execute(request, response);
	}
	
	Action router(String cmd) {
		if(cmd.equals("login")) { 
			return new LoginAction(); //로그인 페이지 진입 액션
		}else if(cmd.equals("loginProc")) {
			return new LoginProcAction(); //DB에 접근해서 실질적인 로그인을 담당하는 액션
		}else if(cmd.equals("join")) {
			return new JoinAction(); //회원가입 페이지 진입 액션 
		}else if(cmd.equals("joinProc")) {
			return new JoinProcAction(); //DB에 접근해 실질적인 회원가입을 담당하는 액션
		}else if(cmd.equals("userIDCheck")) {
			return new UserIDCheckAction(); //ID 중복검사 액션
		}else if(cmd.equals("logout")) {
			return new LogoutAction(); //로그아웃 액션
		}else if(cmd.equals("findID")) {
			return new FindIDAction(); //ID 찾는 페이지 진입 액션
		}else if(cmd.equals("findIDProc")) {
			return new FindIDProcAction(); //ID 찾는 페이지 진입 액션
		}else if(cmd.equals("findPW")) {
			return new FindPWAction(); //PW 찾는 페이지 진입 액션
		}else if(cmd.equals("findPWProc")) {
			return new FindPWProcAction(); //DB에 접근해서 존재여부 확인 후, 초기화 페이지로 보내주는 액션
		}else if(cmd.equals("resetPW")) {
			return new ResetPWAction(); //PW 초기화 페이지 진입 액션
		}else if(cmd.equals("ResetPWProc")) {
			return new ResetPWProcAction(); //DB에서 비밀번호 초기화 액션
		}
		
		
		return null;
	}

}
