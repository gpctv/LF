/**
 * 
 */

$(document).ready(function(){
	$('#send').click(function(){
		$.ajax({
			url:'https://emap.presco.com.tw/emapb5.ashx',
			type:'POST',
			dataType: 'jsonp',
			data:{eshopid:$('#eshopid').val(),
				servicetype:$('#servicetype').val(),
				storeid:$('#storeid').val(),
				tempvar:$('#tempvar').val(),
				url:$('#url').val()
				},
			success:function(msg){
				$('#message').html(msg);
			},
			error:function(object){
				console.log(object);
				var text=object.statusText;
				$('#message').html("<font color='red'>"+text+"</font>");
			},
			beforeSend:function(){
				$('#loading').show();
				$('#message').html('');
			},
			complete:function(){
				$('#loading').hide();
			}
			
		});
	});
	
	$('#send2').click(function(){
		$.ajax({
			url:'https://emap.presco.com.tw/emapb5.ashx',
			type:'POST',
			dataType: 'jsonp',
			crossOrigin: true,
			data:{address:$('#address').val(),
				servicetype:$('#servicetype').val(),
				storeid:$('#storeid').val(),
				storename:$('#storename').val(),
				tempvar:$('#tempvar').val(), 
				outside:$('#outside').val(), 
				ship:$('#ship').val(),
				},
			success:function(msg){
				$('#message2').html(msg);
			},
			error:function(object){
				console.log(object);
				var text=object.statusText;
				var text2= $(object).find('input[name="eshopid"]').val();
				$('#message2').html("<font color='red'>"+text+"</font>");
			},
			beforeSend:function(){
				$('#loading2').show();
				$('#message2').html('');
			},
			complete:function(){
				$('#loading2').hide();
			}
			
		});
	});
});