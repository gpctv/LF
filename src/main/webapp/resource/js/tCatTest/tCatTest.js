/**
 * 
 */

$(document).ready(function () {
	$('#query').click(function(){
		if(''!=$('#address').val().trim()){
		 
		
	 $.ajax({
		 url: CONTEXT_PATH+'/tcatEdiQuery',
		 type: 'POST',
        dataType: 'json',
        data:{address:$('#address').val()},
        success: function (data) {
       	 $('#result1').html(data.result);
       	 
       	 var suda=data.result.toString().split("&");
       	 var routAndZip=suda[1].toString().split("=");
       	 if(''!=routAndZip[1].toString()){
       	 var routAndZip2=routAndZip[1].toString().split("-");
       	 var rout=routAndZip2[0].toString();
       	 var zip=routAndZip2[1].toString()+routAndZip2[2].toString();
       	 
       	$('#sqlResult').html("<font color='red'>update orders </br>"+
       			"set route="+rout+", c_zip="+zip+"</br>"+
       			"where orderkey='' </font>");
        
        
        $('#sqlResult2').html("<font color='red'>update receipt </br>"+
       			"set routingtool="+rout+", carrierzip="+zip+"</br>"+
       			"where receiptkey='' </font>");
       	 }else{
       		$('#sqlResult').html("<font color='red'></br>"+
           			" </font>");
            
            
            $('#sqlResult2').html("<font color='red'></br>"+
           			" </font>");
       	 }
        }
	}); 
		}
	});
	
	$('#query2').click(function(){
		 $.ajax({
			 url: CONTEXT_PATH+'/tcatEdiQuery2',
			 type: 'POST',
	        dataType: 'json',
	        data:{facilityZip:$('#facilitySelect :selected').val(),
	        	areaZip:$('#zip').val()},
	        success: function (data) {
	       	 $('#result2').html(data.result2);

	       	 var suda=data.result2.toString().split("&");
	       	 var routAndZip=suda[1].toString().split("=");
	       	 if(''!=routAndZip[1].toString()){
	       	 
	       	 
	       	$('#sqlResult3').html("<font color='red'>update orders </br>"+
	       			"set sostatus="+"'0'"+", stop='"+routAndZip[1]+"'</br>"+
	       			"where orderkey='' </font>");
	        
	        
	        $('#sqlResult4').html("<font color='red'>update receipt </br>"+
	       			"set ASNREASON="+"'0'"+", sellerstate='"+routAndZip[1]+"'</br>"+
	       			"where receiptkey='' </font>");
	       	}else{
	       		$('#sqlResult3').html("<font color='red'> </br>"+
	           			" </font>");
	            
	            
	            $('#sqlResult4').html("<font color='red'></br>"+
	           			" </font>");
	       	 }
	         
	       	 }
	       
		}); 
	});
	
	$('#query3').click(function(){
		var uri =$('#uri').val();
		var str=decodeURI(uri);
		$('#sqlResult5').html(str);
	});
	
	$.ajax({
		 url: CONTEXT_PATH+'/facilityQuery',
		 type: 'POST',
        dataType: 'json',
        success: function (data) {
       	 $.each(data.facilityList,function(key,value){
       		 console.log(key+'--'+value.facility);
       		 $('#facilitySelect').append($('<option></option>').attr('value',value.zip).text(value.facility))
       	 });
       	 
       	 $('#facilitySelect').selectpicker('refresh');
        }
	});
	
});