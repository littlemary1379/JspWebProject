package com.dailyT.action.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.Subscribe;
import com.dailyT.repository.OrderRepository;
import com.dailyT.util.Script;

public class SubscribeCheckAction implements Action{
	
	private static final String TAG="SubscribeCheckAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 세션에서 현재 로그인된 유저의 고유번호를 가져옴.
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("principal");
		int custid=customer.getCustid();
		
		
		//2. 고유번호를 통해 데베에 접근해 유저가 구독중인 제품 추출
		OrderRepository orderRepository=OrderRepository.getInstance();
		List<Subscribe> subscribes=orderRepository.FindSubscribeByCustid(custid);
		System.out.println(TAG+subscribes);
		
		//3. 결과가 있을 시 창으로 이동, 없을 시 뒤로가기.
		if (subscribes!=null) {
			request.setAttribute("subscribes", subscribes);
			RequestDispatcher dis=request.getRequestDispatcher("order/subscribeCheck.jsp");
			dis.forward(request, response);
		}else {
			Script.back("구독정보가 없습니다.", response);
		}
		
		
	}

}
