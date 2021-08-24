<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Area</title>
	</head>
	<body>
		<jsp:include page="_menu.jsp" />
	 	<div class = "content">
	 		<h2>New Area</h2>
	 		
	 		<table style="width:100%">
	 			<tr>
	 				<s:form id="newBug" action="/createBug" >
						<s:textfield name="title" key="Title" size="95%"/>
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
						<label> Project: </label> <!-- trzeba przeniesc select blizej lewej aby bylo rowno z form -->
						<select name="project">
	  						<option value="fifa22" selected>FIFA 22 </option>
	  						<option value="fifa21">FIFA 21</option>
  						</select>
  						<a> </a>
						<label>Priority: </label> 
						<select id="newBug" name="priority" >	
							<option>Critical</option>
							<option>Important</option>
							<option>Very Important</option>
							<option>Normal</option>
						</select>
						<a> </a>
						<label>State: </label> 
						<select id="newBug" name="priority" >	
							<option>New</option>
							<option>Active</option>
							<option>Closed</option>
						</select>
					</s:form>	
				</tr>
				<br>
				<tr>
					<s:textarea name="description" key="Test Scenario" rows="4" cols="61" maxwidth="61" id="newBug"/> <br>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">

					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
						<label>Estimated Test Time: </label>
							<input type="number" size="10%">
						<a> </a>
						<label>Test Time: </label>
							<input type="number" size="10%">
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
						<label>Start Date: </label>
							<input type="date">
						<a> </a>
						<label>End Date: </label>
							<input type="date">
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
						<label>Testers Number: </label>
							<input type="number" size="10%" disabled>
					</s:form>
				</tr>
				<br>

				<s:submit class= "button"  method="execute" key="Create" form = "search"/>			
 			</table>
	 	</div>
	</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
