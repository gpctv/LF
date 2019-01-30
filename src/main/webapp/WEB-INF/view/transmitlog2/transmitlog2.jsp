<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head>
<script type="text/javascript" src="resource/js/transmitlog2/transmitlog2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transmitlog2</title>
</head>
<body>
<div class="container-fluid">
<br/>

<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<div class="form-group"><label class="control-label">storerkey:</label><select id="myselect" data-live-search="true" class="selectpicker"></select></div>
<div class="form-group"><div class="col-sm-1"><label class="control-label">key1:</label></div><div class="col-sm-3"><input type="text" class="form-control input-sm" id="key1" style="width:200px"/></div></div>   

</div>
 
<div class="col-sm-3">
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
 <div class="form-group"><button id="query" class="btn btn-primary">查詢</button>
 

</div>
<div class="col-sm-3">
</div>
</div>
</div>
<div class="row">
 
<div class="col-sm-2">

</div>
<div class="col-sm-9">

<table data-toggle="table" id="ediTable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams" data-page-number="1" data-page-size="10"
data-page-list="[10, 25, 50, 100]" data-pagination="true" data-classes="table table-hover">
<thead>
        <tr>
            <th data-field="transmitlogkey" >transmitlogkey</th>
            <th data-field="tablename" >tablename</th>
             <th data-field="key1" >key1</th>
              <th data-field="key2" >key2</th>
               <th data-field="key3" >key3</th>
                <th data-field="transmitflag" data-formatter="dropdown">transmitflag</th>
                 <th data-field="addDate" >AddDate</th>
                  <th data-field="addWho" >AddWho</th>
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