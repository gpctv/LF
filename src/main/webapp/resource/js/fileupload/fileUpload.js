/**
 * 
 */

$(document).ready(function () {
	$('#uploadBTN').on('click', function(){ 
        var fd = new FormData($("#fileinfo"));
        var file = $('#uploadFile')[0].files[0];
        fd.append('uploadFile', file);
        //fd.append("CustomField", "This is some extra data");
        $.ajax({
            url: CONTEXT_PATH+'/uploadFile',  
            type: 'POST',
            dataType: 'json',
            data: fd,
            contentType: false,
            processData: false,
            success:function(data){
                $('#output').html(data);
            } 
        });
    });
	
});