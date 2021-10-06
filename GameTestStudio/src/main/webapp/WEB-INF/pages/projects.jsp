<%@ page import="java.util.ArrayList"%>
<%@ page import="com.bartosz.gameteststudio.dp.Bug"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bartosz.gameteststudio.dp.BugFabric"%>
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
		   <link href="/css/my-jsptabcontrol.css" rel="stylesheet" type="text/css"/>


    	
	</head>
	<body>
		<%
			List<Bug> list = new ArrayList<Bug>();
			for (String el : BugFabric.keys()) list.add(BugFabric.get(el)); 
			
			
			
			request.setAttribute( "bugs", list ); 
		%>
		<jsp:include page="_userMenu.jsp" />
		
			
			<div class="center">
			<h2>Project: ${userProject}</h2>
					<jsptabcontrol:tabControl name="ProjectsTabs" > 
					    <jsptabcontrol:tabPage name="BugTab" title="Bug" width="100%" >
					    	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
								<s:select label="Project" 
				     					name="selectedProject"
				     					list="projectsList"/>
							</div>
							<div class = "projectContent"> 
								
								
								<display:table name="bugs" uid="row" decorator="com.bartosz.decorators.BugDecorator" defaultsort="1" defaultorder="descending">
								  <display:column property="id" title="ID" sortable="true" headerClass="sortable"/>
								  <display:column property="titleLink" title="Title"/> <!--  href="${pageContext.request.contextPath}/editBug?itemID=${row.id}" sortable="true"/>--> 
								  <display:column property="state.name" title="State" />
								  <display:column property="priority.name" title="Priority"/>
								  <display:column property="user.email" title="Assigned To"/>
								  <display:column property="area.title" title="Area"/>
								  
								</display:table>	
								
							</div> 
						      
						    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="TestTab" title="Test" width="100%"  >
					     
					     	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createTest">New Test</a>
							</div> 
							<div class = "projectContent"> 
											<display:table name="testObjList" id="row">
											  <display:column property="id" title="ID" href="${pageContext.request.contextPath}/editTest?itemID=" paramId="id"/>
											  <display:column property="title" href="${pageContext.request.contextPath}/editTest?itemID=" paramId="id"/>
											  <display:column property="state.name" title="State" />
											  <display:column property="priority.name" title="Priority"/>
											  <display:column property="user.email" title="Assigned To"/>
  											  <display:column property="startDate" title="Start Date"/>
											  <display:column property="endDate" title="End Date"/>
											</display:table>	
							</div> 
						      
					    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="AreaTab" title="Area" width="100%" >
					      <div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
							</div> 
							<div class = "projectContent"> 
											<display:table name="areaObjList" id="row">
											  <display:column property="id" title="ID" />
											  <display:column property="title" paramId="id" href="${pageContext.request.contextPath}/editArea?itemID=${row.id}"/>
											  <display:column property="state.name" title="State"/>
											  <display:column property="priority.name" title="Priority"/>
											  <display:column property="startDate" title="Start Date"/>
											  <display:column property="endDate" title="End Date"/>
											</display:table>	
							</div> 
						      
					    </jsptabcontrol:tabPage>  
				    
				  </jsptabcontrol:tabControl> 
			</div>
	</body>
</html>
			
			

