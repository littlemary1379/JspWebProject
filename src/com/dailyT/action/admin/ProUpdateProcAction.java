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

public class ProUpdateProcAction implements Action {
	private static final String TAG="ProUpdateProcAction : ";

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업로드할 파일의 경로를 지정하고, 받아와야할 request 값을 cos 라이브러리로 불러옴
		String realPath = request.getServletContext().getRealPath("upload");

		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 5, "UTF-8",
					new DefaultFileRenamePolicy());

			// 유효성 검사
			if (multi.getParameter("proname").equals("") || multi.getParameter("proname").equals(null)
					|| multi.getParameter("proPrice").equals("") || multi.getParameter("proPrice").equals(null)
					|| multi.getParameter("proSale").equals("") || multi.getParameter("proSale").equals(null)
					|| multi.getParameter("prokind").equals("") || multi.getParameter("prokind").equals(null)
					|| multi.getFilesystemName("proPhoto").equals("") || multi.getFilesystemName("proPhoto").equals(null)
					|| multi.getFilesystemName("preview").equals("") || multi.getFilesystemName("preview").equals(null)
					|| multi.getParameter("proContent").equals("") || multi.getParameter("proContent").equals(null)) {

				Script.back("빈 값이 있습니다. 채워주세요 ^^", response);
				return;
			}

			// 2. 변수에 받아온 값 넣기
			int proId = Integer.parseInt(multi.getParameter("proId"));
			String proname = multi.getParameter("proname");
			int proPrice = Integer.parseInt(multi.getParameter("proPrice"));
			// integer 파싱용
			int proSale = 0;
			if (multi.getParameter("proSale") == null || multi.getParameter("proSale").equals("")) {
				proSale = 0;
			} else {
				proSale = Integer.parseInt(multi.getParameter("proSale"));
			}
			String prokind = multi.getParameter("prokind");
			int proStock = Integer.parseInt(multi.getParameter("proStock"));
			String proDate = multi.getParameter("proDate");
			String proPhoto = multi.getFilesystemName("proPhoto");
			String preview = multi.getFilesystemName("preview");
			String proContent = multi.getParameter("proContent");

			
			//3. 데이터베이스에 변수 넣어서 업데이트 실행
			AdminRepository adminRepository=AdminRepository.getInstance();
			int result=adminRepository.productUpdate(proname, proPrice, proSale, prokind, proStock, proDate, proPhoto, preview, proContent, proId);
			
			//4. 결과값에 따라, 수정이 되었으면 리스트로 돌려놓고, 수정이 되지 않을 시 스크립트백
			if(result==1) {
				Script.href("수정이 반영되었습니다","/DailyT/admin?cmd=prolist",response);
				
			}else {
				Script.back("수정이 실패했습니다.", response);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"로직 오류");
		}
	}
}
