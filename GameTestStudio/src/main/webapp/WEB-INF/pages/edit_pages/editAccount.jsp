<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%@ page import="com.bartosz.gameteststudio.dp.DataProvider"%>
<html>
	<head>
		<title>Game Test Studio - Create Account</title>
		<script><%@include file="/js/index.js"%></script> <!-- THIS IS THE RIGHT WAYYYYY -->
	</head>
	<body> 
    	<jsp:include page="../_adminMenu.jsp" />

    	<h2>Manage Account</h2>
	 
    	 <div class = "content" >
    	<s:actionerror />
    	<s:form action="/updateAccount" id = "form"  method="post" enctype="multipart/form-data"> 
        	<s:hidden name="itemID"/>
        	<s:textfield class="text" name="firstName" key="First Name" size="100%" />
        	<s:textfield class="text" name="lastName" key="Last Name" size="100%" />
	   		<s:select label="Role" name="role" list="rolesList"/>
			<s:checkboxlist label="Project" list="projectsList" name="projects" />    		
	   		<s:submit class= "button"  method="execute" key="Update Account" form = "form"/>
    	</s:form> 
    	<s:submit class= "deleteBtn"  method="execute" key="Delete" onclick="deleteConfirm(\"User\")"></s:submit>	 
	</div> 
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Return</a>
	</div> 			
	</body>
</html> 
