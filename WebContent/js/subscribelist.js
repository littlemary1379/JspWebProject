function sublistChange(season){
	$.ajax({
		type:"post",
		url:"/DailyT/client?cmd=sublistchange",
		data:"season="+season,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"JSON"
	}).done(function(result) {
		if(result!=null){
			$("#subscribe-items").empty();
			renderlist(result);
			$("#subscribe-items").val();			
		}else{
			alert("상품이 준비중입니다.");
		}
		
	}).fail(function(error) {
		
	});
	
}	
function renderlist(result) {
	//console.log(result);
	for (var list of result) {
		$("#subscribe-items").append(makelist(list));
	}
}

function makelist(list) {
	console.log(list);
	console.log(list.subName);
	var listitem=`<div class="subscribe-item">`;
	listitem += `<div class="subscribe-title">`;
	listitem += `<h4>${list.subName}</h4>`;
	listitem += `</div>`;
	listitem += `<hr />`;
	listitem += `<div class="subscribe-preview d-flex">`;
	listitem += `<img class="subscribe-preimage col-sm-6" src="${list.subPhoto }">`;
	listitem += `<div class="subscribe-precontent col-sm-6">`;
	listitem += `<p>${list.subPreview }</p>`;
	listitem += `<p>${list.subPrice }원</p>`;
	listitem += `</div>`;
	listitem += `</div>`;
	listitem += `<br />`;
	listitem += `<button class="subscribe-detail col-sm-12" onclick="location.href='/DailyT/client?cmd=subDetail&subId=${list.subId }'">자세히 보기</button>`;
	listitem += `<hr />`;
	listitem += `</div>`;
	
	return listitem;


	
}