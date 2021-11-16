<%@ page import="java.util.ArrayList"%>

<%@ page import="java.util.List"%>
<%@ page import="com.bartosz.gameteststudio.dp.DataProvider"%>
<%@ page import="com.bartosz.gameteststudio.beans.ProjectBean"%>
<%@ page import="net.sourceforge.jsptabcontrol.util.JSPTabControlUtil"%>
<%@ page import="org.displaytag.tags.TableTagParameters"%>
<%@ page import="org.displaytag.util.ParamEncoder"%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/jsptabcontrol.tld" prefix="jsptabcontrol" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projects</title>
		<style><%@include file="/WEB-INF/index.css"%></style>
	  	<script type="text/javascript" src="js/jsptabcontrol.js" ></script>
	  	<script><%@include file="/js/index.js"%></script> <!-- THIS IS THE RIGHT WAYYYYY -->
	   	<link href="/css/my-jsptabcontrol.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	
		<%
			ProjectBean project = DataProvider.mapProjects.get(session.getAttribute("userProject")); 
			String itemID = Long.toString(project.getId());
			String title = project.getTitle(); 
			String description = project.getDescription();
			Integer testers_numbers = project.getTestersNumber();
			Double estimate_time = project.getEstimatedTime(); 
			List<String> selectedPlatforms = project.getPlatformsStringList();
			Double work_time = project.getWorkTime(); 
			String startDate = project.getStartDate();
			String endDate = project.getEndDate();
			String state = project.getState().getName();
		
		%>
		
		<jsp:include page="_userMenu.jsp" />
		<s:form id = "projectForm" action="/projects" method="post">
			<s:select label="Project" name="selectedProject" list="projectsList"/>
			<s:submit class= "button"  method="execute" key="Switch Project" align="center" />
		</s:form>
		<div class="center">
			<jsptabcontrol:tabControl name="ProjectsTabs" > 
				<jsptabcontrol:tabPage name="BugTab" title="Bug" width="100%" >
		    		<div class="center">
						<s:if test="%{#session.userRole == 'Tester Manager' || #session.userRole == 'Tester'}">	
						<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
						</s:if>
					</div>
					<div class = "projectContent"> 
						<display:table name="bugObjList" id="bugTable" decorator="com.bartosz.decorators.BugDecorator" sort="list"
						  		pagesize="50" requestURI="#bugTable">
							<display:column property="id" title="ID"/>
							<display:column property="titleLink" title="Title" sortable="true" sortName="sortTitle"/> 
							<display:column property="state.name" title="State" sortable="true"/>
							<display:column property="priority.name" title="Priority" sortable="true"/>
							<display:column property="user.email" title="Assigned To" sortable="true"/>
							<display:column property="test.title" title="Test" sortable="true"/>
							<display:column property="test.area.title" title="Area" sortable="true"/>
							<display:column property="minKitNumber" title="Min. Kits" sortable="true"/>	
						  	<display:column property="reproFrequency" title="Repro Frequency[%]" sortable="true"/>
						  	<display:column property="issueType.name" title="Issue Type" sortable="true"/>
						  	<s:if test="%{#session.userRole == 'Tester Manager' || #session.userRole == 'Tester'}">
						  		<display:column property="deleteLink" title="X" ></display:column>
						  	</s:if>
						</display:table> 
					</div>  
				</jsptabcontrol:tabPage>    
			    <jsptabcontrol:tabPage name="TestTab" title="Test" width="100%"  >     
			     	<div class="center">
						<s:if test="%{#session.userRole == 'Tester Manager'}"> 	
						<a class="button" href="${pageContext.request.contextPath}/createTest">New Test</a>
						</s:if>
					</div> 
						<div class = "projectContent"> 
							<display:table name="testObjList" id="testTable" decorator="com.bartosz.decorators.TestDecorator" sort="list" 
											pagesize="50" requestURI="#testTable">
								<display:column property="id" title="ID"/>
								<display:column property="titleLink" title="Title" sortable="true" />
								<display:column property="state.name" title="State" sortable="true"/>
								<display:column property="priority.name" title="Priority" sortable="true"/>
								<display:column property="user.email" title="Assigned To" sortable="true"/>
								<display:column property="startDate" title="Start Date" sortable="true"/>
								<display:column property="endDate" title="End Date" sortable="true"/>
								<display:column property="area.title" title="Area" sortable="true"/>
								<display:column property="version" title="Version" sortable="true"/>
								<display:column property="build.name" title="Build" sortable="true"/>
								<display:column property="result.name" title="Result" sortable="true"/>
								<s:if test="%{#session.userRole == 'Tester Manager'}">
						  			<display:column property="deleteLink" title="X" ></display:column>
						  		</s:if>
							</display:table>	
						</div>  
		    	</jsptabcontrol:tabPage>
			    <jsptabcontrol:tabPage name="AreaTab" title="Area" width="100%" >
				<div class="center">
				<s:if test="%{#session.userRole == 'Tester Manager'}"> 	
					<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
				</s:if>
				</div> 
				<div class = "projectContent"> 
					<display:table name="areaObjList" id="areaTable" decorator="com.bartosz.decorators.AreaDecorator" sort="list" pagesize="50" requestURI="#areaTable"	>
						<display:column property="id" title="ID" />
						<display:column  property="titleLink" title="Title"  sortable="true" />
						<display:column property="state.name" title="State"  sortable="true"/>
						<display:column property="priority.name" title="Priority"  sortable="true"/>
						<display:column property="startDate" title="Start Date"  sortable="true"/>
						<display:column property="endDate" title="End Date"  sortable="true"/>
						<display:column property="estimatedTime" title="Estimated Time [h]"  sortable="true"/>
					  	<display:column property="workTime" title="Time Spent [h]" sortable="true"/>
					  	<display:column property="testersNumber" title="Testers" sortable="true"/>		
					  	<s:if test="%{#session.userRole == 'Tester Manager'}">
				  			<display:column property="deleteLink" title="X" ></display:column>
				  		</s:if>				
					</display:table>	
				</div> 						      
			</jsptabcontrol:tabPage>
			<jsptabcontrol:tabPage name="ProjectTab" title="Project" width="100%" >
			<br>
				<jsp:include page="/WEB-INF/pages/edit_pages/projectView.jsp"/>
			</jsptabcontrol:tabPage>  
		  </jsptabcontrol:tabControl> 
		</div>  
	</body>
</html>
			
			

