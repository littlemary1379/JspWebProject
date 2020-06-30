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



@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG="AdminController : ";

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
		}else if(cmd.equals("subreg")) { 
			return new SubregAction(); //정기구독 등록 페이지 진입 액션
		}else if(cmd.equals("subregProc")) { 
			return new SubregProcAction(); // DB 등록 액션
		}else if(cmd.equals("sublist")) { 
			return new SubListAction(); // 구독 관리 페이지 진입 액션	
		}else if(cmd.equals("subUpdate")) { 
			return new SubUpdateAction(); // 구독 수정 페이지 진입 액션	
		}else if(cmd.equals("subUpdateProc")) { 
			return new SubUpdateProcAction(); // 구독 수정 액션	
		}else if(cmd.equals("subdelete")) { 
			return new SubDeleteAction(); // 구독 삭제 페이지 진입 액션	
		}else if(cmd.equals("proreg")) { 
			return new ProregAction(); // 단품 등록 페이지 진입 액션
		}else if(cmd.equals("proregProc")) { 
			return new ProregProcAction(); // 단품 등록 액션	
		}else if(cmd.equals("prolist")) { 
			return new ProListAction(); // 단품 관리 페이지 진입 액션	
		}else if(cmd.equals("proUpdate")) { 
			return new ProUpdateAction(); // 단품 수정 페이지 진입 액션	
		}else if(cmd.equals("proUpdateProc")) { 
			return new ProUpdateProcAction(); // 단품 수정 액션	
		}else if(cmd.equals("prodelete")) { 
			return new ProDeleteAction(); // 단품 삭제 액션	
		}else if(cmd.equals("custlist")) { 
			return new CustListAction(); // 회원 관리 페이지 진입 액션	
		}else if(cmd.equals("eventreg")) { 
			return new EventregAction(); // 이벤트 등록 페이지 진입 액션
		}else if(cmd.equals("eventregProc")) { 
			return new EventregProcAction(); // 이벤트 등록 페이지 진입 액션
		}else if(cmd.equals("eventlist")) { 
			return new EventListAction(); // 이벤트 관리 페이지 진입 액션	
		}else if(cmd.equals("eventdelete")) { 
			return new EventDeleteAction(); // 구독 삭제 페이지 진입 액션	
		}else if(cmd.equals("eventUpdate")) { 
			return new EventUpdateAction(); // 단품 수정 페이지 진입 액션	
		}else if(cmd.equals("eventUpdateProc")) { 
			return new EventUpdateProcAction(); // 단품 수정 액션	
		}
		
		return null;
	}

}
