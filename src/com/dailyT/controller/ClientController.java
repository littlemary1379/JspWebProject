package com.dailyT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.client.SubListAction;
import com.dailyT.action.client.SubListChangeAction;
import com.dailyT.action.client.WriteSubReplyAction;
import com.dailyT.action.client.SubDetailAction;
import com.dailyT.action.index.HomeAction;


@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG="IndexController : ";

    public ClientController() {
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
		if(cmd.equals("sublist")) {
			return new SubListAction();
		}else if(cmd.equals("sublistchange")) {
			return new SubListChangeAction();
		}else if(cmd.equals("subDetail")) {
			return new SubDetailAction();
		}else if(cmd.equals("writeSubReply")) {
			return new WriteSubReplyAction();
		}
		return null;
	}

}
