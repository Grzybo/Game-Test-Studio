<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/jsptabcontrol.tld" prefix="jsptabcontrol" %>

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
			
					<jsptabcontrol:tabControl name="MY_TABCONTROL" > 
					    <jsptabcontrol:tabPage name="MY_TABPAGE1" title="Bug" width="100%" >
					    	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
							</div>
							<div class="table">
								<table style="width:100%" >
									<tr>
										<td style="width:70%"  valign="top" >
								
											<div class = "projectContent"> 
											<s:iterator value="bugObjList" var="el">
												<div class="container themed-container" >
						   							<a class="button" 
						   								href="${pageContext.request.contextPath}/editBug?itemID=${el.id}">
						   									[${el['class'].simpleName}] :
							   								<s:property value="#el.title" /> | 
												  			<s:property value="#el.state.name" /> |
												  			<s:property value="#el.priority.name" /> 
												  			<s:property value="#el.user.email" />  
						   							</a> 
												</div> 
											</s:iterator>
											</div> 
										</td>
										<td  valign="top">
											<div class = "projectContentFilters" > 
												<s:form id = "projectForm" action="/projects" method="post">	
														
															<s:select label="Project" 
										     					name="selectedProject"
										     					list="projectsList"/>
										     					
															<s:select label="Area"
									     						name="selectedArea"
									     						list="areaList"/>
									     					
									     					<s:select label="Assigned To"
										     					name="assigned"
										     					list="usersList"/>
									     					
									     					<s:select label="State"
										     					name="state"
										     					list="statesList"/>
										     					
									     					<s:select label="Priority"
										     					name="priority"
										     					list="prioritiesList"/>
						
													<s:submit class= "button"  method="execute" 
															key="Apply Changes" align="center" />
						
								 				</s:form>
											</div>  
										</td>
									</tr>
								</table>
							</div>
						      
						    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="MY_TABPAGE2" title="Test" width="100%"  >
					     
					     	<div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createTest">New Test</a>
							</div> 
							<div class="table">
								<table style="width:100%" >
									<tr>
										<td style="width:70%"  valign="top" >
								
											<div class = "projectContent"> 
											<s:iterator value="testObjList" var="el">
												<div class="container themed-container" >
						   							<a class="button" 
						   								href="${pageContext.request.contextPath}/editTest?itemID=${el.id}">
						   									[${el['class'].simpleName}] :
							   								<s:property value="#el.title" /> | 
												  			<s:property value="#el.state.name" /> |
												  			<s:property value="#el.priority.name" /> 
												  			<s:property value="#el.user.email" />  
						   							</a> 
												</div> 
											</s:iterator>
											</div> 
										</td>
										<td  valign="top">
											<div class = "projectContentFilters" > 
												<s:form id = "projectForm" action="/projects" method="post">	
														
															<s:select label="Project" 
										     					name="selectedProject"
										     					list="projectsList"/>
										     					
															<s:select label="Area"
									     						name="selectedArea"
									     						list="areaList"/>
									     					
									     					<s:select label="Assigned To"
										     					name="assigned"
										     					list="usersList"/>
									     					
									     					<s:select label="State"
										     					name="state"
										     					list="statesList"/>
										     					
									     					<s:select label="Priority"
										     					name="priority"
										     					list="prioritiesList"/>
						
													<s:submit class= "button"  method="execute" 
															key="Apply Changes" align="center" />
						
								 				</s:form>
											</div>  
										</td>
									</tr>
								</table>
							</div>
						      
					    </jsptabcontrol:tabPage>
					    
					    <jsptabcontrol:tabPage name="MY_TABPAGE3" title="Area" width="100%" >
					      <div class="center">
								<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
							</div> 
							<div class="table">
								<table style="width:100%" >
									<tr>
										<td style="width:70%"  valign="top" >
								
											<div class = "projectContent"> 
											<s:iterator value="areaObjList" var="el">
												<div class="container themed-container" >
						   							<a class="button" 
						   								href="${pageContext.request.contextPath}/editArea?itemID=${el.id}">
						   									[${el['class'].simpleName}] :
							   								<s:property value="#el.title" /> | 
												  			<s:property value="#el.state.name" /> |
												  			<s:property value="#el.priority.name" /> 
												  			<s:property value="#el.user.email" />  
						   							</a> 
												</div> 
											</s:iterator>
											</div> 
										</td>
										<td  valign="top">
											<div class = "projectContentFilters" > 
												<s:form id = "projectForm" action="/projects" method="post">	
														
															<s:select label="Project" 
										     					name="selectedProject"
										     					list="projectsList"/>
									     					
									     					<s:select label="Assigned To"
										     					name="assigned"
										     					list="usersList"/>
									     					
									     					<s:select label="State"
										     					name="state"
										     					list="statesList"/>
										     					
									     					<s:select label="Priority"
										     					name="priority"
										     					list="prioritiesList"/>
						
													<s:submit class= "button"  method="execute" 
															key="Apply Changes" align="center" />
						
								 				</s:form>
											</div>  
										</td>
									</tr>
								</table>
							</div>
						      
					    </jsptabcontrol:tabPage>  
				    
				  </jsptabcontrol:tabControl> 
			</div>
	</body>
</html>
			
			

