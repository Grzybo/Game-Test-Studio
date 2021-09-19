<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Bug</title>
	</head>
	<body>
		<jsp:include page="../_adminMenu.jsp"/>
	 	
	 		<h2>Edit Bug</h2>
	 		
	 		<div class = "content">
	 		<s:form id="serch">
    				<s:textfield name="searchTitle" key="Find Bug by Title:" size="80%"/>
    				<s:submit class= "button" method="execute" key="Search"/>
    			</s:form>
	 		</div>
	 		<br>
	 		<div class = "content">
	 		<table style="width:100%">
	 			<tr>
	 				<s:form id="newBug" action="/createBug" >
						<s:textfield name="title" key="Title" size="95%"/>
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
						<label>Assigned Account: </label> 
							<select id="newBug" name="assignedAccount" >	
								<option>Donald Duck</option>
								<option> Mickey Mouse</option>
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
					<s:textarea name="description" key="Description" rows="4" cols="61" maxwidth="61" id="newBug"/> <br>
					<br>
					<s:textarea name="reproSteps" key="Repro Steps" rows="4" cols="61" maxwidth="61" id="newBug"/>
					<br>
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
  						<label> Area: </label> <!-- trzeba przeniesc select blizej lewej aby bylo rowno z form -->
						<select name="project">
	  						<option value="fifa22" selected>GoalKeepers </option>
	  						<option value="fifa21">Stadiums</option>
  						</select>
  						<a> </a>
  						<br><br>
						<label>Platforms:</label> <br> 
						<select multiple>
  							<option value="a">PS5</option>
						  	<option value="b">Xbox Series X</option>
							<option value="c">Xbox ONE</option>
						</select>
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
				 		<label for="myfile">Select a file:</label>
						<input type="file" id="myfile" name="myfile" multiple> 
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
					<label>Version: </label>
						<select name="version">
	  						<option>0.0123 Beta</option>
	  						<option>1.4567 Alfa</option>
  						</select>
  						<a> </a>
  						<label>Issue Type: </label>
						<select name="issueType">
	  						<option>Crash</option>
	  						<option>Graphical</option>
	  						<option>Placeholder</option>
	  						<option>Content</option>
  						</select>
					</s:form>
				</tr>
				<br>
				<tr>
					<s:form id="newBug">
  						<label>Minimum Kit Number: </label>
							<input type="number" size="10%">
						<a> </a>
						<label>Repro Rate: </label>
						<select name="reproRate">
	  						<option>100%</option>
	  						<option>80%</option>
	  						<option>75%</option>
	  						<option>60%</option>
	  						<option>50%</option>
	  						<option>40%</option>
	  						<option>25%</option>
	  						<option>20%</option>
  						</select>
					</s:form> 
				</tr>
				<br>

				<s:submit class= "button"  method="execute" key="Create" form = "search"/>			
 			</table>
	 	</div>
	</body>
</html>