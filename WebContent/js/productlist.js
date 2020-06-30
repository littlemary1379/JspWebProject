function prolistChange(category){
	$.ajax({
		type:"post",
		url:"/DailyT/client?cmd=prolistChange",
		data:"category="+category,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"JSON"
	}).done(function(result) {
		if(result!=null){
			$("#products-category").empty();
			renderlist(result);
			$("#products-category").val();			
		}else{
			alert("상품이 준비중입니다.");
		}
		
	}).fail(function(error) {
		
	});
	
}	
function renderlist(result) {
	//console.log(result);
	for (var list of result) {
		$("#products-category").append(makelist(list));
	}
}

function makelist(list) {
	console.log(list);
	console.log(list.proName);
	var listitem=`<div class="card" style="width: 400px">`;
	listitem += `<img class="card-img-top" src="${list.proPhoto }" alt="Card image" style="width: 100%">`;
	listitem += `<div class="card-body">`;
	listitem += `<h4 class="card-title">${list.proName }</h4>`;
	listitem += `<p class="card-text">${list.preview }</p>`;
	listitem += `<a href="#" class="btn btn-primary stretched-link">자세히 보기</a>`;
	listitem += `</div>`;
	listitem += `</div>`;

	
	return listitem;


	
}