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
  <s:select label="Choose Project"
       		name="project"
       		headerKey="1" 
       		list="projectsList"/>
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