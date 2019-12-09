<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${drone.droneType eq 'Glider'}">
		<c:set var="droneTypePic"
			value="resources/images/glider_silhouette.jpg" />
	</c:when>
	<c:when test="${drone.droneType eq 'Sport'}">
		<c:set var="droneTypePic"
			value="resources/images/sport_silhouette.jpg" />
	</c:when>
	<c:when test="${drone.droneType eq 'Rotorcraft'}">
		<c:set var="droneTypePic"
			value="resources/images/rotorcraft_silhouette.jpg" />
	</c:when>
</c:choose>

<html>
<link rel="stylesheet" href="<c:url value="/resources/css/app.css" />" />
<head>
<title>Drone Confirmation</title>
<style type="text/css">
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.5),
		rgba(255, 255, 255, 0.5)),
		url("resources/images/droneconfirm_background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	background-color: DeepSkyBlue;
}

html {
	display: table;
	margin: auto;
}

body {
	display: table-cell;
	vertical-align: middle;
}
</style>
</head>
<body>
	<br>
	<h3>Enjoy the Drone!</h3>

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
			<td><img src="${droneTypePic}" alt="OOPSIE! Whereis the image?"
				width="100" height="40"></td>
		</tr>
		<tr>
			<td>Drone Span (Wing or Rotor):</td>
			<td>${drone.droneSpan}</td>
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
			<td><br><a href="droneManagement">Safe landing at Drone Central!</a></td>
		</tr>
	</table>
</body>
</html>