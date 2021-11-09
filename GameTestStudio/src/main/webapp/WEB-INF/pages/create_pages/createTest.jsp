<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Test</title>
	</head>
	<body>
		<jsp:include page="../_userMenu.jsp" />
	 		<h2>New Test in ${userProject} </h2>
	 	<div class = "content">
		 		<s:form id="editTest" action="/createTest" >
		 		<table style="width:100%">
		 			<tr>
						<s:textfield class="text" name="title" key="Title" size="100%"/>
					</tr>
					<tr>
						<s:select label="Assigned" name="account" list="accountList"/>
						<s:select label="Priority" name="priority" list="priorityList"/>
		     			<s:select label="State" name="state" list="stateList"/>				
					</tr>
					<tr>
						<s:textarea name="description" key="Test Scenario" rows="4" 
							cols="61"  id="newBug"/> <br>
					</tr>
					<tr>
						<s:select label="Area" name="area" list="areaList"/>		
						<s:checkboxlist label="Platform" list="platformList" name="selectedPlatforms" />
					</tr>
					<tr>
						<s:textfield class="text" size="100%" name="estimatedTime" label="Estimated Test Time" type="number" step="0.01"/>
						<s:textfield  class="text" size="100%" name="workTime" label="Test Time" type="number" step="0.01" />
					</tr>
					<tr>
						<s:select label="Build Type" name="build" list="buildList"/>
	   					<s:textfield class="text" name="version" key="Version"  size="100%" type="number" step="0.000001"/>
						<s:select label="Result" name="result" list="resultList"/>
					</tr>
					<tr>
						<s:textfield  class="text" size="100%" name="startDate" label="Start Date" type="date"/>
						<s:textfield class="text" size="100%" name="endDate" label="End Date" type="date"/>
					</tr>
					<tr>
						<s:textfield class="text" size="100%" label="Testers Number" name="testersNumber" type="number" step="0.01" />
					</tr>
						<s:submit class= "button"  method="execute" key="Save" form = "editTest"/>
	 			</table>
	 			</s:form>	
	 			<s:actionerror /> 
	 	</div>
	 	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/projects"> Return</a>
		</div> 	
	</body>
</html>