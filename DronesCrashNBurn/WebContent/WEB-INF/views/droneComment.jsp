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

<body data-ng-app="myApp" class="data-ng-cloak" data-ng-cloak>

	<!-- this is the begin of the center div for all on the page-->
	<div align="center">

		<!-- ok below here is the drone table space -->
		<div class="generic-container"
			data-ng-controller="DroneController as droneCtrl">

			<div class="panel panel-default">

				<div class="panel-heading">
					<span class="lead text-center">Welcome to Drone Comment -
						Drone</span>
				</div>

				<div class="tablecontainer" 
					data-ng-init="droneCtrl.fetchDroneByDroneId(${id})">
					<table class="table">
						<thead>
							<tr>
								<th>Drone ID</th>
								<th>Drone Owner</th>
								<th>Drone Name</th>
								<th>Drone Type</th>
								<th>Wing/Rotor Span</th>
								<th>Drone Status</th>
								<th width="20%"></th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td><span data-ng-bind="droneCtrl.drone.droneId"></span></td>
								<td><span data-ng-bind="droneCtrl.drone.droneOwnerName"></span></td>
								<td><span data-ng-bind="droneCtrl.drone.droneName"></span></td>
								<td><span data-ng-bind="droneCtrl.drone.droneType"></span></td>
								<td><span data-ng-bind="droneCtrl.drone.droneSpan"></span></td>
								<td><span data-ng-bind="droneCtrl.drone.droneStatus"></span></td>

								<td><img height=100 width=auto
									data-ng-src="${contextPath}/{{droneCtrl.drone.droneImage}}"
									alt="OOPSIE! Whereis the thumbnail image?"></td>
							</tr>
						</tbody>

					</table>
				</div>

			</div>

		</div>
		<!-- ok ABOVE here is the drone table space -->

		<!-- ok below here is the comment table space -->
		<div class="generic-container"
			data-ng-controller="DroneCommentController as droneCommentCtrl" data-ng-init="droneCommentCtrl.holdDroneId=${id}; droneCommentCtrl.fetchAllDroneCommentByDroneId(${id})">

			<div class="panel panel-default">

				<div class="panel-heading">
					<span class="lead text-center">Welcome to Drone Comment -
						Comments</span>
				</div>

				<div class="tablecontainer"
					>
					<table class="table">
						<thead>
							<tr>
								<th width="10%">Comment ID</th>
								<th width="10%">Drone ID</th>
								<th width="60%">Comment</th>
								<th width="10%"></th>
							</tr>
						</thead>

						<tbody>
							<tr data-ng-repeat="comment in droneCommentCtrl.comments">
								<td><span data-ng-bind="comment.commentId"></span></td>
								<td><span data-ng-bind="comment.commentDroneId"></span></td>
								<td><span data-ng-bind="comment.commentText"></span></td>
								<td>
									<button type="button" data-ng-click="droneCommentCtrl.isNewCommentVisible=true"
										class="btn btn-warning"><b>Edit</b></button>

									<button type="button" data-ng-click="droneCommentCtrl.deleteDroneCommentByCommentId(comment.commentId)"
										class="btn btn-danger custom-width"><b>Discard</b></button>
								</td>
							</tr>
						</tbody>

					</table>
					<h4>
						<button type="button" data-ng-click="droneCommentCtrl.isNewCommentVisible=true; self.commentId=null"
										class="btn btn-success"><b>Create a new Comment for this Drone</b></button>
					</h4>

					<div data-ng-if="droneCommentCtrl.isNewCommentVisible" >
						<td><textarea name="newCommentText" cols="60" rows="5" required="required" placeholder="Enter new Drone Comment here"></textarea></td>
					
						<td><button type="button" data-ng-click="droneCommentCtrl.addDroneComment(); droneCommentCtrl.isNewCommentVisible=false" class="btn btn-primary"><b>Add the New Comment</b></button></td>
	
						<td><button type="button" data-ng-click="droneCommentCtrl.isNewCommentVisible=false" class="btn btn-danger custom-width"><b>Cancel</b></button></td>
					</div>
					
				</div>
				
			</div>

		</div>
		<!-- ok ABOVE here is the comment table space -->

		<!-- ok below here is the href back to drone central -->
		<h2>
			<strong><a href="${contextPath}/droneCentral">Back to
					Drone Central!</a></strong>
		</h2>
		<!-- ok ABOVE here is the href back to drone central -->

	</div>
	<!-- this is the _end_ of the center div for all on the page-->

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/resources/js/app.js' />"></script>
	<script src="<c:url value='/resources/js/service/drone_service.js' />"></script>
	<script
		src="<c:url value='/resources/js/controller/drone_controller.js' />"></script>
	<script
		src="<c:url value='/resources/js/service/drone_comment_service.js' />"></script>
	<script
		src="<c:url value='/resources/js/controller/drone_comment_controller.js' />"></script>

</body>
</html>