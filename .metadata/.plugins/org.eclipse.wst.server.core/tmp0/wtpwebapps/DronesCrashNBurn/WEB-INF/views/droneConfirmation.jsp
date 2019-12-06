<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
<%-- 	<c:when test="${ ${drone.droneType} eq 'Glider'}"> --%>
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
<head>
<title>Drone Confirmation</title>
</head>
<body>
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
			<td><a href="droneManagement">Back to Drone Central!</a></td>
		</tr>
	</table>
</body>
</html>