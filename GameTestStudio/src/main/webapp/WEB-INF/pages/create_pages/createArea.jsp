<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Area</title>
	</head>
	<body>
		<jsp:include page="../_userMenu.jsp" />
	 		<h2>New Area in ${userProject}</h2>
	 		
	 	<div class = "content">	
	 		<s:form id="editArea" action="/createArea" method="post">
	 		
	 		<table style="width:100%">
	 			
					<s:textfield class="text" name="title" key="Title" size="100%"/>
				
		
					<s:select disabled="true" label="Project"
		     					name="project"
		     					list="projectsList"/>

						<s:select label="Priority"
		     					name="priority"
		     					list="priorityList"/>
						
						<s:select label="State"
		     					name="state"
		     					list="stateList"/>
		
				<tr>
						<s:textarea class="text" name="description" key="Description" 
									rows="4" cols="61" size="100%" 
									id="newBug"/> 
				</tr>
				<tr>
					
							<s:textfield class="text" size="100%" name="estimatedTime" label="Estimated Test Time" 
											type="number"/>
						<a> </a>
							<s:textfield  class="text" size="100%" name="workTime" 
								label="Test Time" type="number" />
					
				</tr>
				<tr>
					
							<s:textfield  class="text" size="100%" name="startDate" 
								label="Start Date" type="date"></s:textfield>
						
							<s:textfield class="text" size="100%" name="endDate" label="End Date" 
								type="date"/>
					
				</tr>
				<tr>
					
							<s:textfield class="text" size="100%" label="Testers Number" name="testersNumber" 
											type="number"  />
					
				</tr>

					<s:submit class= "button"  method="execute" key="Submit" form="editArea"/>


 			</table>
 			</s:form>
 			
 			<s:actionerror />
	 	</div>
	 	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/projects"> Cancel</a>
		</div> 	
	</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
