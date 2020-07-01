function addCart(proName,proPhoto,proPrice){
	data={
		orderProName:proName,
		orderPhoto:proPhoto,
		orderProPrice:proPrice,
		count:$("#amount").val()
	};
	console.log(data);
	if(data.count==null||data.count==""||data.count=="0"){
		alert("수량을 입력해주세요")
		return;
	};
	
	$.ajax({
		type:"post",
		url:"/DailyT/order?cmd=addCart",
		data:JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType:"text"
		
	}).done(function(result) {
		alert("장바구니에 상품이 담겼습니다.");
	}).fail(function() {
		
	});
}