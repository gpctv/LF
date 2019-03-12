<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/fileupload/fileUpload.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>fileUpload</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
FileUpload
</div>
<div class="col-sm-3">
</div>

</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<form id="fileinfo" enctype="multipart/form-data" method="post" name="fileUpload">
    <label>file upload:</label>
    <input type="file" name="uploadFile" required  id="uploadFile"/>
</form>
<input type="button" value="fileupload" class="btn btn-primary" id="uploadBTN"/>
</div>
<div class="col-sm-3">

</div>

</div>
</div>
</body>
</html>