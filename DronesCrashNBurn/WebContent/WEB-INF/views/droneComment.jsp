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
<link rel="icon" href="data:,">

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

<body ng-app="myApp" class="ng-cloak" ng-cloak>

	<div align="center">

		<div class="generic-container"
			ng-controller="DroneController as droneCtrl">

			<div class="panel panel-default">

				<div class="panel-heading">
					<span class="lead text-center">Welcome to Drone Comment</span>
				</div>

				<div class="tablecontainer"
					ng-init="droneCtrl.fetchDroneByDroneId(${id})">
					<table class="table">
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
								<td><span ng-bind="droneCtrl.drone.droneId"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneOwnerName"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneName"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneType"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneSpan"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneStatus"></span></td>
								<td><span ng-bind="droneCtrl.drone.droneImage"></span></td>
								<td>					<img height=auto width=500 src="${contextPath}/{{droneCtrl.drone.droneImage}}"
						class="img-thumbnail img-responsive"
						alt="OOPSIE! Whereis the thumbnail image?">
								</td>
							</tr>

						</tbody>

					</table>
				</div>

				<div align="center">
					<h2>
						<strong><a href="${contextPath}/droneCentral">Back to
								Drone Central!</a></strong>
					</h2>
				</div>

			</div>

		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/resources/js/app.js' />"></script>
	<script src="<c:url value='/resources/js/service/drone_service.js' />"></script>
	<script
		src="<c:url value='/resources/js/controller/drone_controller.js' />"></script>

</body>
</html>