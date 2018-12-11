/**
 * 
 */

$(document).ready(function () {
	
	$('#translate').click(function(){
		if($('#comment').val()){
		$.ajax({
			 url: CONTEXT_PATH+'/translate',
			 type: 'POST',
	       dataType: 'json',
	       data:{ big5Text:$('#comment').val() },
	       success: function (data) {
	       if('success'==data.resultMsg){
	    	   console.log(data);
		       $('#result').text(data.result);
	       }
	      		 
	      	 
	       }
		});
		}
	});
	$('#clear').click(function(){
		$('#comment').val('');
		 $('#result').text('');
	})
	
	
});