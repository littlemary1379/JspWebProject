package com.dailyT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.admin.HomeAction;
import com.dailyT.action.customer.CustUpdateAction;
import com.dailyT.action.customer.CustUpdateProcAction;
import com.dailyT.action.customer.FindIDAction;
import com.dailyT.action.customer.FindIDProcAction;
import com.dailyT.action.customer.FindPWAction;
import com.dailyT.action.customer.FindPWProcAction;
import com.dailyT.action.customer.JoinAction;
import com.dailyT.action.customer.JoinProcAction;
import com.dailyT.action.customer.LoginAction;
import com.dailyT.action.customer.LoginProcAction;
import com.dailyT.action.customer.LogoutAction;
import com.dailyT.action.customer.PWCheckAction;
import com.dailyT.action.customer.ResetPWAction;
import com.dailyT.action.customer.ResetPWProcAction;
import com.dailyT.action.customer.UserIDCheckAction;



@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG="CustomerController : ";

    public AdminController() {
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
		if(cmd.equals("home")) { 
			return new HomeAction(); //관리자 홈페이지 진입 액션
		}
		
		
		return null;
	}

}
