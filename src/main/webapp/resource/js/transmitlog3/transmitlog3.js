/**
 * 
 */

var array=[];
$(document).ready(function () {
	$.ajax({
		 url: CONTEXT_PATH+'/storer',
		 type: 'POST',
        dataType: 'json',
        success: function (data) {
       	 $.each(data.storer,function(key,value){
       		 $('#myselect').append($('<option></option>').attr('value',value).text(value))
       	 });
       	 
       	 $('#myselect').selectpicker('refresh');
        }
	});
	
	$('#query').click(function(){
		 
		$('#ediTable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/transmitlog3Table' ,
   		pageNumber:1 //查詢後初始化為第一頁
   		 
   	 });  
	});
	
	$('#ediTable').on('load-success.bs.table', function (e, arg1) { 
		$('.upbtn').click(function(){
			array[$(this).attr('strage')].transmitflag='0'
			 console.log( 'zero:'+array[$(this).attr('strage')]  );
			 
			 $('#ediTable').bootstrapTable("refresh",{
 		   		 url:CONTEXT_PATH+'/transmitlog3Update' ,
 		   		 query:{transmitlog3:array[$(this).attr('strage')]}
 		   	 });  
		});
		$('.upbtn2').click(function(){
			array[$(this).attr('strage')].transmitflag='IGNOR'
			 console.log( 'ignor:'+array[$(this).attr('strage')]  );
			 
			 $('#ediTable').bootstrapTable("refresh",{
 		   		 url:CONTEXT_PATH+'/transmitlog3Update' ,
 		   		 query:{transmitlog3:array[$(this).attr('strage')]}
 		   	 });  
		})
	});
//	$('#ediTable').on('page-change.bs.table', function (e, arg1) {
//		$('#ediTable').bootstrapTable("refresh",{
//	   		 url:CONTEXT_PATH+'/transmitlog3Table' 
//	   		 
//	   	 });   
//	});
	
 
	
});

function queryParams(params) { 
    return {
    	offset:params.offset,
    	limit:params.limit,
    	storerkey:$('#myselect :selected').val(),
    	key1:$('#key1').val()
    };
}


function dropdown(value, row, index){
	array[row.transmitlogkey]=row;
	console.log(row.transmitlogkey);
  return 'now value:'+value+'<button type="button" class="btn btn-primary upbtn" strage="'+row.transmitlogkey+'">update 0</button>'+'<button type="button" class="btn btn-primary upbtn2" strage="'+row.transmitlogkey+'">update ignore</button>';
	 
}




