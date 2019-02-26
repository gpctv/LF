/**
 * 
 */

$(document).ready(function () {
	var p={jobName:'TW-'}
	$.ajax({
		 url: CONTEXT_PATH+'/queryJob',
		 type: 'POST',
        dataType: 'json',
        data:p,
        success: function (data) {
       	 $.each(data.jobList,function(key,value){
       		 $('#myselect').append($('<option></option>').attr('value',value.name).text(value.name))
       	 });
       	 
       	 $('#myselect').selectpicker('refresh');
        } 
	
	});
	
	$('#query').click(function(){
		 if(''!=$('#myselect :selected').val()){
		$('#job').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/queryJobTable' 
   		 
   	 });  
		 }
	}); 
	
	$('#job').on('load-success.bs.table', function (e, arg1) { 
		$('.upbtn').click(function(){
			var update=$(this);
			$.ajax({
				url:CONTEXT_PATH+'/execJob',
				type:'POST',
				dataType:'json',
				data:{jobName: $(this).attr('strage')},
				success:function(data){
					 console.log('test1');
					 
				},
				beforeSend:function(){
					console.log('beforeSend'+':'+update.attr('strage'));
					$('#exeLoading').prop('style','');
					update.prop('disabled','disabled');
				},
				complete:function(){
					console.log('complete');
					$('#exeLoading').prop('style','display: none;');
					update.prop('disabled','');
				}
			});
		});
		
		$('.enableJob').click(function(){
			var enableButton=$(this);
			var isEnable='';
			if('enable'==$(this).text()){
				isEnable='1';
			}else{
				isEnable='0';
			}
			$.ajax({
				url:CONTEXT_PATH+'/turnJob',
				type:'POST',
				dataType:'json',
				data:{jobName: $(this).attr('strage'),isEnable:isEnable},
				success:function(data){
					 console.log('turn finish');
					 console.log('complete'); 
					 $('#job').bootstrapTable("refresh",{
				   		 url:CONTEXT_PATH+'/queryJobTable' 
				   		 
				   	 });  
//						if('enable'==enableButton.text()){
//							enableButton.text('disable')
//						}else{
//							enableButton.text('enable')
//						}
				},
				beforeSend:function(){
					console.log('beforeSend'+':'+enableButton.attr('strage'));
					 
					enableButton.prop('disabled','disabled');
				},
				complete:function(){
					enableButton.prop('disabled','');
				}
			});
		});
		
	});
	 
})

function queryParams(params) { 
    return {
    	
    	jobName:$('#myselect :selected').val()
    };
}

function execButton(value, row, index){
	 
	console.log(row );
  return '<img id="exeLoading" src="resource/image/loading.gif" height="90" width="90" style="display: none;"/>'+ '<button type="button" class="btn btn-primary upbtn" strage="'+row.name+'">Exec Job</button>' ;
	 
}

function enableSet(value,row,index){
	console.log(row );
	return '1'==row.enabled ?'<button type="button"   class="btn btn-primary enableJob" strage="'+row.name+'">disable</button>':'<button type="button"  class="btn btn-primary enableJob" strage="'+row.name+'">enable</button>'
}