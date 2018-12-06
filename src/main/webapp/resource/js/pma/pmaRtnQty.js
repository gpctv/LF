/**
 * 
 */

$(document).ready(function () {
	$('.registerForm').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	"carrierReference":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }  , 
	                    remote:{
	                    	message: '不允許重複',
	                        url:CONTEXT_PATH+ '/carrierIsExist',
	                        type:'POST',
	                        data:  function(validator){
	                        	 return{
	                        		
	                        		carrierReference:validator.getFieldElements('carrierReference').val()
	                        	};
	                        }
	                    }
	                    
	        		}
	        	},
	        	"qty":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    integer: {
	                        message: '只允許數字'
	                    }
	        		}
	        	} 
	        }
		
	});
	
	$('.registerForm2').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	 
	        	"qty2":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } ,
	                    integer: {
	                        message: '只允許數字'
	                    }
	        		}
	        	} 
	        }
		
	});
	
	$('#query').click(function(){
		 
		$('#PMATable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/queryPmaTable' 
   		 ,pageNumber:1 //查詢後初始化為第一頁
   	 });  
	});
	
	$('#ok').click(function(){
		console.log($('.registerForm').data('bootstrapValidator').isValid());
		if($('.registerForm').data('bootstrapValidator').isValid()){
			 var p={carrierReference:$('#carrierReference').val(),qtyExpected:$('#qty').val(),createDateTime:new Date(),ipAddress:''};
			var pmaRtnQty={pmaRtnQty:p};
			 $.ajax({
	    		 url:CONTEXT_PATH+'/insertPmaTable',
	    		 contentType: "application/json; charset=utf-8",
	    		 data:  JSON.stringify(pmaRtnQty ),
					type:'POST', 
					 dataType:'json',
					success:function(data){
						$('#PMATable').bootstrapTable("refresh");
						
					 
					},
					complete:function(){
						$('#myModal').modal('toggle');
					}
	    	 });
		}
	});
	
	$('#myModal').on('hide.bs.modal', function () {
		clearAll();
		$('.registerForm').data('bootstrapValidator').resetForm();
		});
	
	
	$('#PMATable').on('load-success.bs.table', function (e ) {
	     $('.delete1').click(function(e1){
	    	 console.log(this.getAttribute('f_date'));
	    	 $.ajax({
	    		 url:CONTEXT_PATH+'/deletePmaTable',
				 
					type:'POST',
					dataType:'json',
					data: {carrierReference:this.getAttribute('carrierreference'),qty:this.getAttribute('qty') },
					success:function(data){
						$('#PMATable').bootstrapTable("refresh");
						 
					}
	    	 });
	     });
	     $('.modify1').click(function(e2){
	    	 $('#carrierReference2').val(this.getAttribute('carrierreference')); 
	    	 $('#qty2').val(this.getAttribute('qty'));
	    	 
	    	
	     });
	     
	  
	});
	
	  $('#ok2').click(function(){
	    	  
	    	 if($('.registerForm2').data('bootstrapValidator').isValid()){
	    	 $.ajax({
	    		 url:CONTEXT_PATH+'/modifyPmaTable',
				 
					type:'POST',
					dataType:'json',
					data: {carrierReference:$('#carrierReference2').val(),qty:$('#qty2').val()},
					success:function(data){
						$('#PMATable').bootstrapTable("refresh");
						
						//$('#ForeTable').bootstrapTable("refresh");
					},
					complete:function(){
						$('#myModal2').modal('toggle');
					}
	    	 });
	    	 }
	     })
});


function clearAll(){
	$('#carrierReference').val('');
	$('#qty').val(''); 
}

function queryParams(params) { 
	 var pmaRtnQty={carrierReference:$('#CarrierRef').val(),qtyExpected:0,createDateTime:new Date(),ipAddress:''};
    return {
    	offset:params.offset,
    	limit:params.limit,
    	 
    	pmaRtnQty:pmaRtnQty
    };
}


function modify(value,row,index){
	 
	return '<button type="button" class="btn btn-info modify1" data-toggle="modal" data-target="#myModal2" carrierReference="'+row.carrierReference+'" qty="'+row.qtyExpected+'" ">修改</button>'
}
function delete1(value,row,index){
	 
	return '<button type="button"   class="btn btn-danger delete1" carrierReference="'+row.carrierReference+'" qty="'+row.qtyExpected+'" ">刪除</button>'
}