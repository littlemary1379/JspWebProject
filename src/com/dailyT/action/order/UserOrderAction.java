package com.dailyT.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.OrderList;
import com.dailyT.repository.CustomerRepository;
import com.dailyT.util.SHA256;
import com.dailyT.util.Script;

public class UserOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") != null) {

			Customer customer = (Customer) session.getAttribute("principal");
			int custid = customer.getCustid();
			System.out.println(custid);
			session.setAttribute("custid", custid);

			if (session.getAttribute("orderlist") != null) {

				RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
				dis.forward(request, response);
			} else {

				RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
				dis.forward(request, response);
			}
		} else {
			if (request.getParameter("userID").equals(null) || request.getParameter("userID").equals("")
					|| request.getParameter("password").equals(null) || request.getParameter("password").equals("")) {
				Script.back("아이디와 비밀번호를 입력해주세요.", response);
			}

			// 1. 변수에 post 값 가져오기.
			String userID = request.getParameter("userID");
			String rawPassword = request.getParameter("password");
			String password = SHA256.encodeSha256(rawPassword);

			// 2. 데이터베이스에 유저와 일치하는 값이 있는지 확인하고, 모델에 유저의 정보 넣기

			CustomerRepository customerRepository = CustomerRepository.getInstance();
			Customer cust = customerRepository.findByUserIDandPassword(userID, password);

			// 3. 세션에 받아온 모델 값을 넣어서 세션에 넣어 이동

			if (cust != null) {

				int custid = cust.getCustid();
				session.setAttribute("custid", custid);
				session.setAttribute("principal", cust);
				System.out.println("세션 만드는데까진 성공함");
				System.out.println(cust.getUserrole());

				if (cust.getUserrole().equals("관리자")) {

					Script.href("반갑습니다, 관리자님.", "/DailyT/admin?cmd=home", response);
					
				} else {
					if (session.getAttribute("orderlist") != null) {

						RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
						dis.forward(request, response);
						
					} else {

						RequestDispatcher dis = request.getRequestDispatcher("order/orderPage.jsp");
						dis.forward(request, response);
						
					}

				}
			} else {
				Script.back("로그인에 실패하셨습니다.", response);
			}

		}
	}
}
