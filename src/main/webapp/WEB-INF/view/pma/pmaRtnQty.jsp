<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/pma/pmaRtnQty.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>PMA RTN QTY</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3">
<p>PUMA 授權碼預計退回</p><img src="resource/image/logo.jpg" alt="Smiley face" height="25" />
</div>
<div class="col-sm-3 ">
退貨授權碼:<input type="text" class="form-control" id="CarrierRef" />
<button id="query">查詢</button> 
</div>
<div class="col-sm-4 offset-md-2">
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">新增</button>
</div>
</div>
<div class="row">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<table data-classes="table table-hover" data-toggle="table" id="PMATable" data-method="post" data-data-type="json" data-side-pagination="server" 
data-page-number="1" data-page-size="10" data-page-list="[10, 25, 50, 100]" data-pagination="true" data-content-type="application/json" data-query-params="queryParams">
<thead>
        <tr>
            
            <th data-field="carrierReference">授權碼</th>
            <th data-field="qtyExpected">數量</th>  
            <th data-formatter="modify"></th>
            <th data-formatter="delete1"></th>
        </tr>
    </thead>
</table>
</div>

<div class="col-sm-3">
</div>
</div>

</div>
<!-- dialog add -->

<div class="container">
<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<form class="registerForm" id="createFore"  method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">新增預計退回數量</h4>
</div>

<div class="modal-body">
          <p>新增</p> 
          
          <i class="fas fa-street-view"></i>
          <div class="form-group">
         <font color="red">*</font>授權碼:   <input type="text" class="form-control" name="carrierReference" id="carrierReference"/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>預計退回數量: <input type="text" class="form-control" name="qty" id="qty" /> 
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
<!--MODIFY DIALOG-->
<div class="container">
<div class="modal fade" id="myModal2" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<form class="registerForm2" id="modify2"  method="post">
<div class="modal-header">

<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">修正預計退回數量</h4>
</div>

<div class="modal-body">
          <p>修改</p> 
          
          <i class="fas fa-street-view"></i>
          <div class="form-group">
         <font color="red">*</font>授權碼:   <input type="text" disabled class="form-control" name="carrierReference2" id="carrierReference2"/> 
         </div>
        <div class="form-group">
          <font color="red">*</font>預計退回數量: <input type="text" class="form-control" name="qty2" id="qty2" /> 
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