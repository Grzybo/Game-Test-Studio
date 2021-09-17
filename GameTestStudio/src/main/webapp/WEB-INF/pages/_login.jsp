<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h2>Login</h2>
    <div class = "content">
    <s:actionerror />
 
    <s:form action="/login" method="post"> 
        <s:textfield name="email" key="Email" size="20" />
        <s:password name="password" key="label.password" size="20" />
        <s:submit class= "button"  method="execute" key="label.login" align="center" />
    </s:form>
    Admin: admin@admin.com, admin
    <br>
 	Normal user: donald@disney.com, disney123 
 	 
 	</div>
</body>
</html>