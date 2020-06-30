	function eventDelete(eventId) {
		console.log(eventId);
		$.ajax({
			type:"post",
			url:"/DailyT/admin?cmd=eventdelete",
			data:"eventId="+eventId,
			contentType:"application/x-www-form-urlencoded; charset=utf-8",
			dataType:"text"
			
		}).done(function (result) {
			if(result==1){
				var deleteCheck=confirm("정말 삭제하시겠습니까?");
					if(deleteCheck){
						var event=$("#events-"+eventId);
						event.remove();
						alert("상품이 목록에서 삭제되었습니다.");
					}else{
						alert("상품 삭제 취소");
					}

			}else{
				console.log("삭제 실패");
			}
			
			
		}).fail(function (error) {
			console.log("오류 발생");
		});
	}


