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
   
   <s:form id = "projectForm" action="/userInfo" method="post">
   <label>Choose Project: </label> <!-- trzeba przeniesc select blizej lewej aby bylo rowno z form -->
	<select id="projectForm" name="project" form = "projectForm">
	  <option value="fifa22" selected>FIFA 22 </option>
	  <option value="fifa21">FIFA 21</option>
	</select>
	<s:submit class= "button"  method="execute" key="Select Project" align="center" /> 
	 </s:form>
	<br>
	
	<s:form action="/userInfo" method="post">
	
        <s:label>Change Password:</s:label>
        <s:password name="oldPassword" key="Actual Password" size="20" />
        <s:password name="newPassword1" key="New Password" size="20" />
        <s:password name="newPassword2" key="New Password" size="20" />
        <s:submit class= "button"  method="changePassword" key="Update Password" align="center" />
    </s:form>
    
    <s:actionerror />
	
   </div>
</body>
</html>