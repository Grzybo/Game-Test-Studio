<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio - Set Password</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
	<body>
	    <h2>Game Test Studio - Set Password </h2>
	     <div class = "content">
		    <s:actionerror />
		    <s:form action="/changePassword" method="post"> 
		        <s:password class="text" name="password" key="New Password" size="100%"/>
		        <s:password class="text" name="passwordRepeat" key="Repeat Password" size="100%"/>
		        <s:submit class= "button"  method="execute" key="Sumbit" align="center" />
		    </s:form> 
 		</div>
	</body> 
</html>