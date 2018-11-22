/**
 * 
 */

$(document).ready(function () {
	 var paramater=getParamater('reportName');
	 var paramater2=getParamater('reportName2');
	 var getUrl = window.location.href;
	 var sec=getParamater('sec');;
	 $('#times').text(getDate());
	 if(!paramater||paramater ==='0'){
		 paramater='Double11_2FProductivity';
	 }
	 if(!sec||sec<50){
		 sec=50000;
	 }else{
		 sec=sec*1000;
	 }
	 console.log('get url '+getUrl);
	
	 var pngUrlArray=getImageUrl(getUrlParamater());
	 console.log('paramater code:'+pngUrlArray);
	 setImage(pngUrlArray,sec);
//     var imagUrl='http://wmsdbdm.lfapps.net/ReportServer?%2FTW%20WMS%20Reports%2F'+paramater+'&rs:Command=Render&rs:Format=IMAGE&rc:OutputFormat=PNG';
//	 
//	 if(paramater2){
//		 var imagUrl2='http://wmsdbdm.lfapps.net/ReportServer?%2FTW%20WMS%20Reports%2F'+paramater2+'&rs:Command=Render&rs:Format=IMAGE&rc:OutputFormat=PNG';
//		 setInterval(function(){setImage(imagUrl,imagUrl2)},30000);
//	 }else{
//		 setInterval(function(){rePlay(imagUrl)},60000);
//	 }
	
	  
	//rePlay();
});
 
function setImage(pngUrlArray,sec){
//	if($('#reportImg').attr('src')==p1){
//		$('#reportImg').attr('src',p2+'&test='+random());
//		
//	}else{
//		$('#reportImg').attr('src',p1+'&test='+random());
//	}
	$('#reportImg').attr('src',pngUrlArray[0]);
	    var first=0;
		var i=0;
		setInterval(function(){
			if(pngUrlArray.length>1 && first==0){
				$('#reportImg').attr('src',pngUrlArray[i+1]);
				
			}else{
			$('#reportImg').attr('src',pngUrlArray[i]+'&rs:SessionID='+random());
			}
			i=i+1;
			if(i==(pngUrlArray.length)){
				i=0;
				first=1;
				
			}
		},sec);
	 
	
	
}

function getUrlParamater(){
	 var getUrl = window.location.href;
	  
	 console.log(getUrl);
	 //url = new URL(getUrl);
	 //options= getUrlParameter(getUrl);
	 //options = url.searchParams.getAll("reportName");
	 options=getParamater2('reportName');
	 return options;
}

function getImageUrl(options){
 var arrayUrl=[];

	for(i=0;i<options.length;i++){
		arrayUrl[i]='http://wmsdbdm.lfapps.net/ReportServer?%2FTW%20WMS%20Reports%2F'+options[i]+'&rs:Command=Render&rs:ClearSession=true&rs:Format=IMAGE&rc:OutputFormat=PNG';
        
	}
	return arrayUrl;
}

 
//
//function rePlay(imagUrl){
//	 
//	$.ajax({
//		url:CONTEXT_PATH+'/report2',
//		type:'POST',
//		dataType:'json',
//		contentType: "application/json; charset=utf-8",
//		success:function(s){
//			 
//				$('#reportImg').attr("src",s.url);
//		 
//			
//		}
//		
//	});
//	 
//	 location.reload(true);
//	 $('#reportImg').attr("src",imagUrl+'&test='+random());
//}

function getParamater(sParam){
	 
	    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : sParameterName[1];
	        }
	    }
	 
}


function getParamater2(sParam){
	 
	    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;
	    var paramaters=[];
      for(i=0;i<sURLVariables.length; i++){
    	  if(sParam==sURLVariables[i].split('=')[0]){
    	  paramaters[i]= sURLVariables[i].split('=')[1];
    	  }
      }
//	    for (i = 0; i < sURLVariables.length; i++) {
//	        sParameterName = sURLVariables[i].split('=');
//
//	        if (sParameterName[0] === sParam) {
//	            return sParameterName[1] === undefined ? true : sParameterName[1];
//	        }
//	    }
//	 
	    return paramaters;
}
function getDate(){
	var date=new Date();
	var sDate=date.getHours()+':'+date.getMinutes()+':'+date.getMinutes();
	return sDate;
}

function refResh(){
	location.reload(true);
}

function random(){
	 
	    return + new Date().getTime();
 
}