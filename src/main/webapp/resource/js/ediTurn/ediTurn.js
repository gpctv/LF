/**
 * 
 */
var array=[];
$(document).ready(function () {
	
	$.ajax({
		 url: CONTEXT_PATH+'/ediStorer',
		 type: 'POST',
         dataType: 'json',
         success: function (data) {
        	 $.each(data.ediStorer,function(key,value){
        		 $('#myselect').append($('<option></option>').attr('value',value).text(value))
        	 });
        	 
        	 $('#myselect').selectpicker('refresh');
         }
	});
	
 	$('#query').click(function(){
//		console.log($('#myselect :selected').val());
//		$.ajax({
//			 url: CONTEXT_PATH+'/ediTable',
//			 type: 'POST',
//			 data:{storerKey:$('#myselect :selected').val()},
//	         dataType: 'json',
//	         success: function (data) {
//	        	 console.log(data);
//	         }
//		});
		$('#ediTable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/ediTable' 
   		 
   	 });  
	});
 	 
 	
 	
 	$('#update').click(function(){
 		var updarray=[];
 		$('.turnSelect') .each(function(e){
 			if($(this).val() !=array[e].activeflag){
 				updarray.push({
 					activeflag :$(this).val(),
 					datastream :array[e].datastream,
 					descr : array[e].datastream,
 					storerkey : array[e].storerkey,
 					type :array[e].type,
 					watcherConfigKey:array[e].watcherConfigKey
 				});
 			}
 		});
 		if(updarray.length != 0){
 			$('#ediTable').bootstrapTable("refresh",{
 		   		 url:CONTEXT_PATH+'/ediTableUpdate' ,
 		   		 query:{table:updarray}
 		   	 });  
 		}
 	});
 	 
	
});

	function queryParams(params) { 
	    return {
	    	
	    	storerKey:$('#myselect :selected').val()
	    };
	}
	
	function dropdown(value, row, index){
		array[index]=row;
		if(value==1){
			return '<select class="turnSelect" name="active" id="active"  >'+
			'<option selected="selected" value="1">'+
			'turn'+
			'</option><option value="0">false</option></select>'
		}else{
			return '<select class="turnSelect" name="active" id="active"  >'+
			'<option  value="1">'+
			'turn'+
			'</option><option value="0" selected="selected">false</option></select>'
		}
	}