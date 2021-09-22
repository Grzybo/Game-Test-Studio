<html>
	<head>
		<title>Game Test Studio - Admin Page</title>
		<script>

		</script>
	</head>
	<body>
    	
    	<jsp:include page="_adminMenu.jsp" />

    	<h2>Admin Page</h2>
	 <div class = "adminContent">				
		<a class="button" href="${pageContext.request.contextPath}/createAccount">Create new Account</a>
		<a class="button" href="${pageContext.request.contextPath}/editAccount">Manage existing Account</a>
		<br><br>
		<a class="button" href="${pageContext.request.contextPath}/createProject">Create new Project</a>
		<a class="button" href="${pageContext.request.contextPath}/editProject">Manage existing Project</a>
	</div>
	</body>
</html>