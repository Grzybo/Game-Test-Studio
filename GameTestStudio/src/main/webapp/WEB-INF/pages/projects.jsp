<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projects</title>
	</head>
	<body>
		<jsp:include page="_userMenu.jsp" />
		
		<s:set var="isAssigned" value="assignedToMe"/>
		<s:if test="%{#isAssigned==false}">
			<h2>Project: ${userProject}</h2>	
		</s:if>
		<s:if test="%{#isAssigned==true}">
			<h2>Items Assigned To: ${loginedUsername}</h2>	
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
						
						<s:set var="item" value="selectedItem"/>

						<s:if test="%{#item=='Area'}">
							<s:iterator value="elementsList">
							<div class="container themed-container" >
		   						<a class="button" 
		   							href="${pageContext.request.contextPath}/editArea">
		   							<s:property /> <!--  DODAC połaczenie do konkretnego elementu -->
		   						</a> 
							</div> 
						</s:iterator>
						</s:if>
						
						
						<s:elseif test="%{#item=='Test'}">
						    <s:iterator value="elementsList">
							<div class="container themed-container">
		   						<a class="button" 
		   							href="${pageContext.request.contextPath}/editTest">
		   							<s:property /> <!--  DODAC połaczenie do konkretnego elementu -->
		   						</a> 
							</div> 
						</s:iterator>
						</s:elseif>
						<s:elseif test="%{#item=='Bug'}">
						    <s:iterator value="elementsList">
							<div class="container themed-container">
		   						<a class="button" 
		   							href="${pageContext.request.contextPath}/editBug">
		   							<s:property /> <!--  DODAC połaczenie do konkretnego elementu -->
		   						</a> 
							</div> 
						</s:iterator>
						</s:elseif>
						

						
						
						
					</div> 
				</td> 
				<td  valign="top">
					<div class = "projectContentFilters" > 
						<s:form id = "projectForm" action="/projects" method="post">	
							<s:checkbox label="All items assigned to Me" name="assignedToMe" />
							<s:select label="Project"
		     					name="selectedProject"
		     					list="projectsList"/>
	     					<br>
	     					<s:select label="Item"
		     					name="selectedItem"
		     					list="itemsList"/>
		     					
	     					<s:select label="State"
		     					name="state"
		     					list="statesList"/>

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

