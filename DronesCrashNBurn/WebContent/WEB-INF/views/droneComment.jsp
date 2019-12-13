<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Drone Comment</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/app.css" />" />

<style type="text/css">
body {
	background-image:
		url("${contextPath}/resources/images/drone_comment_background.jpg");
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

		<h2>Welcome to Drone Comment</h2>
		<div>

			<h1>

				<table>
					<tr>
						<td>Long:</td>
						<td>${id}</td>
					</tr>
				</table>
			</h1>


			<div class="tablecontainer">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Drone ID</th>
							<th>Drone Owner</th>
							<th>Drone Name</th>
							<th>Drone Type</th>
							<th>Wing/Rotor Span</th>
							<th>Drone Status</th>
							<th>Drone Image</th>
							<th width="20%"></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><span ng-bind="drone.droneId"></span></td>
							<td><span ng-bind="drone.droneOwnerName"></span></td>
							<td><span ng-bind="drone.droneName"></span></td>
							<td><span ng-bind="drone.droneType"></span></td>
							<td><span ng-bind="drone.droneSpan"></span></td>
							<td><span ng-bind="drone.droneStatus"></span></td>
							<td><span ng-bind="drone.droneImage"></span></td>
						</tr>
					</tbody>

				</table>

			</div>

			<h2>
				<strong><a href="${contextPath}/droneCentral">Back to
						Drone Central!</a></strong>
			</h2>

		</div>
	</div>
</body>
</html>