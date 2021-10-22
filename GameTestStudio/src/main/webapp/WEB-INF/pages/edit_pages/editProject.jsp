<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Game Test Studio - Manage Project</title>
	</head>
	<body>
    	<jsp:include page="../_adminMenu.jsp"/>
    	
    	<h2>Manage Project</h2>
    	
		 <div class = "content">
<s:hidden name="itemID"/>
		<s:actionerror />
    	<s:form action="/updateProject" > 
    	<s:hidden name="itemID"/>
        	<s:textfield class="text" name="title" key="Title" size="100%" />
        	<s:textarea class="text" name="description" key="Description" rows="4" cols="61" size="100%" />
        	<s:textfield class="text" name="startDate" key="Start Date"  type="date" size="100%"/>
        	<s:textfield class="text" name="endDate" key="End Date"  type="date" size="100%"/>
        	<s:select label="State"
	     					name="state"
	     					list="stateList"/>	
        	<s:textfield class="text" name="testers_numbers" key="Testers Number" size="100%" type="number" />
        	<s:textfield class="text" name="estimate_time" key="Estimated Time (hours)" size="100%" type="number" />
        	<s:textfield class="text" name="work_time" key="Work Time" size="100%" type="number" /> 
        	<s:checkboxlist label="Platforms" list="platformList" name="selectedPlatforms" />
    		<s:submit class= "button" method="execute" key="Update Project"/>
    	</s:form>
	</div>		
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Return</a>
	</div> 	
	</body>
</html>
