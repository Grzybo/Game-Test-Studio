<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/jsptabcontrol.tld" prefix="jsptabcontrol" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Game Test Studio - Admin Page</title>
		<style><%@include file="/WEB-INF/index.css"%></style>
		<script type="text/javascript" src="js/jsptabcontrol.js" ></script>
		<script><%@include file="/js/index.js"%></script> <!-- THIS IS THE RIGHT WAYYYYY -->
		<link href="/css/my-jsptabcontrol.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>    	
    	<jsp:include page="_adminMenu.jsp" />
		 <div class="center">
		 	<jsptabcontrol:tabControl name="AdminTabs" >
			    <jsptabcontrol:tabPage name="ProjectsTab" title="Projects"  width="100%">
				    <div class="center">
						<a class="button" href="${pageContext.request.contextPath}/createProject">New Project</a>
					</div>
					<div class = "projectContent">
						<display:table name="projectObjList" decorator="com.bartosz.decorators.ProjectDecorator" id="projectsTable" sort="list"  pagesize="50" requestURI="#projectsTable">
							<display:column property="id" title="ID"/>
						  	<display:column property="titleLink" title="Title" sortable="true"/>
						  	<display:column property="state.name" title="State" sortable="true"/>
						  	<display:column property="estimatedTime" title="Estimated Time [h]"  sortable="true"/>
						  	<display:column property="workTime" title="Time Spent [h]" sortable="true"/>
						  	<display:column property="startDate" title="Start Date" sortable="true"/>
						  	<display:column property="endDate" title="End Date" sortable="true"/>
						  	<display:column property="testersNumber" title="Testers" sortable="true"/>	  	
							<display:column property="deleteLink" title=" " ></display:column>
						</display:table>	
					</div>
			    </jsptabcontrol:tabPage>
			    <jsptabcontrol:tabPage name="AccountsTab" title="Accounts" width="100%" >
				    <div class="center">
						<a class="button" href="${pageContext.request.contextPath}/createAccount">New Account</a>
					</div>
			    	<div class = "projectContent">
				    	<display:table name="userObjList" decorator="com.bartosz.decorators.UserDecorator" id="accountsTable" sort="list"  pagesize="50" requestURI="#accountsTable">
							  <display:column property="id" title="ID" />
							  <display:column property="emailLink"  title="Email" sortable="true"/>
							  <display:column property="firstName" title="First Name" sortable="true"/>
							  <display:column property="lastName" title="Last Name" sortable="true"/>
							  <display:column property="role.name" title="Role" sortable="true"/>
							  <display:column property="deleteLink" title=" " ></display:column>
						</display:table>
			    	</div>
			    </jsptabcontrol:tabPage> 
			     <jsptabcontrol:tabPage name="ActionsTab" title="Permissions" width="100%" >
			    	<br>
			    	<div class = "projectContent">
				    	<h2>Assign roles to actions:</h2>
				    	<s:form id="bug" action="/updateAction" enctype="multipart/form-data">
				    		<s:select label="Action" name="selectedAction" list="actionList" onchange="refreshAdminPage()"/>
				    		<s:checkboxlist label="Roles" list="rolesList" name="selectedRoles" />
				    		<s:submit class= "button"  method="execute" key="Save" align="center" />
				    	</s:form>			    	
			    	</div>
			    </jsptabcontrol:tabPage>
	 		</jsptabcontrol:tabControl> 
	 	</div>
	</body>
</html>