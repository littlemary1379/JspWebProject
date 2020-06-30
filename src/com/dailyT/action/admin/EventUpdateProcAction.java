package com.dailyT.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyT.action.Action;
import com.dailyT.repository.AdminRepository;
import com.dailyT.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EventUpdateProcAction implements Action {
	private static final String TAG = "ProUpdateProcAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업로드할 파일의 경로를 지정하고, 받아와야할 request 값을 cos 라이브러리로 불러옴
		String realPath = request.getServletContext().getRealPath("img");
		String ContextPath = request.getServletContext().getContextPath();

		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 5, "UTF-8",
					new DefaultFileRenamePolicy());

			// 유효성 검사
			if (multi.getParameter("eventname").equals("")||
					multi.getParameter("eventname").equals(null)||
					multi.getParameter("eventStartDate").equals("")||
					multi.getParameter("eventStartDate").equals(null)||
					multi.getParameter("eventFinishDate").equals("")||
					multi.getParameter("eventFinishDate").equals(null)||
					multi.getFilesystemName("eventBanner").equals("")||
					multi.getFilesystemName("eventBanner").equals(null)||
					multi.getParameter("eventpreview").equals("")||
					multi.getParameter("eventpreview").equals(null)||
					multi.getParameter("eventContent").equals("")||
					multi.getParameter("eventContent").equals(null)) {
					
					Script.back("빈 값이 있습니다. 채워주세요 ^^", response);
					return;
				}

			// 2. 변수에 받아온 값 넣기
			int eventId=Integer.parseInt(multi.getParameter("eventId"));
			String eventname=multi.getParameter("eventname");
			String eventStartDate=multi.getParameter("eventStartDate");
			String eventFinishDate=multi.getParameter("eventFinishDate");
			String eventBanner=ContextPath+"/img/"+multi.getFilesystemName("eventBanner");
			String eventpreview=multi.getParameter("eventpreview");
			String eventContent=multi.getParameter("eventContent");

			// 3. 데이터베이스에 변수 넣어서 업데이트 실행
			AdminRepository adminRepository = AdminRepository.getInstance();
			int result = adminRepository.eventUpdate(eventname, eventStartDate, eventFinishDate, eventBanner, eventpreview, eventContent, eventId);

			// 4. 결과값에 따라, 수정이 되었으면 리스트로 돌려놓고, 수정이 되지 않을 시 스크립트백
			if (result == 1) {
				Script.href("수정이 반영되었습니다", "/DailyT/admin?cmd=eventlist", response);

			} else {
				Script.back("수정이 실패했습니다.", response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "로직 오류");
		}
	}
}
