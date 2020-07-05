function brandChange(category){
	console.log(category);
	if(category=="brand"){
		$(".brand-img").empty();
		renderBrandStory();
	}else{
		$(".brand-img").empty();
		renderBrandMap();
	}
}

function renderBrandStory(){
	var branditem=`	<img class="col-md-12" src="/DailyT/img/brand-exam1.png" />`;
	$(".brand-img").append(branditem);
	
}

function renderBrandMap(){
	var branditem=`	<div id="map" style="width: 50%; height: 400px;"></div>`;
	branditem+= `<div class="col-md-6 align-self-center">`;
	branditem+= `<p>부산시 부산진구 중앙대로 -</p>`;
	branditem+= `<p>tel : 010-0000-1111</p>`;
	branditem+= `</div>`;
	branditem+=`	<script src="/DailyT/js/kakaoWebMap.js"></script>`;

	
	
	$(".brand-img").append(branditem);
	
}