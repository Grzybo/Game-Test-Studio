<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<head>
    	<style><%@include file="/WEB-INF/index.css"%></style>
	</head>
 
	<a class="button" href="${pageContext.request.contextPath}/projects">Project</a> 
	|
	<a class="button" href="${pageContext.request.contextPath}/userInfo">Profile</a>
	|
	<a class="button" href="${pageContext.request.contextPath}/logout">Logout</a>
	| 
	<a class ="user" >Logged as: ${loginedUsername} </a>
	|
	<a class ="user" >Project: ${userProject} </a> 
	|
	<a class ="userBtn">User</a>
	
	<br><hr> 
