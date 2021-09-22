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
	<s:form action="/userInfo" method="post">
        <s:label>Change Profile Data:</s:label>
		<s:textfield class="text" name="firstName" key="First Name" 
			placeholder="Leave empty, if not changing" size="100%" />
       	<s:textfield class="text" name="lastName" key="Last Name" 
       		 placeholder="Leave empty, if not changing" size="100%" /> 
        <s:password class="text" name="oldPassword" key="Actual Password" size="100%" />
        <s:password class="text" name="newPassword1" key="New Password" size="100%" />
        <s:password class="text" name="newPassword2" key="New Password"  size="100%"/>
        <s:submit class= "button"  method="execute" key="Update Profile" align="center" />
    </s:form>
	<s:actionerror />
   </div>
</body>
</html>