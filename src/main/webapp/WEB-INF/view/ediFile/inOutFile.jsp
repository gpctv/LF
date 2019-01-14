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
<style  >
label {
    	white-space: pre-wrap; 
    }</style>
 <title>InFile Data</title>
</head>
<body> 
 
<div class="row">
 <div class="col-sm-3">

</div>
<div class="col-sm-6">

</div>
<div class="col-sm-3">

</div>

</div>
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-9">
<table class="table">
<tbody>
<tr>
 <td>Storerkey:
<select id="myselect" data-live-search="true" class="selectpicker" > 
</select></td>
 <td>DataStream:
<select id="myselect2" data-live-search="true" class="selectpicker" >
</select>
    </td>
   <td> </td>
</tr>
<td>
status:
<select class="selectpicker" id="status1">
  <option value="0">0</option>
  <option value="5">5</option> 
  <option value="9">9</option> 
</select> 
</td><td><form class="registerForm" id="register" >
<div class="form-group">  <div class="col-sm-5"><label class="control-label">adddate(YYYYMMDD):</label> </div><div class="col-sm-6"><input type="text" name="adddate" class="form-control input-sm" id="adddate" /></div></div>   
</form></td><td> <button id="query" type="button" class="btn btn-primary">查詢</button> <a href="#" data-toggle="collapse" data-target="#demo">進階查詢</a>
 </td></tr>  
 
</tbody>
</table>

</div>
 <div class="col-sm-1">

</div>
</div>
<div class="row">
<div class="col-sm-2">

</div>

<div class="col-sm-9">

 <div id="demo" class="collapse">
<table class="table">
<tbody>
<tr/>
<td> LineText: <input type="text" name="lineText" class="form-control input-sm" id="lineText" /></td>
<td> LineTextUnicode: <input type="text" name="lineTextUnicode" class="form-control input-sm" id="lineTextUnicode" /></td>
<td>   fileName:  <input type="text" name="filename" class="form-control input-sm" id="filename" /> 
 </td>
</tbody>
</table>
</div> 
</div>
 <div class="col-sm-1">

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
               <th data-field="lineText" data-formatter="linetext2">LineText</th>
                <th data-field="errMsg">ErrMsg</th>
                 <th data-field="adddate" >addDate</th> 
                  <th data-field="lineTextUnicode"  data-formatter="linetext1" >lineTextUnicode</th>   
        </tr>
    </thead>
</table>
</div>
<div class="col-sm-1">

</div>
</div>
 
</body>
</html>