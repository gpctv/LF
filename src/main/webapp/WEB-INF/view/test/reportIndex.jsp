<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/public.jsp"></s:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Double11 DashBoard</title>
</head>
<body>
	<table align="center">
		<tr>
			<td></td>
			<td><h2>Double11 DashBoard</h2>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><b>LVS</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><a  
				href="<%=request.getContextPath()%>/report?reportName=Double11_LVS_Real-TimeStatus">Double11_LVS_Real-TimeStatus</a></td>
			<td></td>
		<tr>
			<td></td>
			 <td></td>
		<tr>
			<td></td>
			<td><b>POI</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><a  
				href="<%=request.getContextPath()%>/report?reportName=Double11_POI_Real-TimeStatus">Double11_POI_Real-TimeStatus</a></td>
			<td></td>
		<tr>
			<td></td>
			 <td></td>
		<tr>
			<td></td>
			<td><b>VFDC</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><a 
				href="<%=request.getContextPath()%>/report?reportName=Double11_VFDC_PRODUCTIVITY2">Double11_VFDC_PRODUCTIVITY2</a></td>
			<td></td>
		<tr>
			<td></td>
			 <td></td>
		<tr>
			<td></td>
			<td><b>2F3F</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><b>2F</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><a  
				href="<%=request.getContextPath()%>/report?reportName=Double11_2F_PRODUCTIVITY2">Double11_2F_PRODUCTIVITY2</a></td>
			<td></td>
		<tr>
			<td></td>
			
			<td></td>
		<tr>
			<td></td>
			<td><b>3F</b>
			<td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><a  
				href="<%=request.getContextPath()%>/report?reportName=Double11_3F_PRODUCTIVITY2">Double11_3F_PRODUCTIVITY2</a></td>
			<td></td>
		<tr>
			<td></td>
			 <td></td>
	</table>

</body>
</html>