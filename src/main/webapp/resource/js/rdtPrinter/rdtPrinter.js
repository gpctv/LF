/**
 * 
 */
var result={};

$(document).ready(function () {
	$('.registerForm').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	"printerId":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }  , 
	                    remote:{
	                    	message: '不允許重複',
	                        url:CONTEXT_PATH+ '/isExistPrinterId',
	                        type:'POST',
	                        data:  function(validator){
	                        	 return{ 
	                        		 valid:validator.getFieldElements('printerId').val()
	                        	};
	                        }
	                    }
	                    
	        		}
	        	},
	        	"ipaddress":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }
	        		}
	        	} ,
	        	"printerName":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }  
	        		}
	        	} 
	        }
		
	});
	
	$('.registerForm2').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	
	        	"ipAddress2":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    } 
	        		}
	        	} ,
	        	"winPrinter2":{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    }  
	        		}
	        	} 
	        }
		
	});
	//關閉後重新驗證
	$('#myModal').on('hide.bs.modal', function () {
		clearAll();
		$('.registerForm').data('bootstrapValidator').resetForm();
		});
	
	$('#ok').click(function(){
		console.log($('.registerForm').data('bootstrapValidator').isValid());
		if($('.registerForm').data('bootstrapValidator').isValid()){
			var printer={printerId:$('#add_printerId').val(),description:$('#add_ipaddress').val(),winPrinter:$('#add_printerName').val()
					,printerGroup:$('#add_PrinterGroup').val(),spoolerGroup:$('#add_SpoolerGroup').val()}
			console.log(printer);
			var printer={printer:printer};
			$.ajax({
	    		 url:CONTEXT_PATH+'/insertPrinter',
	    		 contentType: "application/json; charset=utf-8",
	    		 data:  JSON.stringify(printer ),
					type:'POST', 
					 dataType:'json',
					success:function(data){
						$('#table').bootstrapTable("refresh");
						
					 
					},
					complete:function(){
						$('#myModal').modal('toggle');
					}
	    	 });
		}
	})
	
	$('#query').click(function(){
		 
			 queryTable();
		  
		 
	});
	$('#table').on('load-success.bs.table', function (e) {
	     $('.delete1').click(function(e1){
	    	 if (confirm("確定刪除?!")) {
	    	 console.log(result[this.getAttribute('printerId').trim()].printerId);
	    	 var printer={printer:result[this.getAttribute('printerId').trim()]}
	    	 $.ajax({
	    		 url:CONTEXT_PATH+'/deletePrinter',
	    		 contentType: "application/json; charset=utf-8",
					type:'POST',
					dataType:'json',
					data: JSON.stringify(printer),
					success:function(data){
						$('#table').bootstrapTable("refresh");
						 
					}
	    	 });
	    	 }else{
	    		 
	    	 }
	     });
	    
	     $('.modify1').click(function(e2){
	    	 $('#md_printerId').val(this.getAttribute('printerId').trim()); 
	    	 $('#md_ipAddress').val(result[this.getAttribute('printerId').trim()].description);
	    	 $('#md_winPrinter').val(result[this.getAttribute('printerId').trim()].winPrinter);
	    	 $('#md_PrinterGroup').val(result[this.getAttribute('printerId').trim()].printerGroup);
	    	 $('#md_SpoolerGroup').val(result[this.getAttribute('printerId').trim()].spoolerGroup);
	     });
	  
	});
	
	  $('#ok2').click(function(){
		  console.log($('.registerForm2').data('bootstrapValidator').validate());
		  if($('.registerForm2').data('bootstrapValidator').isValid()){
			  var printer={printerId:$('#md_printerId').val(),description:$('#md_ipAddress').val(),winPrinter:$('#md_winPrinter').val()
						,printerGroup:$('#md_PrinterGroup').val(),spoolerGroup:$('#md_SpoolerGroup').val()}
				console.log(printer);
				var printer={printer:printer}; 
			  $.ajax({
		    		 url:CONTEXT_PATH+'/updatePrinter',
		    		 contentType: "application/json; charset=utf-8",
						type:'POST',
						dataType:'json',
						data: JSON.stringify(printer),
						success:function(data){
							$('#table').bootstrapTable("refresh");
							
							//$('#ForeTable').bootstrapTable("refresh");
						},
						complete:function(){
							$('#myModal2').modal('toggle');
						}
		    	 });  
		  }
	  });
});




function queryTable(){
	
	 $('#table').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/queryPrinter'  
   		,pageNumber:1 //查詢後初始化為第一頁
   	 });  
}

function queryParams(params) { 
	
	var printer={printerId:$('#printerID').val(),description:$('#ipAddress').val(),
			winPrinter:$('#printerName').val()
			}
    return {
    	offset:params.offset,
    	limit:params.limit, 
    	printer:printer 
    };
}

function clearAll(){
	$('#add_printerId').val('');
	$('#add_ipaddress').val(''); 
	$('#add_printerName').val(''); 
	$('#add_PrinterGroup').val(''); 
	$('#add_SpoolerGroup').val(''); 
}

function modify(value,row,index){
	result[row.printerId]=row;
	return '<button type="button" dataIndex="'+index+'" class="btn btn-info modify1" data-toggle="modal" data-target="#myModal2" printerId="'+row.printerId+'">修改</button>'
}
function delete1(value,row,index){
	 
	return '<button type="button"   class="btn btn-danger delete1" printerId="'+row.printerId+'">刪除</button>'
}