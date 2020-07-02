function UpdateCart(endPoint) {
	var orderCartList=new Array();
	for (var i = 0; i < endPoint; i++) {
		var ordercart = {
				orderProName : $("#itemname-"+i).text(),
				orderPhoto : $("#itemimage-"+i).attr("src"),
				orderProPrice : $("#itemprice-"+i).text(),
				count : $("#count-"+i).val()
		}
		
		orderCartList.push(ordercart);
		
	}
	
	//var cartList=JSON.parse(JSON.stringify(orderCartList));

	//console.log(cartList);
	$.ajax({
		type:"post",
		url:"/DailyT/order?cmd=userCheck",
		data:JSON.stringify(orderCartList),
		contentType: "application/json; charset=utf-8",
		dataType:"text"
		
	}).done(function(result) {
		
		var sessionCheck=result;
		console.log(sessionCheck);
		if(sessionCheck==0){
			alert("로그인 페이지로 이동합니다.");
			location.href='/DailyT/order?cmd=orderLogin';
		}else{
			location.href='/DailyT/order?cmd=UserOrder';
		}
		
	}).fail(function(error) {
		console.log("서버 오류");
	});
	
}