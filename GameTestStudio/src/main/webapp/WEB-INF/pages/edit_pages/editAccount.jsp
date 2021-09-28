<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Game Test Studio - Create Account</title>
	</head>
	<body> 
    	<jsp:include page="../_adminMenu.jsp" />
    	
    	<h2>Manage Account</h2>
	 <div class = "content">
    	<s:form id="projectSerch" action="/editAccount">
    				<s:textfield  class="text" name="searchEmail" key="Find User by Email" size="100%"/>
    				<s:submit class= "button" method="execute" key="Search"/>
    				</s:form>
   	</div>
   	<br>
    	 <div class = "content" >
    	<s:actionerror />
    	<s:form action="/updateAccount" id = "form"  method="post"> 
        	<s:textfield class="text" name="firstName" key="First Name" size="100%" />
        	<s:textfield class="text" name="lastName" key="Last Name" size="100%" />
        	<s:textfield class="text" name="email" key="E-Mail" size="100%" />
        
    		
   		<s:select label="Role"
	     					name="role"
	     					list="rolesList"/>
		<s:checkboxlist label="Project" list="projectsList" 
	 						name="projects" />    		
		    		
		    		
   		<s:submit class= "button"  method="execute" key="Update Account" form = "form"/>
    	</s:form>

    	
    	
	</div> 
	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/adminPage"> Cancel</a>
	</div> 			
	</body>
</html> 


<!--   
			 		<table style="width:100%">
			    		<tr>
			    			<th style="width:25%">Project</th>
			    			<th style="width:25%">Area</th>
			    			<th style="width:25%">Test</th>
			    			<th style="width:25%">Bug</th>
			    		</tr>
			   			<tr>
			   				<th><input type="checkbox" id="form" name="projectPermisions" value="read" checked> Read </th>
			   				<th><input type="checkbox" id="form" name="areaPermisions" value="read" checked> Read </th>
			   				<th><input type="checkbox" id="form" name="testPermisions" value="read" checked> Read </th>
			   				<th><input type="checkbox" id="form" name="bugPermisions" value="read" checked> Read </th>
			   			</tr>
			   				<tr>
			   				<th><input type="checkbox" id="form" name="projectPermisions" value="write" > Write </th>
			   				<th><input type="checkbox" id="form" name="areaPermisions" value="write" > Write </th>
			   				<th><input type="checkbox" id="form" name="testPermisions" value="write" > Write </th>
			   				<th><input type="checkbox" id="form" name="bugPermisions" value="write" > Write </th>
			   			</tr>	
			   			<tr>
			   				<th><input type="checkbox" id="form" name="projectPermisions" value="modify" > Modify </th>
			   				<th><input type="checkbox" id="form" name="areaPermisions" value="modify" > Modify </th>
			   				<th><input type="checkbox" id="form" name="testPermisions" value="modify" > Modify </th>
			   				<th><input type="checkbox" id="form" name="bugPermisions" value="modify" > Modify </th>
			   			</tr>	
		    		</table>  -->