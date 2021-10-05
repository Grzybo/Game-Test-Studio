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
	 	
		    <jsptabcontrol:tabPage name="ProjectsTab" title="Projects"  >
		    <div class="center">
				<a class="button" href="${pageContext.request.contextPath}/createProject">New Project</a>
			</div>

					<display:table name="projectObjList">
					<display:column property="id" title="ID" />
					  <display:column property="title"/>
					  <display:column property="state.name" title="State" />
					  <display:column property="estimatedTime" title="Estimated Time [h]" />
					  <display:column property="workTime" title="Time Spent [h]" />
					  <display:column property="startDate" title="Start Date" />
					  <display:column property="endDate" title="End Date" />
					  <display:column property="testersNumber" title="Testers" />
					</display:table>	

		    
		    </jsptabcontrol:tabPage>
		    
		    <jsptabcontrol:tabPage name="AccountsTab" title="Accounts" width="100%" >
			    <div class="center">
					<a class="button" href="${pageContext.request.contextPath}/createAccount">New Account</a>
				</div>
		    	
		    	<display:table name="userObjList">
					  <display:column property="id" title="ID" />
					  <display:column property="email"/>
					  <display:column property="firstName" title="First Name" />
					  <display:column property="lastName" title="Last Name" />
					  <display:column property="role.name" title="Role" />
					</display:table>
		    	
		    </jsptabcontrol:tabPage>
		    
		    <jsptabcontrol:tabPage name="PlatformsTab" title="Platforms" width="100%" >
		    </jsptabcontrol:tabPage>
	 	</jsptabcontrol:tabControl> 
	 
	 </div>
	 
	 
	 
	</body>
</html>