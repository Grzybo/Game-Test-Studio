<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projects</title>
		<style><%@include file="/WEB-INF/index.css"%></style>
	</head>
	<body>
		<jsp:include page="_userMenu.jsp" />
		
		<s:set var="isAssigned" value="assignedToMe"/>
		<s:if test="%{#isAssigned==false}">
			<h2>Project: ${userProject}</h2>	
		</s:if>
		<s:if test="%{#isAssigned==true}">
			<h2>Items Assigned To: ${loginedUsername} in ${userProject}</h2>	
		</s:if>
		
		<div class="center">
			<a class="button" href="${pageContext.request.contextPath}/createBug">New Bug</a>
			<a class="button" href="${pageContext.request.contextPath}/createTest">New Test</a>
			<a class="button" href="${pageContext.request.contextPath}/createArea">New Area</a>
		</div> 
		
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
		   								href="${pageContext.request.contextPath}/editArea">
		   									[${el['class'].simpleName}] :
			   								<s:property value="#el.title" /> | 
								  			<s:property value="#el.state.name" /> |
								  			<s:property value="#el.priority.name" /> 
								  			<s:property value="#el.user.email" />  
		   						</a> 
		   						</s:if>
		   						<s:elseif test="%{#item=='Test'}">
		   							<a class="button" 
		   								href="${pageContext.request.contextPath}/editTest">
		   									[${el['class'].simpleName}] : 
			   								<s:property value="#el.title" /> | 
								  			<s:property value="#el.state.name" /> |
								  			<s:property value="#el.priority.name" /> |
								  			<s:property value="#el.user.email" /> 
		   							</a> 
		   						</s:elseif>
		   						<s:elseif test="%{#item=='Bug'}">
		   							<a class="button" 
		   								href="${pageContext.request.contextPath}/editBug">
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
		<br>

		
		
	</body>
</html>
			
			
			
			
			
			
<!-- 	---------------------------------------------------------------------------------------------------------------------------------------		
			
			<table style="width:100%">
	    		<tr>
			    	<th>
			    		<a class="button" href="${pageContext.request.contextPath}/createBug">Create new Bug</a>
	    			</th>
	    			<th>
			    		<a class="button" href="${pageContext.request.contextPath}/createTest">Create new Test</a>
	    			</th>
	    			<th>
			    		<a class="button" href="${pageContext.request.contextPath}/createArea">Create new Area</a>
	    			</th>
				</tr>
				<tr>
					<th>
			    		<a class="button" href="${pageContext.request.contextPath}/editBug">Modify Bug</a>
	    			</th>
	    			<th>
			    		<a class="button" href="${pageContext.request.contextPath}/editTest">Modify Test</a>
	    			</th>
	    			<th>
			    		<a class="button" href="${pageContext.request.contextPath}/editArea">Modify Area</a>
	    			</th>
				</tr>
			</table>
		</div> 
-->

