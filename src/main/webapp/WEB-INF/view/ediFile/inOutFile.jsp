<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/infile/inFile.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>InFile Data</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3  ">

</div>
<div class="col-sm-3  ">
Storerkey:
<select id="myselect" data-live-search="true" class="selectpicker" >
    
</select> <br/>
DataStream:
<select id="myselect2" data-live-search="true" class="selectpicker" >
    
</select> <br/>
</div>
<div class="col-sm-3">

上午/下午:
<select class="selectpicker" id="splitTime">
  <option value="morning">上午</option>
  <option value="noon">下午</option> 
</select><br/>
status:
<select class="selectpicker" id="status1">
  <option value="0">0</option>
  <option value="5">5</option> 
  <option value="9">9</option> 
</select> 
</div>
<div class="col-sm-3">

</div>
</div>
<div class="row">
<div class="col-sm-3  ">

</div>
 
<div class="col-sm-6 ">
<form class="registerForm" id="register" >
<div class="form-group"><div class="col-sm-3"><label class="control-label">adddate(YYYYMMDD):</label></div><div class="col-sm-3"><input type="text" name="adddate" class="form-control input-sm" id="adddate" /></div></div>   
</form>
<button id="query" type="button" class="btn btn-primary">查詢</button> 
</div>
<div class="col-sm-3  ">

</div>
</div>
<div class="row">
<div class="col-sm-2">

</div>
<div class="col-sm-9">

<table data-toggle="table" id="fileTable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams" data-page-number="1" data-page-size="10"
data-page-list="[10, 25, 50, 100]" data-pagination="true" data-classes="table table-hover">
<thead>
        <tr>
            <th data-field="fileKey" >file_key</th>
            <th data-field="datastream" >datastream</th>
             <th data-field="filename" >filename</th>
              <th data-field="status" >status</th>
               <th data-field="lineText" >LineText</th>
                <th data-field="errMsg">ErrMsg</th>
                 <th data-field="adddate" >addDate</th> 
        </tr>
    </thead>
</table>
</div>
<div class="col-sm-1">

</div>
</div>
</div>
</body>
</html>