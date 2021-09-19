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
        	<s:textfield name="firstName" key="First Name" size="20" />
        	<s:textfield name="lastName" key="Last Name" size="20" />
        	<s:textfield name="email" key="E-Mail" size="20" />
        
    		
   		<label>Role:</label> <!-- mozna przeniesc select blizej lewej aby bylo rowno z form -->
		<select id="roles" name="role" form="form" >
		  <option value="Tester">Tester</option>
		  <option value="Test Manager">Test Manager</option>
		  <option value="Developer">Developer</option>
		  <option value="Developer Manager">Developer Manager</option>
		</select>
		    		
   		<s:submit class= "button"  method="execute" key="Create Account" form = "form"/>
    	</s:form>
    	
	</div>
	</body>
</html>