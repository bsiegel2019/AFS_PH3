<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/app.css" />" />
<title>Drone Info</title>
<style type="text/css">
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.5),
		rgba(255, 255, 255, 0.5)),
		url("resources/images/droneadd_background.jpg");
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
	<h3>Soaring with this Drone!</h3>
	<h4>Enter Drone details here</h4>

	<form:form method="POST" action="droneConfirmation"
		modelAttribute="drone">

		<form:input type="hidden" path="droneId" />

		<table>
			<tr>
				<td><label>Drone Owner Name *</label></td>
				<td><form:input path="droneOwnerName" required="required"
						type="text" placeholder="Enter Drone Owner Name" /></td>
			</tr>

			<tr>
				<td><form:label path="droneName">Drone Name *</form:label></td>
				<td><form:input path="droneName" required="required"
						type="text" placeholder="Enter Drone Name" /></td>
			</tr>

			<tr>
				<td><form:label path="droneType">Drone Type *</form:label></td>
				<td><form:select path="droneType" class="form-control"
						required="required" placeholder="Select Drone Type">
						<option placeholder="Select Drone Type"></option>
						<!-- Note: this empty option, with required, forces a selection -->
						<option>Glider</option>
						<option>Sport</option>
						<option>Rotorcraft</option>
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="droneSpan">Drone Span (Wing or Rotor)</form:label></td>
				<td><form:input path="droneSpan" type="text"
						placeholder="Enter Drone Wing Span or Rotor DiameterxRotors" /></td>
			</tr>

			<tr>
				<td><form:label path="droneStatus">Drone Status</form:label></td>
				<td><form:input path="droneStatus" type="text"
						placeholder="Enter Drone Status (flyable, on bench, RIP, whatever)" /></td>
			</tr>

			<tr>
				<td><form:label path="droneImage">Drone Image</form:label></td>
				<td><form:input path="droneImage" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit this awesone Drone!" /></td>

			</tr>
			<tr>
				<td><br><a href="droneManagement">Abort! Back to Drone Central!</a></td>
			</tr>
		</table>

	</form:form>

</body>
</html>