<html>
	<head>
		<title>Game Test Studio - Admin Page</title>
		<script>

		</script>
	</head>
	<body>
    	
    	<jsp:include page="_adminMenu.jsp" />

    	<h2>Admin Page</h2>
	 
	 <div class="content">
			<table style="width:100%" >
				<tr>
					<th>Accounts</th>
					<th>Projects</th>
					<th>Platforms</th>
				</tr>
				<tr>
					<th>
						<a
						 	class="button" 
							href="${pageContext.request.contextPath}/createAccount">
							Create
						</a>
					</th>
					<th>
						<a
						 	class="button" 
							href="${pageContext.request.contextPath}/createProject">
							Create
						</a>
					</th>
					<th>

					</th>
				</tr>
				<tr>
					<th>
						<a
						 	class="button" 
							href="${pageContext.request.contextPath}/editAccount">
							Edit
						</a>
					</th>
					<th>
						<a
						 	class="button" 
							href="${pageContext.request.contextPath}/editProject">
							Edit
						</a>
					</th>
					<th>
						<a
						 	class="button" 
							href="${pageContext.request.contextPath}/editPlatforms"> <!-- apleceholdrer -->
							Edit
						</a>
					</th>
				</tr>
			</table>
		 </div>
	 
	</body>
</html>