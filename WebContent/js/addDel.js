function add(index,price) {
	addcount = $("#count-"+index).val();
	totalPrice=$("#totalPrice").text();
	//console.log(addcount);
	console.log(totalPrice);
	addcount=parseInt(addcount);
	totalPrice=parseInt(totalPrice);
	$("#count-"+index).val(addcount+1);
	$("#totalPrice").text(totalPrice+price);
	
}

function del(index,price) {
	delcount = $("#count-"+index).val();
	totalPrice=$("#totalPrice").text();
	//console.log(delcount);
	delcount=parseInt(delcount);
	totalPrice=parseInt(totalPrice);
	if (delcount> 0) {
		$("#count-"+index).val(delcount-1);
		$("#totalPrice").text(totalPrice-price);
	} else {
		alert("더 이상 수량을 내릴 수 없습니다.");
	}
}