function today(){
	let today = new Date();   

	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1;  // 월
	let date = today.getDate();  // 날짜

	let day = month + '/' + date + '/' + year;
	console.log(day);
	$("#startDate").val(day);
}

today();