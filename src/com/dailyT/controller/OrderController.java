package com.dailyT.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.order.CheckCartAction;
import com.dailyT.action.order.NonUserOrderAction;
import com.dailyT.action.order.OrderLoginAction;
import com.dailyT.action.order.SubscribeAction;
import com.dailyT.action.order.SubscribeCheckAction;
import com.dailyT.action.order.SubscribeProcAction;
import com.dailyT.action.order.UserCheckAction;
import com.dailyT.action.order.UserOrderAction;
import com.dailyT.action.order.addCartAction;
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
		}else if(cmd.equals("checkCart")) { 
			return new CheckCartAction(); //정기구독 등록 액션
		}else if(cmd.equals("addCart")) { 
			return new addCartAction(); //정기구독 등록 액션
		}else if(cmd.equals("userCheck")) { 
			return new UserCheckAction(); //정기구독 등록 액션
		}else if(cmd.equals("UserOrder")) { 
			return new UserOrderAction(); //정기구독 등록 액션
		}else if(cmd.equals("orderLogin")) { 
			return new OrderLoginAction(); //정기구독 등록 액션
		}else if(cmd.equals("nonUserOrder")) { 
			return new NonUserOrderAction(); //정기구독 등록 액션
		}
		
		return null;
	}

}
