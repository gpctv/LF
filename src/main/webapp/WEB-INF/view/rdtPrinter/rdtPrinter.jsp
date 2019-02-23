<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/rdtPrinter/rdtPrinter.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>RDTPrinter</title>
</head>
<body>
  
<div class="container-fluid">
<div class="row">
<div class="col-sm-2">
<p>Printer</p>
</div>
<div class="col-sm-7"  style="height:60px;">
<i class="fas fa-print fa-3x"></i>
</div>
<div class="col-sm-3">
</div>
</div>
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-7"> 
<table class="table">
<tbody>
<tr>
<td><label class="control-label">PrinterID:</label><input type="text"  class="form-control input-sm" id="printerID" /><a href="#" data-toggle="collapse" data-target="#demo">進階查詢</a></td><td><div style="width:180px"></div></td>
 
</tbody>
</table>
<div id="demo" class="collapse">
<table class="table">
<tr>
<td><label class="control-label">ip Address:</label><input type="text"  class="form-control input-sm" id="ipAddress" /></td><td><div style="width:180px"></div></td>
<tr>
<td><label class="control-label">printer name:</label><input type="text"  class="form-control input-sm" id="printerName" /></td><td><div style="width:180px"></div></td>
</tr>
</table>
</div>
<button type="button" class="btn btn-primary" id="query">查詢</button>
 
</div>
<div class="col-sm-3">
 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">新增</button>
</div>
</div>
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-7">
<table data-toggle="table" id="table" data-method="post" data-data-type="json" data-side-pagination="server" 
data-content-type="application/json" data-query-params="queryParams" data-page-number="1" data-page-size="10"
data-page-list="[10, 25, 50, 100]" data-pagination="true" data-classes="table table-hover">
<thead>
        <tr>
            <th data-field="printerId" >id</th>
            <th data-field="description">ip</th> 
            <th data-field="winPrinter">name</th> 
            <th data-field="修改" data-formatter="modify"></th>
            <th data-field="刪除" data-formatter="delete1"></th>
        </tr>
    </thead>
</table></div>
<div class="col-sm-3"></div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">

</div>
<div class="col-sm-3">
</div>

</div>
</div>

<div class="container">
<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<form class="registerForm" id="createFore" action="" method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">新增印表機</h4>
</div>

<div class="modal-body">
          <p>新增</p> 
          
          <i class="far fa-file"></i>
          <div class="form-group">
         <font color="red">*</font>printerId:   <input type="text" class="form-control" name="printerId" id="add_printerId"/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>Ip address: <input type="text" class="form-control" name="ipaddress" id="add_ipaddress" /> 
          </div>
          <div class="form-group">
          <font color="red">*</font>印表機名稱:<input type="text" class="form-control" name="printerName" id="add_printerName"/> 
          </div>
            <div class="form-group">
            PrinterGroup:<input type="text" class="form-control" name="PrinterGroup" id="add_PrinterGroup"/> 
          </div>
            <div class="form-group">
           SpoolerGroup:<input type="text" class="form-control" name="SpoolerGroup" id="add_SpoolerGroup"/> 
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
<form class="registerForm2" id="createFore2" action="" method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">修改FORECAST</h4>
</div>

<div class="modal-body">
          <p>修改</p> 
          
          <i class="fas fa-street-view"></i>
          <div class="form-group">
         <font color="red">*</font>PrinterId:   <input type="text"   class="form-control" name="printerId2" id="md_printerId" disabled/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>ip address: <input type="text" class="form-control" name="ipAddress2" id="md_ipAddress" /> 
          </div>
          <div class="form-group">
          <font color="red">*</font>印表機名稱:<input type="text" class="form-control" name="winPrinter2" id="md_winPrinter"  /> 
          </div>
             <div class="form-group">
            PrinterGroup:<input type="text" class="form-control" name="PrinterGroup2" id="md_PrinterGroup"/> 
          </div>
            <div class="form-group">
           SpoolerGroup:<input type="text" class="form-control" name="SpoolerGroup2" id="md_SpoolerGroup"/> 
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