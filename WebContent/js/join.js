var userIDchecked=false;

function validate(){
	if(!userIDchecked){
		alert("ID 중복체크를 하십시오.");
	}
	return userIDchecked;
}

function usernamecheck() {
	var tfUserID=$("#userID").val();
	console.log(tfUserID);

	$.ajax({
		type:'get',
		url : `/DailyT/cust?cmd=userIDCheck&userID=${tfUserID}`
}).done(function(result) {
	if(result==1){
		alert("중복되는 ID가 있습니다.");
	}else{
		alert("중복되는 ID가 없습니다.");
		userIDchecked=true;
	}
	
	
}).fail(function(error) {
	console.log(error);
});
	
}