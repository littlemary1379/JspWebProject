function finishSubscribe(rawdate) {
	var arr1=rawdate.split('/');
	console.log(arr1[0]);
	var date1=new Date(arr1[2],arr1[0],arr1[1]);
	console.log(date1);
	
	var finishdate=(date1.getMonth()+3)+"/"+date1.getDate()+"/"+date1.getFullYear();
	console.log(finishdate);
	document.write(finishdate);
}