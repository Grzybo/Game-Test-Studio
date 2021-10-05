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
		<jsp:include page="_userMenu.jsp" />
		
			
			<div class="center">
			<h2>Project: ${userProject}</h2>
					<jsptabcontrol:tabControl name="MY_TABCONTROL" > 
					    <jsptabcontrol:tabPage name="MY_TABPAGE1" title="Bug" width="100%" >
					    	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
								<s:select label="Project" 
				     					name="selectedProject"
				     					list="projectsList"/>
							</div>
							<div class = "projectContent"> 
								<display:table name="bugObjList" id="row">
								<display:column  property="id" title="ID"  href="${pageContext.request.contextPath}/editTest?itemID=" paramId="id"/>
								  <display:column property="title"  href="${pageContext.request.contextPath}/editTest?itemID=" paramId="id" />
								  <display:column property="state.name" title="State"/>
								  <display:column property="priority.name" title="Priority"/>
								  <display:column property="user.email" title="Assigned To"/>
								</display:table>	
							</div> 
						      
						    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="MY_TABPAGE2" title="Test" width="100%"  >
					     
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
											</display:table>	
							</div> 
						      
					    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="MY_TABPAGE3" title="Area" width="100%" >
					      <div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
							</div> 
							<div class = "projectContent"> 
											<display:table name="areaObjList" id="row">
											  <display:column property="id" title="ID" />
											  <display:column property="title" paramId="id" href="${pageContext.request.contextPath}/editArea?itemID=${row.id}"/>
											  <display:column property="state.name" title="State"/>
											  <display:column property="priority.name" title="Priority"/>
											</display:table>	
							</div> 
						      
					    </jsptabcontrol:tabPage>  
				    
				  </jsptabcontrol:tabControl> 
			</div> 
	</body>
</html>
			
			

