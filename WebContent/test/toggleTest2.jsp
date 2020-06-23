<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DailyT Ȩ�������Դϴ�.</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/nav.css">
<link rel="stylesheet" href="../css/home.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<style>




</style>

<script>

$(document).ready(function(){  
  		  
		$(".nav-item2").hover(function() { //���콺�� topnav�� ������
			$(this).parent().find(".detail-nav2").slideDown('normal').show(); 
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".detail-nav2").slideUp('fast'); //subnav���� ���콺 ����� �� ����ġ��Ŵ  
			});  
		});  
	  
	});

$(document).ready(function(){  
	$(".nav-item3").hover(function() { //���콺�� topnav�� ������
		$(this).parent().find(".detail-nav3").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav3").slideUp('fast'); //subnav���� ���콺 ����� �� ����ġ��Ŵ  
		});  
	});  
});  

$(document).ready(function(){  
	  
	$(".nav-item4").hover(function() { //���콺�� topnav�� ������
		$(this).parent().find(".detail-nav4").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav4").slideUp('fast'); //subnav���� ���콺 ����� �� ����ġ��Ŵ  
		});  
	});  
  
});  

$(document).ready(function(){  
	  
	$(".nav-item5").hover(function() { //���콺�� topnav�� ������
		$(this).parent().find(".detail-nav5").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav5").slideUp('fast'); //subnav���� ���콺 ����� �� ����ġ��Ŵ  
		});  
	});  
  
});  
	
</script>

</head>
<body>
	<div class="container-fluid">
		<!-- �α���, ȸ������, ��ٱ��� ������̼� -->
		<div class="nav1">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="#">�α���</a></li>
				<li class="nav-item"><a class="nav-link" href="#">ȸ������</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa fa-shopping-cart"></i></a></li>
			</ul>
		</div>
		<!-- �귣�� ���丮, ���ⱸ��, ��ǰ, ����, �̺�Ʈ ������̼� -->
		<div class="nav2">
			<nav class="navbar navbar-menu navbar-expand-sm">
			
				<ul class="navbar-nav">
					<li class="nav-item">
     				 	<a class="nav-link" href="#"><img src="../img/dailyT-100px.png" alt="logo" style="width: 50px;"></a>
   					</li>
			    	<li class="nav-item2 col-md-4">
			    		<a class="nav-link" href="#">�귣�� ���丮</a>
     				 	<ul class="detail-nav2">
     				 		<li><a class="detail-nav-link" href="#">�귣�� ���丮</a></li>
     				 		<li><a class="detail-nav-link" href="#">���</a></li>  				 		
     				 	</ul>
   					</li>
    				<li class="nav-item3 col-md-4">
      					<a class="nav-link" href="#">���ⱸ��</a>
     				 	<ul class="detail-nav3">
     				 		<li><a class="detail-nav-link" href="#">���� ����</a></li>
     				 		<li><a class="detail-nav-link" href="#">���� ����</a></li>  				 		
     				 	</ul>      					
    				</li>
    				<li class="nav-item4 col-md-4">
      					<a class="nav-link" href="#">��ǰ</a>
     				 	<ul class="detail-nav4">
     				 		<li><a class="detail-nav-link" href="#">ȫ��</a></li>
     				 		<li><a class="detail-nav-link" href="#">����</a></li>
     				 		<li><a class="detail-nav-link" href="#">����</a></li>  				 		
     				 	</ul>      					
    				</li>
    				<li class="nav-item5 col-md-4">
      					<a class="nav-link" href="#">����</a>
     				 	<ul class="detail-nav5">
     				 		<li><a class="detail-nav-link" href="#">��Ÿ����</a></li>
     				 		<li><a class="detail-nav-link" href="#">�ٱ�</a></li>		 		
     				 	</ul>       					
    				</li>
    				<li class="nav-item  col-md-4">
      					<a class="nav-link" href="#">�̺�Ʈ</a>
    				</li>
				</ul>
  
			</nav>
		</div>
	</div>
	
	<div class="container-fluid">
    <div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../img/text-banner-exam1.png" alt="banner1">
    </div>
    <div class="carousel-item">
      <img src="../img/text-banner-exam2.png" alt="banner2">
    </div>
    <div class="carousel-item">
      <img src="../img/text-banner-exam3.png" alt="banner3">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
    </div>
    
    

</body>
</html>