function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/DailyT/util/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}

function jusoCallBack(roadFullAddr){
		var tfAddress=document.querySelector("#address");
		tfAddress.value=roadFullAddr;

		
}