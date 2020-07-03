package com.dailyT.action.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.OrderList.OrderLists;
import com.dailyT.repository.OrderRepository;
import com.dailyT.util.Script;

public class OrderProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null||session.getAttribute("orderlist")==null) {
			return;
		}
		ArrayList<OrderLists> orderlist=(ArrayList<OrderLists>)session.getAttribute("orderlist");
		int custid=(int)session.getAttribute("custid");
		String deliveryName=request.getParameter("deliveryName");
		String deliveryAddr=request.getParameter("deliveryAddr");
		String deliveryPhone=request.getParameter("deliveryPhone");
		
		System.out.println(custid);
		//System.out.println(orderlist);
		OrderRepository orderRepository=OrderRepository.getInstance();
		int result=0;
		for (OrderLists orderLists : orderlist) {
			System.out.println(orderLists);
			String orderProName=orderLists.getOrderProName();
			String orderPhoto=orderLists.getOrderPhoto();
			int orderProPrice=orderLists.getOrderProPrice();
			int count=orderLists.getCount();
			result=orderRepository.OrderSave(custid, deliveryName, deliveryAddr, deliveryPhone, orderProName, orderPhoto, orderProPrice, count);
			if(result!=1) {
				System.out.println("Repository 오류");
				return;
			}
		}
		
		Script.href("주문이 완료되었습니다.", "/DailyT/index?cmd=home", response);
	}
}
