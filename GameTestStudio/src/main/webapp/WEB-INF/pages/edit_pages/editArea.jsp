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
	 		<table style="width:100%">
	 			<tr>
	 				
	 			</tr>
	 			
	 			<tr>
	 				<s:form id="editArea" action="/editArea" method="post">
						<s:textfield name="title" key="Title" size="95%"/>
					</s:form>
				</tr>
			
				<tr>
					<s:form id="editArea">
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
					</s:form>	
				</tr>
			
				<tr>
					<s:textarea name="description" key="Description" 
								rows="4" cols="61" maxwidth="61" 
								id="newBug"/> 
			
				</tr>
				<tr>
					<s:form id="newBug">

					</s:form>
				</tr>
				<tr>
					<s:form id="editArea">
							<s:textfield name="estimatedTime" label="Estimated Test Time" 
											type="number" size="10%"/>
						<a> </a>
							<s:textfield name="workTime" label="Test Time" type="number" size="10%"/>
					</s:form>
				</tr>
				<tr>
					<s:form id="editArea">
							<s:textfield name="startDate" label="Start Date" type="date"/>
						<a> </a>
							<s:textfield name="endDate" label="End Date" type="date"/>
					</s:form>
				</tr>
				<tr>
					<s:form id="editArea">
							<s:textfield label="Testers Number" name="testersNumber" 
											type="number" size="10%" />
					</s:form>
				</tr>
				<th>
					<s:submit class= "button"  method="execute" key="Submit" form="editArea"/>
				</th>
				<th>
					<a class="button" href="${pageContext.request.contextPath}/projects">Cancel</a> 
				</th>

				 
				
							
 			</table>
 			
	 	</div>
	</body>
</html>
