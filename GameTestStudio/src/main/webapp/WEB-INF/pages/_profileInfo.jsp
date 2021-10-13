<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
<body>
	<div class = "content">
   <h2>Hello, ${loginedUsername}!</h2> 
	<table style="width:100%">
		<s:form action="/userInfo" method="post">
        <s:label>Change Profile Data:</s:label>
		<tr>
			<s:textfield class="text" name="firstName" key="First Name" 
				placeholder="Leave empty, if not changing" size="100%" />
			<s:textfield class="text" name="lastName" key="Last Name" 
       			 placeholder="Leave empty, if not changing" size="100%" /> 						
		</tr>
		<tr>
			<s:password class="text" name="oldPassword" key="Actual Password" size="100%" />
	        <s:password class="text" name="newPassword1" key="New Password" size="100%" />
	        <s:password class="text" name="newPassword2" key="New Password"  size="100%"/>    
		</tr>
		
		<tr>
	        <s:submit class= "button"  method="execute" key="Update Profile" align="center" /> 
		</tr>
		</s:form>
	</table>
	
	
	<s:actionerror />
   </div>
   <br>
   <div class = "content">
   	<s:set var="bP" value="bugPer"/>
	<s:set var="tP" value="testPer"/>
	<s:set var="aP" value="areaPer"/>
	<table style="width:100%">
	<s:label>Permissions:</s:label>
	<tr >
			<td>Bug</td>
			<td>Test</td>
			<td>Area</td>
	</tr>
	<tr>
			<td><a> ${bP}</a></td>
			<td><a> ${tP}</a></td>
			<td><a> ${aP}</a></td>
	</tr>
	</table>
   </div>
</body>
</html>