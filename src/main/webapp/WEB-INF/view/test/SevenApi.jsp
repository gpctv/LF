<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script type="text/javascript" src="resource/js/SevenEleven/sevenEleven.js"></script>
<title>SevenAPI</title>
</head> 
<body>
<div>
<h3>eShop --> eService</h3>

eshopid:<input type="text" id="eshopid"/>(eShop 廠商編號（子廠商代號）)<br>
servicetype:<input type="text" id="servicetype"/>(eShop 與 7-11 店配合作模式，付款取貨1,取貨不付款3 )<br>
storeid:<input type="text" id="storeid"/>(消費者過去取貨店號記錄 可不傳)<br>
tempvar:<input type="text" id="tempvar"/>(eShop 自行運用，identify 資料用 )<br>
url:<input type="text" id="url"/>(根據此 URL 回傳 eShop，以 http:// 開頭 )<br>
<div id='message'></div>
<div id="loading" style="display:none">載入中...</div>
<button id="send">send</button>
</div>
<div>
<h3>eSERVICE --> eShop</h3>
address:<input type="text" id="address"/>顧客選定之門市地址 <br>
servicetype:<input type="text" id="servicetype"/>eShop 與 7-11 合作模式 <br>
storeid:<input type="text" id="storeid"/>顧客選定之門市店號 <br>
storename:<input type="text" id="storename"/>顧客選定之門市名稱 <br>
tempvar:<input type="text" id="tempvar"/>原值回傳 <br>
outside:<input type="text" id="outside"/>0 為本島，1 為外島 <br>
ship:<input type="text" id="ship"/>週配週期，0：不配送； 1：配送 <br>
<div id='message2'></div>
<div id="loading2" style="display:none">載入中...</div>
<button id="send2">send</button>
</div>
</body>
</html>