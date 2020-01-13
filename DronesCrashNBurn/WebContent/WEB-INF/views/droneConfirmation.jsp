<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>

	<c:when test="${drone.droneType eq 'Glider'}">
		<c:set var="droneTypeSilhouette" value="resources/images/glider_silhouette.jpg" />
	</c:when>
	<c:when test="${drone.droneType eq 'Sport'}">
		<c:set var="droneTypeSilhouette" value="resources/images/sport_silhouette.jpg" />
	</c:when>
	<c:when test="${drone.droneType eq 'Rotorcraft'}">
		<c:set var="droneTypeSilhouette" value="resources/images/rotorcraft_silhouette.jpg" />
	</c:when>
	<c:otherwise>
		<c:set var="droneTypeSilhouette" value="resources/images/crashnburn_background2.jpg" />
	</c:otherwise>

</c:choose>

<html>
<head>
<title>Drone Confirmation</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="icon" href="data:,">

<style type="text/css">
body {
	background-image:
		url("${contextPath}/resources/images/drone_confirm_background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	background-color: DeepSkyBlue;
	background-opacity: 0.5 !important;
}
</style>
</head>

<body>
	<div align="center">

		<h2>Airborne!</h2>

		<table>
			<tr>
				<td>Drone Owner Name:</td>
				<td>${drone.droneOwnerName}</td>
			</tr>
			<tr>
				<td>Drone Name:</td>
				<td>${drone.droneName}</td>
			</tr>
			<tr>
				<td>Drone Type:</td>
				<td>${drone.droneType}</td>
				<td><img src="${contextPath}/${droneTypeSilhouette}" alt="OOPSIE! Whereis the image?" width="100" height="40"></td>
			</tr>
			<tr>
				<td>Drone Span (Wing/Rotor):</td>
				<td>${drone.droneSpan}</td>
			</tr>
			<tr>
				<td>Drone First Flight:</td>
				<td><fmt:formatDate value="${drone.droneFirstFlownDate}" pattern="yyyy/MM/dd"  /></td>
			</tr>
			<tr>
				<td>Drone Status:</td>
				<td>${drone.droneStatus}</td>
			</tr>
			<tr>
				<td>Drone Image:</td>
				<td>${drone.droneImage}</td>
			</tr>
			<tr>
			</tr>

		</table>

		<br> <a href="${contextPath}/droneCentral">Land at Drone Central</a> <br> <br> <img height=auto
			width=500 src="${contextPath}/${drone.droneImage}" class="img-thumbnail img-responsive" alt="No Image Provided"
		>

	</div>
</body>
</html>