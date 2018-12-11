<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head>
<script type="text/javascript" src="resource/js/device/deviceCart.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Device cart</title>
</head>
<body>
<div class="container-fluid">
<br/>

<div class="row">
<div class="col-sm-3">
<p>FN808車子數</p>
</div>

<div class="col-sm-6">
<select id="myselect" data-live-search="true" class="selectpicker" >
    
</select><br/>
<button id="query">查詢</button> 
</div>
<div class="col-sm-3">
 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">產生車子</button>
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<table data-toggle="table" id="DeviceTable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams">
<thead>
        <tr>
            <th data-field="deviceProfileKey" >DeviceProfileKey</th>
            <th data-field="deviceType">DeviceType</th> 
            <th data-field="deviceId">deviceId</th> 
            <th data-field="devicePosition">devicePosition</th> 
            
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
<form class="registerForm" id="createCart" action="createCart" method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">產生車子</h4>
</div>

<div class="modal-body">
          <p>設定808車子</p> 
          
          <i class="fas fa-dolly fa-3x"></i>
          <div class="form-group">
         <font color="red">*</font>deviceProfileKey:   <input type="text" class="form-control" name="deviceProfileKey" id="deviceProfileKey"/> 
         </div>
        <div class="form-group">
          ipaddress: <input type="text" class="form-control" name="ipAddress" id="ipAddress" /> 
          </div>
          <div class="form-group">
          PortNo:<input type="text" class="form-control" name="port" id="port"/> 
          </div>
           <div class="form-group">
           <font color="red">*</font>DeviceID <input type="text" class="form-control" name="deviceID" id="deviceID"/> 
           </div>
           <div class="form-group"><font color="red">*</font>DevicePosition(需要幾個position) <input type="text" class="form-control" name="devicePosition" id="devicePosition" />
          
           </div>
           
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default">OK</button><button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
</form>
</div>

</div>
 
</div>
</div>
</body>
</html>