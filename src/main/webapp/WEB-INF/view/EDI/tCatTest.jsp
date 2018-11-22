<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head>  
<script type="text/javascript" src="resource/js/tCatTest/tCatTest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TCAT GET WS</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-4">
<strong>TCAT EDI TEST</strong>
</div>
<div class="col-sm-3">
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-4">
<p>GET ZIP Code and Station:</p>
<p><input class="form-control input-sm" type="text" name="address" id="address" width="900"/>(放住址)</p>
<button id="query" class="btn btn-primary">查詢</button>

<p id="result1"></p>
sql update Order:<p id="sqlResult"></p>
sql update receipt:<p id="sqlResult2"></p>
</div>
<div class="col-sm-3">
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-4">
<p>GET AreaCode Code and Station:</p>
 <p>facility ZIP:<select id="facilitySelect" data-live-search="true" class="selectpicker" ></select></p>
 <p>order or receipt Zip:<input class="form-control input-sm" type="text" name="zip" id="zip" width="30"/>(放order or receipt c_zip or carrierzip)</p>  
<button id="query2" class="btn btn-primary">查詢</button>
<p id="result2"></p>

sql update Order:<p id="sqlResult3"></p>
sql update receipt:<p id="sqlResult4"></p>
</div>
<div class="col-sm-3">
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-4">
URL to String:<input class="form-control input-sm" type="text" name="URI" id="uri" width="30"/><button id="query3" class="btn btn-primary">查詢</button>
result:<p id="sqlResult5"></p>
</div>
<div class="row">
<div class="col-sm-3">
</div>
</div>
</body>
</html>