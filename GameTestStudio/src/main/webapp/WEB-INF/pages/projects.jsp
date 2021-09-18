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
		
			<h2>Project: ${userProject}</h2> 
			
			<div class = "chooseProjectContent" > 
			
		 		<s:form id = "projectForm" action="/projects" method="post">	
					<s:select label="Projects"
	       				name="selectedProject"
	       				list="projectsList"/>
					<s:submit class= "button"  method="execute" key="Select Project" align="center" /> 
			 	</s:form>
			</div>
			<br>
			<div class = "projectContent"> 
				<s:iterator value="areasList">
 						<div class="container themed-container">
			   			<a class="button" href="${pageContext.request.contextPath}/editArea"><s:property/></a> 
					</div> 
				</s:iterator> 
			</div>
			
			
			
			
			
			
<!-- 			
			
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

	</body>
</html>