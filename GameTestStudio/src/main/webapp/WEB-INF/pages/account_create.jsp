<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Game Test Studio - Create Account</title>
	</head>
	<body  >
    	<jsp:include page="_menu.jsp" />
    	<h2>Create Account</h2> 
    	
    	<s:actionerror />
    	<s:form action="/createAccount" > 
        	<s:textfield name="firstName" key="First Name" size="20" />
        	<s:textfield name="lastName" key="Last Name" size="20" />
        	<s:textfield name="email" key="E-Mail" size="20" />
    		<s:submit class= "button"  method="execute" key="Create Account"/>
    	</s:form>
    	
		<a>Generated Password: ${generatedPassword}</a>	<!-- tu pojawi sie generowane haslo dla uzytkownika -->	
	
	</body>
</html>