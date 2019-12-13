<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Drone Central</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/app.css" />" />

<style type="text/css">
body {
	background-image: url("${contextPath}/resources/images/dronemgmt_background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	background-color: DeepSkyBlue;
}
</style>

</head>
<body ng-app="myApp" class="ng-cloak" ng-cloak>
	<div align="center">

		<div class="generic-container" ng-controller="DroneController as ctrl">

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
							<tr ng-repeat="drone in ctrl.drones">
								<td><span ng-bind="drone.droneId"></span></td>
								<td><span ng-bind="drone.droneOwnerName"></span></td>
								<td><span ng-bind="drone.droneName"></span></td>
								<td><span ng-bind="drone.droneType"></span></td>
								<td><span ng-bind="drone.droneSpan"></span></td>
								<td><span ng-bind="drone.droneStatus"></span></td>
								<td><span ng-bind="drone.droneImage"></span></td>
								<td>
									<button type="button" ng-click="ctrl.remove(drone.droneId)"
										class="btn btn-danger custom-width">Scrap</button>
									<button type="button" class="btn btn-info">
										<strong><a ng-href="${contextPath}/droneComment/{{drone.droneId}}">Comments</a></strong>
									</button>
								</td>
							</tr>
						</tbody>

					</table>

				</div>

				<div align="center">
					<h4>
						<button type="button" class="btn btn-info">
							<strong><a ng-href="${contextPath}/droneAdd">Add a New Drone!</a></strong>
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