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

public class SubUpdateProcAction implements Action {
	private static final String TAG="SubUpdateProcAction : ";

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업로드할 파일의 경로를 지정하고, 받아와야할 request 값을 cos 라이브러리로 불러옴
		String realPath = request.getServletContext().getRealPath("upload");

		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 5, "UTF-8",
					new DefaultFileRenamePolicy());

			// 유효성 검사
			if (multi.getParameter("subName").equals("") || multi.getParameter("subName").equals(null)
					|| multi.getParameter("subPrice").equals("") || multi.getParameter("subPrice").equals(null)
					|| multi.getParameter("subSale").equals("") || multi.getParameter("subSale").equals(null)
					|| multi.getFilesystemName("subPhoto").equals("") || multi.getFilesystemName("subPhoto").equals(null)
					|| multi.getParameter("subContent").equals("") || multi.getParameter("subContent").equals(null)) {

				Script.back("빈 값이 있습니다. 채워주세요 ^^", response);
				return;
			}

			// 2. 변수에 받아온 값 넣기
			int subId = Integer.parseInt(multi.getParameter("subId"));
			String subName = multi.getParameter("subName");
			int subPrice = Integer.parseInt(multi.getParameter("subPrice"));
			// integer 파싱용
			int subSale = 0;
			if (multi.getParameter("subSale") == null || multi.getParameter("subSale").equals("")) {
				subSale = 0;
			} else {
				subSale = Integer.parseInt(multi.getParameter("subSale"));
			}
			String subDate = multi.getParameter("subDate");
			String subPhoto = multi.getFilesystemName("subPhoto");
			String subContent = multi.getParameter("subContent");

			
			//3. 데이터베이스에 변수 넣어서 업데이트 실행
			AdminRepository adminRepository=AdminRepository.getInstance();
			int result=adminRepository.subproductUpdate(subName, subPrice, subSale, subDate, subPhoto, subContent, subId);
			
			
			//4. 결과값에 따라, 수정이 되었으면 리스트로 돌려놓고, 수정이 되지 않을 시 스크립트백
			if(result==1) {
				Script.href("수정이 반영되었습니다","/DailyT/admin?cmd=sublist",response);
				
			}else {
				Script.back("수정이 실패했습니다.", response);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"로직 오류");
		}
	}
}
