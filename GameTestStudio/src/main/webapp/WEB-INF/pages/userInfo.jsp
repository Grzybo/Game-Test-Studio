<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Game Test Studio - User Info</title>
</head>
 
<body >
   <jsp:include page="_menu.jsp" />
    <div class = "content">
    
   <h2>Hello, ${loginedUsername}!</h2> 
   
   <label>Choose Project: </label> <!-- mozna przeniesc select blizej lewej aby bylo rowno z form -->
	<select id="form" name="projectList" >
	  <option value="fifa22">FIFA 22</option>
	  <option value="fifa21">FIFA 21</option>
	</select>
	
   </div>
</body>
</html>