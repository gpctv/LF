/**
 * 
 */

$(document).ready(function () {
	conditionSelect();
	
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
	
	$('#myselect').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
		$.ajax({
			 url: CONTEXT_PATH+'/dataStreamQuery',
			 type: 'POST',
	        dataType: 'json',
	        data:{storerkey:$('#myselect').val()},
	        success: function (data) {
	       	 $.each(data.itfConfigList,function(key,value){
	       		  
	       		 
	       		 $('#myselect2').append($('<option></option>').attr('value',value.id.dataStream).attr('value2',value.id.type).text(value.id.dataStream+','+value.descr))
	       	 });
	       	 
	       	 $('#myselect2').selectpicker('refresh');
	        },
	        beforeSend:function(){
	        	$('#myselect2').find('option').remove();
	        }
		});
	});
	
	$('#query').click(function(){
		console.log($('.registerForm').data('bootstrapValidator').validate());//做驗證
		 if($('.registerForm').data('bootstrapValidator').isValid()){
			 console.log('test')
			queryTable();
		 }
		 
	});
	
	
	
	$('.registerForm').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	"adddate":{
	        		 
	        		validators: {
	        			 
	        			stringLength: {
	                        max: 8,
	                        min:8,
	                        message: '格式不正確'
	                    }
	                    
	        		} 
	        	} 
	        }
		
	});
	
	
	
});

function conditionSelect(){
	 var d = new Date();
	   d.getHours
	   if(d.getHours()>12){
	    $('#splitTime').val('noon');
	    }else{
	    	 $('#splitTime').val('morning');
	    }
}

function queryTable(){
	
	 $('#fileTable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/queryFileTable' ,
   		pageNumber:1 //查詢後初始化為第一頁
   	 });  
}

function queryParams(params) { 
    return {
    	offset:params.offset,
    	limit:params.limit,
    	datastream:$('#myselect2').val(),
    	adddate:$('#adddate').val(),
    	type:$('#myselect2 option:selected').attr('value2'),
    	times:$('#splitTime option:selected').attr('value'),
    	status:$('#status1 option:selected').attr('value')
    };
}