<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<td><a href="droneCentral">Back to the Drones!</a></td>
		</tr>
	</table>
</body>
</html>