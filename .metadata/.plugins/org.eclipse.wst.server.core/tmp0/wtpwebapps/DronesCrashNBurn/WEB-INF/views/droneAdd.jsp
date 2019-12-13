<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Drone Info</title>
<style type="text/css">
body {
	background-image: url("resources/images/droneadd_background.jpg");
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
		<h3>Welcome, Enter The Drone Details</h3>

		<form:form method="POST" action="droneConfirmation" modelAttribute="drone">

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
							<!-- Note: this empty option with required forces a selection -->
							<option>Glider</option>
							<option>Sport</option>
							<option>Rotorcraft</option>
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="droneSpan">Drone Span (Wing/Rotor)</form:label></td>
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
					<td></td>
					<td><input type="submit" value="Launch" /></td>
				</tr>
			</table>

			<br>
			<a href="droneCentral">Abort back to Drone Central</a>

		</form:form>

	</div>
</body>
</html>
