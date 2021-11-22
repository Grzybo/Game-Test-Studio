<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio - Profile</title>
<style><%@include file="/WEB-INF/index.css"%></style>
</head>
 
<body>
	<s:if test="%{#session.userRole == 'Administrator'}">
		<jsp:include page="_adminMenu.jsp" />
	</s:if>
	<s:else>
		<jsp:include page="_userMenu.jsp" />
	</s:else>
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
			<s:password class="text" name="oldPassword" key="Current Password" size="100%" />
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
   
</body>
</html>