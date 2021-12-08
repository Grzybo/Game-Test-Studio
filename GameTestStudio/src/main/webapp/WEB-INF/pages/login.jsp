<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio - Login</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
	<body>
	    <h2>Log into Game Test Studio </h2>
	     <div class = "content">
		    <s:actionerror />
		    <s:form action="/login" method="post"> 
		        <s:textfield class="text" name="email" key="Email"  />
		        <s:password class="text" name="password" key="label.password" size="100%"/>
		        <s:submit class= "button"  method="execute" key="label.login" align="center" />
		    </s:form> 
		    <div class="center">
		    	<a class="button" href="${pageContext.request.contextPath}/forgotPassword">Forgot password?</a>
			    <br>
			    Admin: admin@admin.com, admin
			    <br>
			 	Tester Manager: donald@disney.com, disney123 
			 	<br>
			 	Tester: mickey@disney.com, 123
		    </div>
 		</div>
	</body> 
</html>