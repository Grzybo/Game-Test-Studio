<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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
    </style>
 

	<a class="button" href="${pageContext.request.contextPath}/project">Project</a> 
	|
	<a class="button" href="${pageContext.request.contextPath}/contact">Contact</a> 
	|
	<a class="button" href="${pageContext.request.contextPath}/userInfo">User Page</a>
	|
	<a class="button" href="${pageContext.request.contextPath}/admin_page">Admin Page</a>
	|
	<a class="button" href="${pageContext.request.contextPath}/logout">Logout</a>
	| 
	<a class ="user" >Logged as: ${loginedUsername} </a>
	|
	<a class ="user" >Project: ${userProject} </a>
	
	<br><hr> 
