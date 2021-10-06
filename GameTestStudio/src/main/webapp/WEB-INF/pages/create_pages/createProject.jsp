<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
	<head>
		<title>Game Test Studio - Create Project</title>
	</head>
	<body>
    	<jsp:include page="../_adminMenu.jsp" />
    	
    	<h2>Create Project</h2>
	 <div class = "content">
				
				
				
				
		<s:actionerror />
    	<s:form action="/createProject" > 
        	<s:textfield class="text" name="title" key="Title" size="100%" />
        	<s:textarea class="text" name="description" key="Description" rows="4" cols="61" size="100%" />
        	<s:textfield class="text" name="startDate" key="Start Date"  type="date" size="100%"/>
        	<s:textfield class="text" name="endDate" key="End Date"  type="date" size="100%"/>
        	<s:textfield class="text" name="testers_numbers" key="Testers Number" size="100%" type="number" />
        	<s:textfield class="text" name="estimate_time" key="Estimated Time (hours)" size="100%" type="number" />
        	<s:textfield class="text" name="work_time" key="Work Time" size="100%" type="number" />  
    		<s:submit class= "button" method="execute" key="Create Project"/>
    	</s:form>
	</div>
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Return</a>
	</div> 
	
	</body>
</html> 