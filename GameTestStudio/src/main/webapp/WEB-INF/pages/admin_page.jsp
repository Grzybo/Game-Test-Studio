<html>
	<head>
		<title>Game Test Studio - Admin Page</title>
	</head>
	<body>
    	<jsp:include page="_menu.jsp" />
    	<h2>Admin Page</h2>
				
		<a class="button" href="${pageContext.request.contextPath}/createAccount">Create new Account</a>
		<a class="button" href="${pageContext.request.contextPath}/editAccount">Manage existing Account</a>
		<br><br>
		<a class="button" href="${pageContext.request.contextPath}/createProject">Create new Project</a>
		<a class="button" href="${pageContext.request.contextPath}/editProject">Manage existing Project</a>

	</body>
</html>