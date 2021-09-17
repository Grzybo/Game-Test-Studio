<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "content">
   <h2>Hello, ${loginedUsername}!</h2> 
	<s:form action="/userInfo" method="post">
        <s:label>Change Profile Data:</s:label>
		<s:textfield name="firstName" key="First Name" size="50%" placeholder="Leave empty, if not changing" />
       	<s:textfield name="lastName" key="Last Name" size="50%" placeholder="Leave empty, if not changing" /> 
        <s:password name="oldPassword" key="Actual Password" size="50%" />
        <s:password name="newPassword1" key="New Password" size="50%" />
        <s:password name="newPassword2" key="New Password" size="50%" />
        <s:submit class= "button"  method="execute" key="Update Profile" align="center" />
    </s:form>
	<s:actionerror />
   </div>
</body>
</html>