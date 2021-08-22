<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Bug</title>
	</head>
	<body>
		<jsp:include page="_menu.jsp" />
	 	<div class = "content">
	 		<h2>New Bug</h2>
	 		<s:form id="newBug" action="/createBug" >
				<s:textfield name="title" key="Title" size="95%"/>
				<s:textfield name="title" key="Title" size="95%"/>
				<label>Assigned Account: </label> <!-- mozna przeniesc select blizej lewej aby bylo rowno z form -->
					<select id="newBug" name="assignedAccount" >
					  <option value="tester">Tester</option>
					  <option value="testerManager">Test Manager</option>
					  <option value="dev">Developer</option>
					  <option value="devManager">Developer Manager</option>
				</select>
				
				
				
				<s:submit class= "button"  method="execute" key="Create" form = "search"/>
			</s:form>
	 			
	 	
	 	</div>
	</body>
</html>