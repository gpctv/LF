/**
 * 
 */

$(document).ready(function () {
	$.ajax({
		 url: CONTEXT_PATH+'/deviceId',
		 type: 'POST',
         dataType: 'json',
         success: function (data) {
        	 $.each(data.deviceId,function(key,value){
        		 $('#myselect').append($('<option></option>').attr('value',value).text(value))
        	 });
        	 
        	 $('#myselect').selectpicker('refresh');
         } 
	
	});
	
 
	$('#myModal').on('hide.bs.modal', function () {
		clearAll();
		$('.registerForm').data('bootstrapValidator').resetForm();
		})
	
//驗證
	$('.registerForm').bootstrapValidator({
		message: 'This value is not valid',
		 
	        fields: {
	        	deviceProfileKey:{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    },
	                    remote:{
	                    	message: '不允許重複',
	                        url:CONTEXT_PATH+ '/isExistDeviceProfileKey2',
	                        type:'POST',
	                        data:  function(validator){
	                        	return{
	                        		deviceProfileKey: validator.getFieldElements('deviceProfilekey').val()
	                        	};
	                        }
	                    }
	        		}
	        	},
	        	deviceID:{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    },
	                    remote:{
	                    	message: '不允許重複',
	                        url:CONTEXT_PATH+ '/isExistDeviceId',
	                        type:'POST',
	                        data:  function(validator){
	                        	return{
	                        		deviceID: validator.getFieldElements('deviceID').val()
	                        	};
	                        }
	                    }
	        		}
	        	},
	        	devicePosition:{
	        		 
	        		validators: {
	        			notEmpty: {
	                        message: '不允許空白'
	                    },
	                    integer: {
	                        
	                        message: '需數字'
	                    },
	                    between: { 
	                        max: 21,
	                        message: '最多只允許21個position'
	                    }
	        		}
	        	},
	        	ipAddress:{
	        		validators: {
	        			ip:{
	        			ipv4:{},
	        	message:'IP 格式不正確'
	        			}
	        		}
	        	},
	        	port:{
	        		validators: {
	        		integer:{
	        			message:'需數字'
	        		},
	        		between:{
	        			min:1,
	        			max:65535,
	        			message:'1~65535'
	        		}
	        		}
	        	}
	        }
		
	});
	
	
	
	$('#query').click(function(){
 
		$('#DeviceTable').bootstrapTable("refresh",{
   		 url:CONTEXT_PATH+'/deviceQuery' 
   		 
   	 });  
	});
	 
	
});

function clearAll(){
	$('#deviceProfileKey').val('');
	$('#ipAddress').val('');
	$('#port').val('');
	$('#deviceID').val('');
	$('#devicePosition').val('');
}

function queryParams(params) { 
    return {
    	
    	storerkey:$('#myselect :selected').val()
    };
}