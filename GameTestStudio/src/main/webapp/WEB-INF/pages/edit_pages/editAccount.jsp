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
    	<s:form id="projectSerch">
    				<s:textfield name="searchTitle" key="Find User by Email:" size="50%"/>
    				<s:submit class= "button" method="execute" key="Search"/>
    				</s:form>
   	</div>
   	<br>
    	 <div class = "content">
    	<table style="width:100%">
    		<tr>
		    	<th>
		    	
    			
		    	<s:form action="/createAccount" id = "form"  > 
		        	<s:textfield name="firstName" key="First Name" size="20" />
		        	<s:textfield name="lastName" key="Last Name" size="20"  />
		        	<s:textfield name="email" key="E-Mail" size="20" />
	        	</s:form>
	        	</th>
	        </tr>
	    	<tr >	
		   		<s:form class = "left" id = "form">
			   		<label>Role: </label> 
					<select id="form" name="roleslist" >
					  <option value="tester">Tester</option>
					  <option value="testerManager">Test Manager</option>
					  <option value="dev">Developer</option>
					  <option value="devManager">Developer Manager</option>
					</select>
				</s:form>
			 </tr>
			 <tr>
			 	<th>
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
		    		</table> 
	    		</th>  		
	    	 </tr>
	    	 <tr>
	    	 	<s:form id = "form">
	    	 	<label>Projects:</label> <br> 
						<select multiple>
  							<option value="a">FIFA 22</option>
						  	<option value="b">FIFA 21</option>
						</select>
				</s:form>
	    	 </tr>
	    	 <tr>    	 
		   		<s:submit class= "button"  method="execute" key="Update Account" form = "form"/>
	    	 </tr>
    	</table>
    	
    	
	</div>			
	</body>
</html>