<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Game Test Studio - Manage Project</title>
	</head>
	<body>
    	<jsp:include page="../_menu.jsp" />
    	
    	<h2>Manage Project</h2> 
	 <div class = "content">
    	
    	<s:form id="projectSerch">
    		<s:textfield name="searchTitle" key="Find Project by Title:" size="20"/>
    		<s:submit class= "button" method="execute" key="Search"/>
    	</s:form>
    	
		
    	<s:actionerror />
    	<s:form action="/createProject"  id="projectEdit"> 
        	<s:textfield name="title" key="Title" size="81" />
        	<s:textarea name="description" key="Description" rows="4" cols="61"/>
        	<s:textfield name="startDate" key="Start Date"  type="date" size="20"/>
        	<s:textfield name="endDate" key="End Date"  type="date" size="20"/>
        	<s:textfield name="testers_numbers" key="Testers Number" size="20" type="number" />
        	<s:textfield name="estimate_time" key="Estimated Time (hours)" size="20" type="number" />
        	<s:textfield name="work_time" key="Work Time" size="20" type="number" /> 
        	<s:textfield name="state" key="State" size="20"  /> 
        	
    		<s:submit class= "button" method="execute" key="Update Project"/>
    	</s:form>
	</div>			
	</body>
</html>
