/**
 * 
 */

$(document).ready(function () {
	//facility
	$.ajax({
		 url: CONTEXT_PATH+'/facilityQuery',
		 type: 'POST',
       dataType: 'json',
       success: function (data) {
      	 $.each(data.facilityList,function(key,value){
      		 console.log(key+'--'+value.facility);
      		 $('#facilitySelect').append($('<option></option>').attr('value',value.facility).text(value.facility))
      	 });
      	 
      	 $('#facilitySelect').selectpicker('refresh');
       }
	});
	
	//下拉選單
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
	//INSERT SKU
	$('#btnSKU').click(function(){
		if(checkStorerkey()){
		$.ajax({
			url:CONTEXT_PATH+'/inserSKU',
			type:'POST',
			dataType:'json',
			data:{storerkey:$('#myselect').val()},
			success:function(data){
				$('#skuUpNum').text('insert '+data.skuInsert+'至測試環境');
			},
			beforeSend:function(){
				close();
				$('#skuLoading').prop('style','');
				$('#skuResult').text('處理中...');
			},
			complete:function(){
				open();
				$('#skuLoading').prop('style','display: none;');
				$('#skuResult').text('完成...');
			},
			error:function(){
				$('#skuUpNum').text(' ...');
				$('#skuResult').text('匯入失敗');
			}
		});
		}else{
			$('#skuResult').text('STORERKEY 未選擇...');
		}
	});
	//INSERT PACK
	$('#btnPack').click(function(){
		console.log(checkStorerkey());
		if(checkStorerkey()){
		$.ajax({
			url:CONTEXT_PATH+'/inserPack',
			type:'POST',
			dataType:'json',
			data:{storerkey:$('#myselect').val()},
			success:function(data){
				$('#packUpNum').text('insert '+data.packInsert+'至測試環境');
			},
			beforeSend:function(){
				close();
				$('#packLoading').prop('style','');
				$('#packResult').text('處理中...');
			},
			complete:function(){
				open();
				$('#packLoading').prop('style','display: none;');
				$('#packResult').text('完成...');
			},error:function(){
				$('#packUpNum').text(' ...');
				$('#packResult').text('匯入失敗');
			}
		});
		}else{
			$('#packResult').text('STORERKEY 未選擇...');
		}
	})
	var comMsg='';
	//INSERT TEMPSTOCK
	$('#btnStock').click(function(){
		console.log(checkStorerkey());
		if(checkStorerkey()){
		$.ajax({
			url:CONTEXT_PATH+'/inserTempStock',
			type:'POST',
			dataType:'json',
			data:{storerkey:$('#myselect').val(),sku:$('#sku').val()},
			success:function(data){
				if('success'==data.msg){
				$('#stockUpNum').text('insert '+data.stockInsert+'至測試環境');
				}else{
					$('#stockResult').text(' ...');
					$('#stockUpNum').text('格式錯誤');
				}
			},
			beforeSend:function(){
				close();
				$('#stockLoading').prop('style','');
				$('#stockResult').text('處理中...');
			},
			complete:function(){
				open();
				$('#stockLoading').prop('style','display: none;');
				if('success'==comMsg){
				$('#stockResult').text('完成...');
				}
			},
			error:function(){
				$('#stockResult').text(' ...');
				$('#stockUpNum').text('匯入失敗');
			}
		});
		}else{
			$('#stockResult').text('STORERKEY 未選擇...');
		}
	})
	
	//insert loc
	 
	$('#btnLoc').click(function(){
		console.log(checkStorerkey());
		if(checkFacility()){
		$.ajax({
			url:CONTEXT_PATH+'/insertLOC',
			type:'POST',
			dataType:'json',
			data:{facility:$('#facilitySelect').val()},
			success:function(data){
				if('success'==data.msg){
				$('#locUpNum').text('insert '+data.locInsert+'至測試環境');
				}else{
					$('#locResult').text(' ...');
					$('#locUpNum').text('匯入失敗');
				}
			},
			beforeSend:function(){
				close();
				$('#locLoading').prop('style','');
				$('#locResult').text('處理中...');
			},
			complete:function(){
				open();
				$('#locLoading').prop('style','display: none;');
				if('success'==comMsg){
				$('#locResult').text('完成...');
				}
			},
			error:function(){
				$('#locResult').text(' ...');
				$('#locUpNum').text('匯入失敗');
			}
		});
		}else{
			$('#locResult').text('facility 未選擇...');
		}
	})
	//calculate NSP
	$('#btnCalcuate').click(function(){
		console.log(checkStorerkey());
		if(checkStorerkey()){
		$.ajax({
			url:CONTEXT_PATH+'/calcualteNSP',
			type:'POST',
			dataType:'json',
			data:{storerkey:$('#myselect').val()},
			success:function(data){
				
			},
			beforeSend:function(){
				close();
				$('#calcuLoading').prop('style','');
				$('#calcuResult').text('處理中...');
			},
			complete:function(){
				open();
				$('#calcuLoading').prop('style','display: none;');
				$('#calcuResult').text('完成...');
			},
			error:function(){
				$('#calcuResult').text(' ...');
				$('#calcuResult').text('匯入失敗');
			}
		});
		}else{
			$('#calcuResult').text('STORERKEY 未選擇...');
		}
	})
	
});

function checkStorerkey(){
	var test=$('#myselect').val();
	if(!test){
		console.log('no exist');
		return false;
	}else{
		console.log(test);
		return true;
	}
}
function checkFacility(){
	var test=$('#facilitySelect').val();
	if(!test){
		console.log('no exist');
		return false;
	}else{
		console.log(test);
		return true;
	}
}


function close(){
	$('#myselect').prop('disabled','disabled');
	$('#myselect').selectpicker('refresh');
	$('#btnSKU').prop('disabled','disabled');
	$('#btnPack').prop('disabled','disabled');
	$('#btnLoc').prop('disabled','disabled');
	$('#btnStock').prop('disabled','disabled');
	$('#btnCalcuate').prop('disabled','disabled');
	$('#facilitySelect').prop('disabled','disabled');
	$('#facilitySelect').selectpicker('refresh');
}

function open(){
	$('#myselect').prop('disabled','');
	$('#myselect').selectpicker('refresh');
	$('#facilitySelect').prop('disabled','');
	$('#facilitySelect').selectpicker('refresh');
	$('#btnSKU').prop('disabled','');
	$('#btnPack').prop('disabled',''); 
	$('#btnLoc').prop('disabled','');
	$('#btnStock').prop('disabled','');
	$('#btnCalcuate').prop('disabled','');
}