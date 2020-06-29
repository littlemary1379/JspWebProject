package com.dailyT.action.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.ClientRepository;
import com.dailyT.util.Script;

public class DeleteSubReplyAction implements Action{
	private static final String TAG="DeleteSubReplyAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파라메터 받아오기
		String replyid=request.getParameter("replyid");
		System.out.println(replyid);
		
		
		//2.DB 연결해서 삭제 연동, 결과값 전송
		ClientRepository clientRepository=ClientRepository.getInstance();
		int result=clientRepository.deleteSubReply(Integer.parseInt(replyid));
		
		System.out.println(TAG+result);
		Script.ajaxText(result+"", response);
		
	}

}
