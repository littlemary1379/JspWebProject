package com.dailyT.action.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyT.action.Action;
import com.dailyT.model.Customer;
import com.dailyT.model.Event;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.repository.AdminRepository;
import com.dailyT.repository.ClientRepository;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class EventListAction implements Action {
	private static final String TAG = "EventListAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientRepository clientRepository = ClientRepository.getInstance();

		List<Event> events = clientRepository.FindAllEvent();

		request.setAttribute("events", events);
		// System.out.println("products : "+products.get(0).getProPhoto());

		RequestDispatcher dis = request.getRequestDispatcher("client/event.jsp");
		dis.forward(request, response);

	}
}
