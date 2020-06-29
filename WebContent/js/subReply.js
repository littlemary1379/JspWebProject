function deleteSubReply(replyid){
	console.log(replyid);
	
	var deletecheck=confirm("정말 삭제하시겠습니까?");
	
	if(deletecheck){
	
		$.ajax({
			type:"post",
			url:"/DailyT/client?cmd=deleteSubReply",
			data:"replyid="+replyid,
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType:"text"
		
		}).done(function(result) {
			
			var replyitem=$("#subReply-"+replyid);
			console.log(replyitem);
			replyitem.remove();
			
		}).fail(function(error){
			console.log("서버 오류");
		});
	
	}else{
		alert("삭제에 실패하셨습니다.");
	}
	
}

function writeSubReply(subid,custid) {
	if(custid==null){
		alert("로그인이 필요합니다.");
		return;
	}
	data={
			custid:custid,
			subid:subid,
			score:parseInt($('#subReply input[name="subGrade"]:checked').val()),
			content: $('#subContent').val()
	};
	
	// console.log(data);
	
	$.ajax({
		type:"post",
		url:"/DailyT/client?cmd=writeSubReply",
		data:JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType:"json"
	}).done(function(replies) {
		if(replies!=null){
			console.log(replies);
			// console.log("여긴 오는거 맞지?");
			$("#subReply-total").empty();
			renderReplyList(replies);
			alert("댓글 등록에 성공하였습니다.")
			$("#subContent").val('');
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
	// console.log(replylist);
	var replyitem = `<div id="subReply-${replylist.replyid }">`;
	replyitem += `<div class="subReply-nickname d-flex justify-content-between">`;
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
	replyitem += `<p><i onclick="deleteSubReply(${replylist.replyid });" class="fas fa fa-trash"></i></p>`;
	}
	replyitem += `</div>`;
	replyitem += `<div class="subReply-content">`;
	replyitem += `<p>${replylist.content }</p>`;
	replyitem += `</div>`;
	replyitem += `<hr />`;
	replyitem += `</div>`;
	
	return replyitem;
	
}