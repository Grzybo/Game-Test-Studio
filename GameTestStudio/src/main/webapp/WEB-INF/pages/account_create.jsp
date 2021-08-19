<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Game Test Studio - Create Account</title>
	</head>
	<body> 
    	<jsp:include page="_menu.jsp" />
	 <div class = "content" >
    	
    	<h2>Create Account</h2> 
    	
    	<s:actionerror />
    	<s:form action="/createAccount" id = "form"  > 
        	<s:textfield name="firstName" key="First Name" size="20" />
        	<s:textfield name="lastName" key="Last Name" size="20" />
        	<s:textfield name="email" key="E-Mail" size="20" />
        
    		
   		<label>Role:</label> <!-- mozna przeniesc select blizej lewej aby bylo rowno z form -->
		<select id="roles" name="roleslist" form="carform" >
		  <option value="tester">Tester</option>
		  <option value="testerManager">Test Manager</option>
		  <option value="dev">Developer</option>
		  <option value="devManager">Developer Manager</option>
		</select>
		    		
   		<s:submit class= "button"  method="execute" key="Create Account" form = "form"/>
    	</s:form>
    	
		<a>Generated Password: ${generatedPassword}</a>	<!-- tu pojawi sie generowane haslo dla uzytkownika -->	
	</div>
	</body>
</html>