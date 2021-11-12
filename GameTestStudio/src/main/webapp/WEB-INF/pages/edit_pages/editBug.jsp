<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bartosz.gameteststudio.dp.DataProvider"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Bug</title>
	  	<script><%@include file="/js/index.js"%></script> <!-- THIS IS THE RIGHT WAYYYYY -->
	</head>
	<body>
		<jsp:include page="../_userMenu.jsp"/>

	 		<h2>Edit Bug</h2>
	 			 	
	 		<div class = "content"> 
	 		<s:actionerror />
	 		<s:form id="editBug" action="/updateBug" enctype="multipart/form-data">
	 		<table style="width:100%">
	 			<tr>
					<s:hidden name="itemID"/>
					<s:textfield class="text" name="title" key="Title" size="100%"/>
				</tr>
				<tr>
					<s:select label="Assigned" name="account" list="accountList"/>
					<s:select label="Priority" name="priority" list="priorityList"/>
	     			<s:select label="State" name="state" list="stateList"/>
   					<s:select label="Issue Type" name="issue" list="issuesList"/>	
				</tr>
				<tr>
					<s:textarea class="text" name="description" key="Description" rows="4" cols="61"  /> 
					<s:textarea class="text" name="reproSteps" key="Repro Steps" rows="4" cols="61"  />
				</tr>
				<tr>
					<s:select label="Test" name="test" list="testList"/>		
					<s:checkboxlist label="Platform" list="platformList" name="platforms" />
				</tr>
				<tr>
						
				</tr>
				<s:set var="id" value="fileID"/>
				<s:if test="%{#id==null}">
					<s:file name="fileUpload" label="Select a File to upload" size="100%" />  
				</s:if>
					
				<tr>
					<s:select label="Build Type" name="build" list="buildList"/>
   					<s:textfield class="text" name="version" key="Version"  size="100%" type="number" step="0.000001"/>
				</tr>
				<tr>
					<s:textfield class="text" name="minKitNumber" key="Minimum Kit Number"  size="100%" type="number"/> 
					<s:select label="Repro Frequency [%]" name="reproStr" list="reproList"/>	
				</tr>
				
				<s:submit class= "button"  method="execute" key="Save" form = "editBug"/>			
 			</table>
 			</s:form>
 			<s:if test="%{#session.userRole == 'Tester Manager' || #session.userRole == 'Tester'}">	
				<s:submit class= "deleteBtn"  method="execute" key="Delete" onclick="deleteConfirm(\"Bug\")"></s:submit>		
			</s:if>
    		<div class="center">
    		<s:set var="id" value="fileID"/>
			<s:if test="%{#id!=null}">
				<a class= "button" href="${pageContext.request.contextPath}/image?fileID=<s:property value="fileID"/>">View attached file</a>
				<a class= "deleteBtn" href="${pageContext.request.contextPath}/deleteAtt?itemID=<s:property value="itemID"/>">Delete attached file</a>
			</s:if>
			 
			</div>		
	 	</div>
	 	<div class="center">
		<a class="button" href="${pageContext.request.contextPath}/projects"> Return</a>
		</div> 	 
	 	
	</body>
</html>