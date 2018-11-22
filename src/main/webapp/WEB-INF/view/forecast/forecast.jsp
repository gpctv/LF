<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/forecast/forecast.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>Forecast</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3">
<p>Forecast</p>
</div>
<div class="col-sm-6">
<select id="myselect" data-live-search="true" class="selectpicker" >
    
</select><br/>
<button id="query">查詢</button> 
</div>
<div class="col-sm-3">
 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">新增</button>
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<table data-toggle="table" id="ForeTable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams">
<thead>
        <tr>
            <th data-field="f_date" data-formatter="formatterDate">日期</th>
            <th data-field="qty">數量</th> 
            <th data-field="storerkey">Storerkey</th> 
            <th data-formatter="modify"></th>
            <th data-formatter="delete1"></th>
        </tr>
    </thead>
</table></div>
<div class="col-sm-3"></div>
</div>
</div>

<div class="container">
<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<form class="registerForm" id="createFore" action="insertForecast" method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">新增FORECAST</h4>
</div>

<div class="modal-body">
          <p>新增</p> 
          
          <i class="fas fa-street-view"></i>
          <div class="form-group">
         <font color="red">*</font>forecast date(YYYY-MM-DD):   <input type="text" class="form-control" name="ForecastId.fDate" id="fDate"/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>qty: <input type="text" class="form-control" name="ForecastId.qty" id="qty" /> 
          </div>
          <div class="form-group">
          <font color="red">*</font>storerkey:<input type="text" class="form-control" name="ForecastId.storerkey" id="storerkey"/> 
          </div>
            
           
        </div>
        <div class="modal-footer">
          <button  id="ok" class="btn btn-default">OK</button><button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
</form>
</div>

</div>
 
</div>
</div>
<div class="container">
<div class="modal fade" id="myModal2" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<form class="registerForm2" id="createFore" action="insertForecast" method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">修改FORECAST</h4>
</div>

<div class="modal-body">
          <p>修改</p> 
          
          <i class="fas fa-street-view"></i>
          <div class="form-group">
         <font color="red">*</font>forecast date(YYYY-MM-DD):   <input type="text" disabled class="form-control" name="ForecastId2.fDate" id="fDate2"/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>qty: <input type="text" class="form-control" name="ForecastId2.qty" id="qty2" /> 
          </div>
          <div class="form-group">
          <font color="red">*</font>storerkey:<input type="text" class="form-control" name="ForecastId2.storerkey" id="storerkey2" disabled/> 
          </div>
            
           
        </div>
        <div class="modal-footer">
          <button  id="ok2" class="btn btn-default">OK</button><button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
</form>
</div>

</div>
 
</div>
</div>
</body>
</html>