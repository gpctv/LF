<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/ediTurn/ediTurn.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDI Turn</title>
</head>
<body>
<div class="container-fluid">
<br/>

<div class="row">
<div class="col-sm-3">

</div>

<div class="col-sm-6">
<select id="myselect" data-live-search="true" class="selectpicker" >
    
</select><br/>
<button id="query">查詢</button>
<button id="update">UPDATE</button>
</div>
<div class="col-sm-3">

</div>
</div>
</div>
<div class="row">
<div class="col-sm-1">

</div>
<div class="col-sm-10">
<table data-toggle="table" id="ediTable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams">
<thead>
        <tr>
            <th data-field="datastream" >DataStream</th>
            <th data-field="storerkey">storerkey</th> 
            <th data-field="activeflag" data-formatter="dropdown">ActiveFlag</th>
           <th data-field="type">type</th>
           <th data-field="descr">descr</th>
           <th data-field="postingSP">postingSP</th> 
           <th data-field="watcherConfigKey">watcherkey</th>
        </tr>
    </thead>
</table>
</div>
<div class="col-sm-1">

</div>
</div>

</body>
</html>