<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Game Test Studio - Create Account</title>
	</head>
	<body> 
    	<jsp:include page="../_adminMenu.jsp"/>
	 
    	
    	<h2>Create Account</h2> 
    	<div class = "content" >
    	<s:actionerror />
    	<s:form action="/createAccount" id = "form"  method="post"> 
        	<s:textfield class="text" name="firstName" key="First Name" size="100%" />
        	<s:textfield class="text" name="lastName" key="Last Name" size="100%" />
        	<s:textfield class="text" name="email" key="E-Mail" size="100%" />
        
    		
   		<s:select label="Role"
	     					name="role"
	     					list="rolesList"/> 
	     					
		<s:select label="Bug Permission"
	     					name="bugPer"
	     					list="permissionsList"/>
		<s:select label="Test Permission"
	     					name="testPer"
	     					list="permissionsList"/>
		<s:select label="Area Permission"
	     					name="areaPer"
	     					list="permissionsList"/>
		<s:checkboxlist label="Project" list="projectsList" 
	 						name="projects" />    		
		    		
		    		
   		<s:submit class= "button"  method="execute" key="Create Account" form = "form"/>
    	</s:form>
    	
	</div>
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Return</a>
	</div> 
	</body>
</html>