function sameOrder(custid) {
	//console.log(custid);
	$.ajax({
		type:"post",
		url:"/DailyT/order?cmd=sameOrder",
		data:"custid="+custid,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
			
	}).done(function(result) {
		console.log(result);
		$("#deliveryName").val(result.username);
		$("#deliveryAddr").val(result.address);
		$("#deliveryPhone").val(result.cellphone);
		
	}).fail(function() {
		console.log("서버 오류")
	})
}