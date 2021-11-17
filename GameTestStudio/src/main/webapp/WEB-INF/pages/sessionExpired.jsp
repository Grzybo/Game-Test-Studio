<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acces Denied</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
	<body>
    	
    	 <div class="center">
    	 	<div class = "projectContent">
    	 		<h2>Session has expired or You are not logged in.</h2>
    	 		Please log in.
    	 		<br><br>
    	 		<a class="button" href="${pageContext.request.contextPath}/login">Log in</a>
    	 	</div>
    	 </div> 
	</body>
</html>