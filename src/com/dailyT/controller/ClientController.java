package com.dailyT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.action.client.ProListAction;
import com.dailyT.action.client.ProListChangeAction;
import com.dailyT.action.client.SubListAction;
import com.dailyT.action.client.SubListChangeAction;
import com.dailyT.action.client.ToolListAction;
import com.dailyT.action.client.ToolListChangeAction;
import com.dailyT.action.client.WriteProReplyAction;
import com.dailyT.action.client.WriteSubReplyAction;
import com.dailyT.action.client.DeleteProReplyAction;
import com.dailyT.action.client.DeleteSubReplyAction;
import com.dailyT.action.client.ProDetailAction;
import com.dailyT.action.client.SubDetailAction;


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
		}else if(cmd.equals("deleteSubReply")) {
			return new DeleteSubReplyAction();
		}else if(cmd.equals("prolist")) {
			return new ProListAction();
		}else if(cmd.equals("prolistChange")) {
			return new ProListChangeAction();
		}else if(cmd.equals("proDetail")) {
			return new ProDetailAction();
		}else if(cmd.equals("writeProReply")) {
			return new WriteProReplyAction();
		}else if(cmd.equals("deleteProReply")) {
			return new DeleteProReplyAction();
		}else if(cmd.equals("toollist")) {
			return new ToolListAction();
		}else if(cmd.equals("toollistChange")) {
			return new ToolListChangeAction();
		}
		return null;
	}

}
