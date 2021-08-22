<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projects</title>
	</head>
	<body>
			<jsp:include page="_menu.jsp" />
		<div class = "content">
			<h2>Project: ${userProject}</h2> 
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
			</table>
		</div>
		<br>
		<div class="content">
			<s:form id="search" >
				<label>Search:</label> 
				<input type="text" size=95%>
				<s:submit class= "button"  method="execute" key="Search" form = "search"/>
			</s:form>
		</div>
	</body>
</html>