/**
 * 
 */



$(document).ready(function(){
	$('#send').click(function(){
		$.ajax({
			type:'POST',
			url:CONTEXT_PATH+'/nineOne2',//'https://api.91mai.com/scm/v1/Utils/GetCurrentTime', 
			dataType:'text',
			success:function(d){
				$('#message').html(d);
			},
			error:function(e){
				$('#message').html(e);
			}
		});
		
	});
});