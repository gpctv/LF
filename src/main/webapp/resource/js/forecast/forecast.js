/**
 * 
 */

$(document).ready(function () {
	$.ajax({
		 url: CONTEXT_PATH+'/ForecastStorer',
		 type: 'POST',
         dataType: 'json',
         success: function (data) {
        	 $.each(data.storerkeyList,function(key,value){
        		 $('#myselect').append($('<option></option>').attr('value',value).text(value))
        	 });
        	 
        	 $('#myselect').selectpicker('refresh');
         } 
		
	});
	$('#myModal').on('hide.bs.modal', function () {
		clearAll();
		$('.registerForm').data('bootstrapValidator').resetForm();
		});
	$('#ForeTable').on('load-success.bs.table', function (e ) {
	     $('.delete1').click(function(e1){
	    	 console.log(this.getAttribute('f_date'));
	    	 $.ajax({
	    		 url:CONTEXT_PATH+'/deleteForecast',
				 
					type:'POST',
					dataType:'json',
					data: {date1:this.getAttribute('f_date'),qty:this.getAttribute('qty'),storerkey:this.getAttribute('storerkey')},
					success:function(data){
						$('#ForeTable').bootstrapTable("refresh");
						 
					}
	    	 });
	     });
	     $('.modify1').click(function(e2){
	    	 $('#fDate2').val(this.getAttribute('f_date'));
	    	 $('#storerkey2').val(this.getAttribute('storerkey'));
	    	 $('#qty2').val(this.getAttribute('qty'));
	    	 
	    	
	     });
	     
	  
	});
	   $('#ok2').click(function(){
	    	 console.log( $('#qty2').val());
	    	 if($('.registerForm2').data('bootstrapValidator').isValid()){
	    	 $.ajax({
	    		 url:CONTEXT_PATH+'/modifyForecast',
				 
					type:'POST',
					dataType:'json',
					data: {date1:$('#fDate2').val(),qty: $('#qty2').val(),storerkey:$('#storerkey2').val()},
					success:function(data){
						$('#ForeTable').bootstrapTable("refresh");
						
						//$('#ForeTable').bootstrapTable("refresh");
					},
					complete:function(){
						$('#myModal2').modal('toggle');
					}
	    	 });
	    	 }
	     })
	
	$('#query').click(function(){
		 
		$('#ForeTable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/ForecastQuery' 
   		 
   	 });  
	});
	
	//驗證
	$('.registerForm').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	"ForecastId.fDate":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    date:{format: 'YYYY-MM-DD',
	                    	message:'格式不正確'}
	                    
	        		}
	        	},
	        	"ForecastId.qty":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    integer: {
	                        message: '只允許數字'
	                    }
	        		}
	        	},
	        	"ForecastId.storerkey":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }
	        	
	                    
	        		}
	        	} 
	        }
		
	});
	
	//驗證2
	$('.registerForm2').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	"ForecastId2.fDate":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    date:{format: 'YYYY-MM-DD',
	                    	message:'格式不正確'}
	                    
	        		}
	        	},
	        	"ForecastId2.qty":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    integer: {
	                        message: '只允許數字'
	                    }
	        		}
	        	},
	        	"ForecastId2.storerkey":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }
	        	
	                    
	        		}
	        	} 
	        }
		
	});
	
	$('#ok').click(function(){
		console.log($('.registerForm').data('bootstrapValidator').isValid());
		 if($('.registerForm').data('bootstrapValidator').isValid()){
			  
			 
			 $.ajax({
				 url:CONTEXT_PATH+'/insertForecast',
				 
					type:'POST',
					dataType:'json',
					data: {date1:$('#fDate').val(),qty:$('#qty').val(),storerkey:$('#storerkey').val()},
					success:function(data){
						console.log(data.msg);
						if('error'==data.msg){
							alert('重複');
						}else{
							$('#myModal').modal('toggle');
							$('#ForeTable').bootstrapTable("refresh");
							
						}
					},
					complete:function(){
					 
						 refreshSelect();
					}
				 
			 });
		 } 
	});
	
});

function queryParams(params) { 
    return {
    	
    	storerkey:$('#myselect :selected').val()
    };
}

function clearAll(){
	$('#fDate').val('');
	$('#qty').val('');
	$('#storerkey').val(''); 
}

function formatterDate(value, row, index){
	
	console.log(value);
	var date2=value.split('T')[0];
	return date2;
	
}

function modify(value,row,index){
	var f_date=row.f_date.split('T')[0];
	return '<button type="button" class="btn btn-info modify1" data-toggle="modal" data-target="#myModal2" f_date="'+f_date+'" qty="'+row.qty+'" storerkey="'+row.storerkey+'">修改</button>'
}
function delete1(value,row,index){
	var f_date=row.f_date.split('T')[0];
	return '<button type="button"   class="btn btn-danger delete1" f_date="'+f_date+'" qty="'+row.qty+'" storerkey="'+row.storerkey+'">刪除</button>'
}

function refreshSelect(){
	$.ajax({
		 url: CONTEXT_PATH+'/ForecastStorer',
		 type: 'POST',
        dataType: 'json',
        success: function (data) {
        	
        	 $('#myselect').find('option').remove();
       	 $.each(data.storerkeyList,function(key,value){
       		 $('#myselect').append($('<option></option>').attr('value',value).text(value))
       	 });
       	 
       	 $('#myselect').selectpicker('refresh');
        }  
		
	});
}