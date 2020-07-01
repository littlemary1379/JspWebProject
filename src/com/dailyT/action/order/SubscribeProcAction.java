package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.repository.OrderRepository;
import com.dailyT.util.Script;

public class SubscribeProcAction implements Action{
	private static final String TAG="SubscribeProcAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("principal");
		
		//1. 변수 가져오기
		int subscribeTerm=Integer.parseInt(request.getParameter("term").replaceAll("[^0-9]",""));		
		int custid=customer.getCustid();
		String subscribeName=request.getParameter("deliveryName");
		String subscribeDate=request.getParameter("startDate");
		String subscribeAddr=request.getParameter("deliveryAddr");
		String subscribePhone=request.getParameter("deliveryPhone");
	
		
		//2. 변수를 가지고 DB등록
		OrderRepository orderRepository=OrderRepository.getInstance();
		int result=orderRepository.subscribeSave(custid, subscribeName, subscribeDate, subscribeTerm, subscribeAddr, subscribePhone);
		
		//3. 결과에 따라 페이지 이동
		if(result==1){
			Script.href("정기구독 신청을 완료하였습니다.", "/DailyT/index?cmd=home", response);
		}else {
			Script.back("정기구독 신청에 실패했습니다.", response);
		}
	}

}
