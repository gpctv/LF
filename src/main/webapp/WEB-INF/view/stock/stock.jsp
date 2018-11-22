<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head> 
<script type="text/javascript" src="resource/js/stock/stock.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>Stock Calculation</title>
</head>
<body>

<div class="container">
<div class="row"> 
<div class="col-md-3">....</div><div class="col-md-6" ><h2>倒庫存</h2></div> <div class="col-md-3">....</div>
</div>
<div class="row"> 
<div class="col-md-3">....</div><div class="col-md-6"><ul class="list-group"> <li class="list-group-item"><label class="control-label">storerkey:</label><select id="myselect" data-live-search="true" class="selectpicker" ></select> </li></ul></div> <div class="col-md-3">....</div>
</div>

<div class="row  align-items-center"> 
<div class="col-md-3 text-right "  style="background-color:lavender;">1.塞SKU:<button type="button" class="btn btn-primary" id="btnSKU">InsertSKU</button></div><div class="col-md-6 text-left"  ><span id="skuResult"></span><span id="skuUpNum"></span><img id="skuLoading" src="resource/image/loading.gif" height="90" width="90" style="display: none;"/></div><div class="col-md-3">....</div>
</div>
<div class="row  align-items-center"> 
<div class="col-md-3 text-right"  style="background-color:lavender;"><h2></h2>2.塞PACK:<button type="button" class="btn btn-primary" id="btnPack">InsertPACK</button></div><div class="col-md-6 text-left" ><span id="packResult"></span><span id="packUpNum"></span><img id="packLoading"  src="resource/image/loading.gif" height="90" width="90" style="display: none;"/></div><div class="col-md-3">....</div>
</div>
 <div class="row  align-items-center"> 
<div class="col-md-3 text-right" style="background-color:lavender;" ><h2></h2>3.塞LOC:<button type="button" class="btn btn-primary" id="btnLoc">InsertLoc</button></div> <div class="col-md-6 text-left">facility:<select id="facilitySelect" data-live-search="true" class="selectpicker" ></select> <span id="locResult"></span><span id="locUpNum"></span><img id="locLoading"  src="resource/image/loading.gif" height="90" width="90" style="display: none;"/></div><div class="col-md-3">....</div>
</div> 
<div class="row  align-items-center"> 
<div class="col-md-3 text-right"  style="background-color:lavender;"><h2></h2><small>4.STOCK 至TEMPSTOCK:</small><button type="button" class="btn btn-primary" id="btnStock">InsertStock</button></div> <div class="col-md-2 text-left"><small>SKU:</small><input type="text" class="form-control" id="sku" />  </div><div class="col-md-4 text-left"><span id="stockResult"></span><span id="stockUpNum"></span><img id="stockLoading" src="resource/image/loading.gif" height="90" width="90" style="display: none;"/></div><div class="col-md-3">....</div>
</div>
<div class="row  align-items-center"> 
<div class="col-md-3 text-right"  style="background-color:lavender;"><h2></h2><small>5.執行NSP_INSERTSTOCK:</small><button type="button" class="btn btn-primary" id="btnCalcuate">calculate</button></div><div class="col-md-6 text-left"><span id="calcuResult"></span><img id="calcuLoading" src="resource/image/loading.gif" height="90" width="90" style="display: none;"/></div><div class="col-md-3">....</div>
</div>
</div>

</body>
</html>