<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Bug</title>
	</head>
	<body>
		<jsp:include page="../_userMenu.jsp" />
	 		<h2>New Bug in ${userProject}</h2>
	 		
	 	<div class = "content">
	 		<s:actionerror />
	 		<s:form id="bug" action="/createBug" enctype="multipart/form-data">
	 		<table style="width:100%">
	 			<tr>
					<s:textfield class="text" name="title" key="Title" size="100%"/>
				</tr>
				<tr>
					<s:select label="Assigned"
	     					name="account"
	     					list="accountList"/>
					<s:select label="Priority"
	     					name="priority"
	     					list="priorityList"/>
	     			<s:select label="State"
	     					name="state"
	     					list="stateList"/>	
   					<s:select label="Issue Type"
	     					name="issue"
	     					list="issuesList"/>	
				</tr>

				<tr>
					<s:textarea class="text" name="description" key="Description" 
								rows="4" cols="61"  /> 
					<s:textarea class="text" name="reproSteps" key="Repro Steps" 
								rows="4" cols="61"  />
				</tr>
				<tr>
					<s:select label="Test"
	    					name="test"
	    					list="testList"/>		
					<s:checkboxlist label="Platforms" list="platformList" 
	 						name="selectedPlatforms" />
				</tr>
				<tr>
					<s:file name="fileUpload" label="Select a File to upload" 
							size="100%" /> 
				</tr>
				<tr>
					<s:select label="Build Type"
		     					name="build"
		     					list="buildList"/>
   					<s:textfield class="text" name="version" 
   								key="Version"  size="100%" type="number"/>
				</tr>
				<tr>
  						<s:textfield class="text" name="minKitNumber" 
   								key="Minimum Kit Number"  size="100%" type="number"/>
						<s:select label="Repro Frequency [%]"
	     							name="reproStr"
	     							list="reproList"/>	

				</tr>

				<s:submit class= "button"  method="execute" key="Submit" form = "bug"/>			
 			</table>
 			</s:form>
 			
	 		
	 	</div>
	 	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/projects"> Return</a>
		</div> 		
	 	
	</body>
</html>