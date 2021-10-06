<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Game Test Studio - Edit Platform</title>
	</head>
	<body>
    	<jsp:include page="../_adminMenu.jsp" />
    	
    	<h2>Edit Platform</h2>
    	
    	<div class = "content">
	    	<s:form action="/editPlatforms">
	    		<s:textfield class="text" name="platformName" key="New Platform Name" size="100%"/>
	    		<s:submit class= "button" method="execute" key="Create"/>
	    	</s:form>
			<s:actionerror /> 
    	</div> 
    	<br>
    	
    	<div class = "content">
	    	<s:form action="/deletePlatforms">
	    		<s:checkboxlist label="Platforms" list="platformList" name="selectedPlatforms" />
	    		<s:submit class= "button" method="execute" key="Delete "/>
	    	</s:form>
    	</div>
	
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Return</a>
		<a class="button" href="${pageContext.request.contextPath}/editPlatforms"> Refresh</a>
		
	</div> 	
	</body>
</html>
