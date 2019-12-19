<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Drone Central</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/app.css" />" />
<link rel="icon" href="data:,">

<style type="text/css">
body {
	background-image:
		url("${contextPath}/resources/images/drone_central_background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	background-color: DeepSkyBlue;
}
</style>

</head>
<body data-ng-app="myApp" class="data-ng-cloak" data-ng-cloak>

	<div align="center">

		<div class="generic-container"
			data-ng-controller="DroneController as droneCtrl">

			<div class="panel panel-default">

				<div class="panel-heading">
					<span class="lead text-center">Drone Central</span>
				</div>

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
							<tr data-ng-repeat="drone in droneCtrl.drones">
								<td><span data-ng-bind="drone.droneId"></span></td>
								<td><span data-ng-bind="drone.droneOwnerName"></span></td>
								<td><span data-ng-bind="drone.droneName"></span></td>
								<td><span data-ng-bind="drone.droneType"></span></td>
								<td><span data-ng-bind="drone.droneSpan"></span></td>
								<td><span data-ng-bind="drone.droneStatus"></span></td>
								<td><span data-ng-bind="drone.droneImage"></span></td>
								<td>
									<button type="button"
										data-ng-click="droneCtrl.remove(drone.droneId)"
										class="btn btn-danger custom-width">Scrap</button>
										
									<button type="button" class="btn btn-info">
										<a
											data-ng-href="${contextPath}/droneComment/{{drone.droneId}}"><b>Comments</b></a>
									</button>
								</td>
							</tr>
						</tbody>

					</table>

				</div>

				<div align="center">
					<h4>
						<button type="button" class="btn btn-success">
							<a data-ng-href="${contextPath}/droneAdd"><b>Add a New Drone!</b></a>
						</button>
					</h4>
				</div>

			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
			<script src="<c:url value='/resources/js/app.js' />"></script>
			<script
				src="<c:url value='/resources/js/service/drone_service.js' />"></script>
			<script
				src="<c:url value='/resources/js/controller/drone_controller.js' />"></script>
		</div>

	</div>
</body>
</html>