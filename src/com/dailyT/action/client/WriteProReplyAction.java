package com.dailyT.action.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.dto.proReplyView;
import com.dailyT.dto.subReplyView;
import com.dailyT.model.ProReply;
import com.dailyT.model.SubReply;
import com.dailyT.repository.ClientRepository;
import com.dailyT.util.Script;
import com.google.gson.Gson;

public class WriteProReplyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Buffer을 이용해 json 데이터를 받아와서 객체 생성
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		//System.out.println(sb.toString());
		
		Gson gson = new Gson();
		ProReply proReply = gson.fromJson(sb.toString(), ProReply.class);
		//System.out.println(proReply);

		// 2. 만든 객체를 데이터베이스에 넣어서 값 저장
		ClientRepository clientRepository = ClientRepository.getInstance();
		int result = clientRepository.proReplySave(proReply);
		System.out.println(result);

		// 3. 등록에 성공했다면, 데이터베이스에 접근해 덧글목록을 가지고와서 가져가기.
		if (result == 1) {
			List<proReplyView> proReplies = clientRepository.findProReply(proReply.getProid());
			Gson gson2=new Gson();
			String replies=gson2.toJson(proReplies);
			Script.ajaxJson(replies, response);
		}else {
			Script.ajaxText("error", response);
		}

	}
}
