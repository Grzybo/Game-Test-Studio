<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio - Login</title>
</head>
 
<body>
    <jsp:include page="_menu.jsp" />
	 
    	 
 
 
    <h2>Login</h2>
    <div class = "content">
    <s:actionerror />
 
    <s:form action="/login" method="post"> 
        <s:textfield name="username" key="label.username" size="20" />
        <s:password name="password" key="label.password" size="20" />
        <s:submit class= "button"  method="execute" key="label.login" align="center" />
    </s:form>
     
    <br>
    Admin: admin, admin123
    <br>
 	Normal user: user, user123 
 	</div>
</body>
 
</html>