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
			<s:set var="isAssigned" value="assignedToMe"/>
		<s:if test="%{#isAssigned==false}">
			<h2>Project: ${userProject}</h2>	
		</s:if>
		<s:if test="%{#isAssigned==true}">
			<h2>Items Assigned To: ${loginedUsername} in ${userProject}</h2>	
		</s:if>
		
		<div class="table">
		<table style="width:100%" >
			<tr>
				<td style="width:70%"  valign="top" >
					
					<div class = "projectContent"> 
						<s:iterator value="elementsObjList" var="el">
							<div class="container themed-container" >
		   						<s:set var="item" value="selectedItem"/> 
		   						<s:if test="%{#item=='Area'}">
		   							<a class="button" 
		   								href="${pageContext.request.contextPath}/editArea?itemID=${el.id}">
		   									[${el['class'].simpleName}] :
			   								<s:property value="#el.title" /> | 
								  			<s:property value="#el.state.name" /> |
								  			<s:property value="#el.priority.name" /> 
								  			<s:property value="#el.user.email" />  
		   						</a> 
		   						</s:if>
		   						<s:elseif test="%{#item=='Test'}">
		   							<a class="button" 
		   								href="${pageContext.request.contextPath}/editTest?itemID=${el.id}">
		   									[${el['class'].simpleName}] : 
			   								<s:property value="#el.title" /> | 
								  			<s:property value="#el.state.name" /> |
								  			<s:property value="#el.priority.name" /> |
								  			<s:property value="#el.user.email" /> 
		   							</a> 
		   						</s:elseif>
		   						<s:elseif test="%{#item=='Bug'}">
		   							<a class="button" 
		   								href="${pageContext.request.contextPath}/editBug?itemID=${el.id}">
		   									[${el['class'].simpleName}] :
			   								<s:property value="#el.title" /> | 
								  			<s:property value="#el.state.name" /> |
								  			<s:property value="#el.priority.name" /> | 
								  			<s:property value="#el.user.email" /> 
		   							</a> 
		   						</s:elseif>
							</div> 
						</s:iterator>
						</div>
						<br>
					
				</td> 
				<td  valign="top">
					<div class = "projectContentFilters" > 
						<s:form id = "projectForm" action="/projects" method="post">	
							
								<s:set var="toMe" value="assignedToMe"/> 
								<s:if test="%{#toMe== true }">
									<s:select label="Project" 
				     					name="selectedProject"
				     					list="projectsList"/>
	
			     					<s:select label="Item" disabled="true"
				     					name="selectedItem"
				     					list="itemsList"/>
				     					
			     					<s:if test="%{#item!='Area'}"> 
										<s:select label="Area" disabled="true"
				     						name="selectedArea"
				     						list="areaList"/>
									</s:if>
			     					
			     					<s:select label="Assigned To" disabled="true"
				     					name="assigned"
				     					list="usersList"/>
			     					
			     					<s:select label="State" disabled="true"
				     					name="state"
				     					list="statesList"/>
				     					
			     					<s:select label="Priority" disabled="true"
				     					name="priority"
				     					list="prioritiesList"/>
								</s:if>
								<s:else>
									<s:select label="Project" 
				     					name="selectedProject"
				     					list="projectsList"/>
	
			     					<s:select label="Item"
				     					name="selectedItem"
				     					list="itemsList"/>
				     					
			     					<s:if test="%{#item!='Area'}">
										<s:select label="Area"
				     						name="selectedArea"
				     						list="areaList"/>
									</s:if>
			     					
			     					<s:select label="Assigned To"
				     					name="assigned"
				     					list="usersList"/>
			     					
			     					<s:select label="State"
				     					name="state"
				     					list="statesList"/>
				     					
			     					<s:select label="Priority"
				     					name="priority"
				     					list="prioritiesList"/>
								</s:else>

		     				<s:checkbox label="All items assigned to Me" name="assignedToMe" />	

							<s:submit class= "button"  method="execute" 
									key="Apply Changes" align="center" />

		 				</s:form>
					</div>  
				</td>
			</tr>
			</table> 
			</div> 
	</body>
</html>
			
			

