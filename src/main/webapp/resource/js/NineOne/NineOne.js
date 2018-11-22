/**
 * 
 */



$(document).ready(function(){
	$('#send').click(function(){
		$.ajax({
			type:'POST',
			url:'https://api.91mai.com/scm/v1/Utils/GetCurrentTime', 
			dataType:'text',
			success:function(d){
				$('#message').html(d);
			}
		});
		
	});
});