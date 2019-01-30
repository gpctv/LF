<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/ediTurn/job.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3">

</div>
<div class="col-sm-6">
<select id="myselect" data-live-search="true" class="selectpicker" >
    
</select><br/>
<button id="query" class="btn btn-primary">查詢</button>
</div>
<div class="col-sm-3">

</div>
</div>
<div class="row">
<div class="col-sm-2">

</div>
<div class="col-sm-9">

<table data-toggle="table" id="job" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams"  
   data-classes="table table-hover">
<thead>
        <tr>
            <th data-field="name" >name</th>
            <th data-field="enabled" data-formatter="enableSet">enabled</th>
             <th data-field="description" >description</th>
             <th data-field="exec" data-formatter="execButton">exec</th> 
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