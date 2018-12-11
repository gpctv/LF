<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head>
<script type="text/javascript" src="resource/js/translate/bigTrans.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Big5 translate</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-md-3"> </div><div class="col-md-6"><ul class="list-group"> <li class="list-group-item"><label class="control-label">Big5 translate:</label><textarea class="form-control" rows="5" id="comment"></textarea></li></ul></div> <div class="col-md-3">  <button type="button" class="btn btn-primary" id="translate">轉換</button>  <button type="button" class="btn btn-default" id="clear">清除</button></div>

</div>
<div class="row">
<div class="col-md-3"> </div><div class="col-md-6"><ul class="list-group"> <li class="list-group-item"><label class="control-label"  > result: </label><label class="control-label" id="result">  </label> </li></ul></div> <div class="col-md-3"> </div>

</div>
</div>
</body>
</html>