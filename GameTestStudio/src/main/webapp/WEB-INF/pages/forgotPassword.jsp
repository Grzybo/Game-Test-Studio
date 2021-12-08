<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
	<body>
	    <h2>Reset Password</h2>
	     <div class = "content">
		    <s:actionerror />
		    <s:form action="/forgotPassword" method="post"> 
		        <s:textfield class="text" name="email" key="Email"  size="100%"/>
		        <s:submit class= "button"  method="execute" key="Send verification email" align="center" />
		    </s:form> 
		    
 		</div>
	</body> 
</html>