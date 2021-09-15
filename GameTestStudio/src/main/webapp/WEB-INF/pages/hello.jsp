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
    	
    	<jsp:include page="_login.jsp" />
    	
	    
	</body>
</html>