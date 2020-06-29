function deleteSubReply(){
	
}

function writeSubReply(custid,subid) {

	data={
			custid:custid,
			subid:subid,
			score:parseInt($('#subReply input[name="subGrade"]:checked').val()),
			content: $('#subContent').val()
	};
	
	//console.log(data);
	
	$.ajax({
		type:"post",
		url:"/DailyT/client?cmd=writeSubReply",
		data:JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType:"json"
	}).done(function(replies) {
		if(replies!=null){
			console.log(replies);
			//console.log("여긴 오는거 맞지?");
			$("#subReply-total").empty();
			renderReplyList(replies);
			$("#subReply-total").val();
		}
	}).fail(function(error) {
		console.log(error);
	});
}
function renderReplyList(replies){
	for (let replylist of replies) {
		$("#subReply-total").append(addReplyList(replylist));
	}
}
function addReplyList(replylist){
	//console.log(replylist);
	var replyitem=`<div class="subReply-nickname d-flex justify-content-between">`;
	replyitem += `<p>${replylist.nickname } /`;
	if(replylist.score==1){
		replyitem += `★☆☆☆☆`;
	}else if(replylist.score==2){
		replyitem += `★★☆☆☆`;
	}else if(replylist.score==3){
		replyitem += `★★★☆☆`;
	}else if(replylist.score==4){
		replyitem += `★★★★☆`;
	}else if(replylist.score==5){
		replyitem += `★★★★★`;
	}
	replyitem += `</p>`;
	if(data.custid==replylist.custid){
	replyitem += `<p><i class="fas fa fa-trash"></i></p>`;
	}
	replyitem += `</div>`;
	replyitem += `<div class="subReply-content">`;
	replyitem += `<p>${replylist.content }</p>`;
	replyitem += `</div>`;
	replyitem += `<hr />`;

	return replyitem;
	
}