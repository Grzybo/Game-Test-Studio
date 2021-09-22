<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    	<style><%@include file="/WEB-INF/index.css"%></style>
</head>
<body>
	 <h2>Login</h2>
    <div class = "content">
    <s:actionerror />
 
    <s:form action="/login" method="post"> 
        <s:textfield class="text" name="email" key="Email"  />
        <s:password class="text" name="password" key="label.password" size="100%"/>
        <s:submit class= "button"  method="execute" key="label.login" align="center" />
    </s:form>
    Admin: admin@admin.com, admin
    <br>
 	Normal user: donald@disney.com, disney123 
 	 
 	</div>
</body>
</html>