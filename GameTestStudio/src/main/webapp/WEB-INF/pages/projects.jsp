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
			<div class="container themed-container">
				   asdasd
				    <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"></rect><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

				
			</div>
			
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
		<div class="content">
			
		</div>
		<br>
	</body>
</html>