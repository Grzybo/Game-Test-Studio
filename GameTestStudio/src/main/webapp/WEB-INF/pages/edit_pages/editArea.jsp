<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
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
	 			
					<s:hidden name="itemID"/>
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
					<s:textfield  class="text" size="100%" name="workTime" 
						label="Test Time" type="number" />
					
				</tr>
				<tr>
					
					<sx:datetimepicker name="startDate" label="Format (dd-MMM-yyyy)" 
						displayFormat="dd-MMM-yyyy"  />
					
					<s:textfield  class="text" size="100%" name="asd" 
						label="Start Date" type="date"/>
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
 			
	 	</div> 
	 	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/projects"> Return</a>
		</div> 	
	</body>
</html>
