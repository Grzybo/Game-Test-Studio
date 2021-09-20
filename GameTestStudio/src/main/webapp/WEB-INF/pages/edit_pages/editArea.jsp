<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Area</title>
	</head>
	<body>
		<jsp:include page="../_userMenu.jsp" />
	 	
	 		<h2>Edit Area</h2>
	 		
	 		<div class = "content">	
	 		<s:form id="editArea" action="/updateArea" method="post">
	 		
	 		<table style="width:100%">
	 			<tr>
	 				
	 			</tr>
	 			
	 			<tr>
	 				
						<s:textfield name="title" key="Title" size="80%"/>
					
				</tr>
			
				<tr>
					
						<s:select disabled="true" label="Project"
		     					name="project"
		     					list="projectsList"/>
  						<a> </a>
						<s:select label="Priority"
		     					name="priority"
		     					list="priorityList"/>
						<a> </a>
						<s:select label="State"
		     					name="state"
		     					list="stateList"/>
					
				</tr>
			
				<tr>
					
						<s:textarea name="description" key="Description" 
									rows="4" cols="61" maxwidth="61" 
									id="newBug"/> 
					
				</tr>
				<tr>
					
							<s:textfield name="estimatedTime" label="Estimated Test Time" 
											type="number" size="10%"/>
						<a> </a>
							<s:textfield name="workTime" label="Test Time" type="number" size="10%"/>
					
				</tr>
				<tr>
					
							<s:textfield name="startDate" label="Start Date" type="date"/>
						<a> </a>
							<s:textfield name="endDate" label="End Date" type="date"/>
					
				</tr>
				<tr>
					
							<s:textfield label="Testers Number" name="testersNumber" 
											type="number" size="10%" />
					
				</tr>
				<th>
					<s:submit class= "button"  method="execute" key="Submit" form="editArea"/>
					
				</th>
				<th>
					<a class="button" href="${pageContext.request.contextPath}/projects">Cancel</a> 
				</th>

				 
				
							
 			</table>
 			</s:form>
	 	</div>
	</body>
</html>
