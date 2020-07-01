package com.dailyT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.admin.CustListAction;
import com.dailyT.action.admin.EventDeleteAction;
import com.dailyT.action.admin.EventListAction;
import com.dailyT.action.admin.EventUpdateAction;
import com.dailyT.action.admin.EventUpdateProcAction;
import com.dailyT.action.admin.EventregAction;
import com.dailyT.action.admin.EventregProcAction;
import com.dailyT.action.admin.HomeAction;
import com.dailyT.action.admin.SubDeleteAction;
import com.dailyT.action.admin.ProListAction;
import com.dailyT.action.admin.ProUpdateAction;
import com.dailyT.action.admin.ProUpdateProcAction;
import com.dailyT.action.admin.ProregAction;
import com.dailyT.action.admin.ProregProcAction;
import com.dailyT.action.admin.ProDeleteAction;
import com.dailyT.action.admin.SubListAction;
import com.dailyT.action.admin.SubUpdateAction;
import com.dailyT.action.admin.SubUpdateProcAction;
import com.dailyT.action.admin.SubregAction;
import com.dailyT.action.admin.SubregProcAction;
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
import com.dailyT.action.order.SubscribeAction;
import com.dailyT.action.order.SubscribeCheckAction;
import com.dailyT.action.order.SubscribeProcAction;
import com.dailyT.action.order.sameOrderAction;



@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG="OrderController : ";

    public OrderController() {
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
		if(cmd.equals("subscribe")) { 
			return new SubscribeAction(); //정기구독 진입 액션
		}else if(cmd.equals("sameOrder")) { 
			return new sameOrderAction(); //주문자와 로그인 한 사람이 동일할 경우 정보를 가져오는 액션
		}else if(cmd.equals("subscribeProc")) { 
			return new SubscribeProcAction(); //정기구독 등록 액션
		}else if(cmd.equals("subscribeCheck")) { 
			return new SubscribeCheckAction(); //정기구독 등록 액션
		}
		
		return null;
	}

}
