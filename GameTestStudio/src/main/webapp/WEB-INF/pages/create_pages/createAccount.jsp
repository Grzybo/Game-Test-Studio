<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Game Test Studio - Create Account</title>
	</head>
	<body> 
    	<jsp:include page="../_menu.jsp" />
	 
    	
    	<h2>Create Account</h2> 
    	<div class = "content" >
    	<s:actionerror />
    	<s:form action="/createAccount" id = "form"  method="post"> 
        	<s:textfield name="firstName" key="First Name" size="20" />
        	<s:textfield name="lastName" key="Last Name" size="20" />
        	<s:textfield name="email" key="E-Mail" size="20" />
        
    		
   		<s:select label="Roles"
       		name="role"
       		headerKey="-1" 
       		list="rolesList"

		/>
		
   		<s:submit class= "button"  method="execute" key="Create Account" form = "form"/>
    	</s:form>
    	
	</div>
	</body>
</html> 


