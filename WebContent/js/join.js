var usernamechecked=false;

function validate(){
	if(!usernamechecked){
		alert("ID 중복체크를 하십시오.");
	}
	return usernamechecked;
}

function usernamecheck() {
	var tfUsername=$("#userID").val();
	console.log(tfUsername);

	$.ajax({
		type:'get',
		url : `/DailyT/cust?cmd=userIDCheck&userID=${tfUsername}`
}).done(function(result) {
	if(result==1){
		alert("중복되는 ID가 있습니다.");
	}else{
		alert("중복되는 ID가 없습니다.");
		usernamechecked=true;
	}
	
	
}).fail(function(error) {
	console.log(error);
});
	
}