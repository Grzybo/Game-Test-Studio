<%@ page import="java.util.ArrayList"%>
<%@ page import="com.bartosz.gameteststudio.dp.Bug"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bartosz.gameteststudio.dp.BugFabric"%>
<%@ page import="com.bartosz.gameteststudio.dp.User"%>
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
		   <link href="/css/my-jsptabcontrol.css" rel="stylesheet" type="text/css"/>


    	
	</head>
	<body>
		
		<% 
			List<Bug> list = new ArrayList<Bug>(); 
			for (String el : BugFabric.keys()) list.add(BugFabric.get(el));
		 	session.setAttribute("bugs", list);
		
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
								<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
								
							</div>
							<div class = "projectContent"> 
								
								
								<display:table name="bugObjList" id="bugTable" decorator="com.bartosz.decorators.BugDecorator" sort="list" pagesize="3"
												requestURI="${pageContext.request.contextPath}/projects?sort=sortBug">
								  <display:column property="id" title="ID"/>
								  <display:column property="titleLink" title="Title"  sortable="true" sortName="sortTitle"/> 
								  <display:column property="state.name" title="State" />
								  <display:column property="priority.name" title="Priority"/>
								  <display:column property="user.email" title="Assigned To"/>
								  <display:column property="test.area.title" title="Area"/>
								  
								</display:table>	
								
							</div>
						      
						    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="TestTab" title="Test" width="100%"  >
					     
					     	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createTest">New Test</a>
							</div> 
							<div class = "projectContent"> 
											<display:table name="testObjList" id="testTable" decorator="com.bartosz.decorators.TestDecorator" sort="list" 
															requestURI="${pageContext.request.contextPath}/projects?sort=sortTest">
											  <display:column property="id" title="ID"/>
											  <display:column property="titleLink" title="Title"  sortable="true" />
											  <display:column property="state.name" title="State" />
											  <display:column property="priority.name" title="Priority"/>
											  <display:column property="user.email" title="Assigned To"/>
  											  <display:column property="startDate" title="Start Date"/>
											  <display:column property="endDate" title="End Date"/>
											  <display:column property="area.title" title="Area"/>
											</display:table>	
							</div> 
						      
					    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="AreaTab" title="Area" width="100%" >
					      <div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
							</div> 
							<div class = "projectContent"> 
											<display:table name="areaObjList" id="areaTable" decorator="com.bartosz.decorators.AreaDecorator" sort="list" 
															requestURI="${pageContext.request.contextPath}/projects?sort=sortTest"	>
											  <display:column property="id" title="ID" />
											  <display:column  property="titleLink" title="Title"  sortable="true" />
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
			
			

