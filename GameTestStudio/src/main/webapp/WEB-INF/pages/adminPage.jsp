<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/jsptabcontrol.tld" prefix="jsptabcontrol" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
	<head>
		<title>Game Test Studio - Admin Page</title>
		<style><%@include file="/WEB-INF/index.css"%></style>
		<script type="text/javascript" src="js/jsptabcontrol.js" ></script>
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
					
					
					
					<display:table name="projectObjList" decorator="com.bartosz.decorators.ProjectDecorator" 
									sort="list" requestURI="${pageContext.request.contextPath}/adminPage?sort=sortProject">
					<display:column property="id" title="ID" />
					  <display:column property="titleLink" sortable="true"/>
					  <display:column property="state.name" title="State" />
					  <display:column property="estimatedTime" title="Estimated Time [h]" />
					  <display:column property="workTime" title="Time Spent [h]" />
					  <display:column property="startDate" title="Start Date" />
					  <display:column property="endDate" title="End Date" />
					  <display:column property="testersNumber" title="Testers" />
					</display:table>	
			</div>
		    
		    </jsptabcontrol:tabPage>
		    
		    <jsptabcontrol:tabPage name="AccountsTab" title="Accounts" width="100%" >
			    <div class="center">
					<a class="button" href="${pageContext.request.contextPath}/createAccount">New Account</a>
				</div>
		    	<div class = "projectContent">
		    	<display:table name="userObjList" decorator="com.bartosz.decorators.UserDecorator" 
		    					 sort="list" requestURI="${pageContext.request.contextPath}/adminPage?sort=sortUser">
					  <display:column property="id" title="ID" />
					  <display:column property="emailLink"  title="Email" sortable="true"/>
					  <display:column property="firstName" title="First Name" />
					  <display:column property="lastName" title="Last Name" />
					  <display:column property="role.name" title="Role" />
					</display:table>
		    	</div>
		    </jsptabcontrol:tabPage>
		    
	 	</jsptabcontrol:tabControl> 
	 
	 </div>
	 
	 
	 
	</body>
</html>