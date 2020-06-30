$(document).ready(function(){  
  		  
		$(".nav-item2").hover(function() { //마우스를 topnav에 오버시
			$(this).parent().find(".detail-nav2").slideDown('normal').show(); 
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".detail-nav2").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		});  
	  
	});

$(document).ready(function(){  
	$(".nav-item3").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav3").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav3").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
});  

$(document).ready(function(){  
	  
	$(".nav-item4").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav4").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav4").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
  
});  

$(document).ready(function(){  
	  
	$(".nav-item5").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav5").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav5").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
  
}); 

$( document ).ready( function() {
    var jbOffset = $( '.nav2' ).offset();
    $( window ).scroll( function() {
      if ( $( document ).scrollTop() > jbOffset.top ) {
        $( '.nav2' ).addClass( 'nav2Fixed' );
      }
      else {
        $( '.nav2' ).removeClass( 'nav2Fixed' );
      }
    });
  } );