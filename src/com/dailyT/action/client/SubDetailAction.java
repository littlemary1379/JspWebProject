package com.dailyT.action.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.dto.subReplyView;
import com.dailyT.model.SubProduct;
import com.dailyT.model.SubReply;
import com.dailyT.repository.ClientRepository;

public class SubDetailAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. get을 통해 subId를 전달받음
		String subId=request.getParameter("subId");
		
		//2. DB에 접근해 데이터 값 가져오기(상품, 덧글)
		ClientRepository clientRepository=ClientRepository.getInstance();
		SubProduct subProduct=clientRepository.findSubProductBySubID(Integer.parseInt(subId));
		List<subReplyView> subReplies=clientRepository.findSubReply(Integer.parseInt(subId));
		//3. 가져온 값을 response 하기
		request.setAttribute("subProduct", subProduct);
		request.setAttribute("subReplies", subReplies);
		RequestDispatcher dis=request.getRequestDispatcher("client/subDetail.jsp");
		dis.forward(request, response);
	}

}
