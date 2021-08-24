<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style>
 		.button {
	        display: inline-block;
	        padding: 10px 20px;
	        text-align: center;
	        text-decoration: none;
	        color: #ffffff;
	        background-color: #33ccff;
	        border-radius: 6px;
	        outline: none;}
	        
        .center {
        	text-align: center;} 
		.user {
			color: #33ccff;}
        body {
        	font-family: Verdana, sans-serif;
  			text-align: center;}
		.content {
			width:35%;
			height: auto;
			margin: auto;
			background: white;
			padding: 10px;
			border-style: groove;
			border-color: #33ccff;}
		.left{
			text-align: left;}
		textarea { resize: vertical; }
    </style>

<html>
	
	
	<head>
		<title>Game Test Studio Welcome Page </title>
	</head>
	<body>
    	
    	<h2>Welcome in Game Test Studio! </h2>
	    <div class = "content">
    	<h4>Please login:</h4>
    	
    	<s:actionerror />
 
	    <s:form class = "form" action="/login" method="post"> 
	        <s:textfield name="username" key="label.username" size="20" />
	        <s:password name="password" key="label.password" size="20" />
	        <s:submit class= "button"  method="execute" key="label.login" align="center" />
	    </s:form>  
	       <br>
    Admin: admin, admin123
    <br>
 	Normal user: user, user123   
	</div>
	</body>
</html>