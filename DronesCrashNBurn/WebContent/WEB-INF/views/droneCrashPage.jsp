<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>DronesCrashNBurn Crashing</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<style type="text/css">
body {
	background-image: url("${contextPath}/resources/images/crashnburn_background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	background-color: DeepSkyBlue;
}
</style>
</head>

<body>
	<br>
	<div style="text-align: center">
		<h2>
			Welcome to Drones Crash and Burn Home!<br> <br>
		</h2>
		<h3>
			If you aren't FLYING, you aren't CRASHING<br> <br>
		</h3>
		<h4>
			<a href="${contextPath}/droneCentral">Click here for Drone Central!</a>
		</h4>
	</div>

</body>
</html>