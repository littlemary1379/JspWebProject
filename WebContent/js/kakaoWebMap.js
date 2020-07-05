var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(35.156217,129.0588623), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

function setDraggable() {
    // 마우스 드래그로 지도 이동 가능여부를 설정합니다
    map.setDraggable(false);    
}

setDraggable();
