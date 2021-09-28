<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Game Test Studio - Create Platform</title>
	</head>
	<body>
    	<jsp:include page="../_adminMenu.jsp" />
    	
    	<h2>Create Platform</h2>
    	
    	<div class = "content">
	    	<s:form action="/createPlatform">
	    		<s:textfield class="text" name="platformName" key="New Platform Name" size="100%"/>
	    		<s:submit class= "button" method="execute" key="Create"/>
	    	</s:form>
    	</div>
	
			
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Cancel</a>
	</div> 	
	</body>
</html>
