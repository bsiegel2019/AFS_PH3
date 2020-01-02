(function() {
// IIFE
'use strict';

angular.module('myApp')
		.controller('DroneCommentController',
				['$scope','DroneCommentService',

						function($scope, DroneCommentService) {
							var self = this;
								
							// this comment is used for the comment function
							self.comment = {
									commentId : null,
									commentDroneId : null,
									commentText : 'None provided'
								};

							// this is a list of drones for display
							self.comments = [];
	 						
							self.fetchAllDroneCommentByDroneId = fetchAllDroneCommentByDroneId;
							self.deleteDroneCommentByCommentId = deleteDroneCommentByCommentId;
//							self.fetchDroneCommentByCommentId = fetchDroneCommentByCommentId;
//							self.reset = reset;
							
							// this is for the comment page - get all comments for a drone id
							function fetchAllDroneCommentByDroneId(id) {
								DroneCommentService.fetchAllDroneCommentByDroneId(id)
										.then(function(d) {
													self.comments = d;
												})
										.catch(function(errResponse) {
												console.error('Error while fetching Comments by Drone Id');
												});
							}
	
							function deleteDroneCommentByCommentId(id) {
								// grab the droneId for the comment we are deleting
								// since we are on a row the index in the array is 0, lenght 1
								// needed to fetch any remaining comments (0, 1, many) for this drone
								var holdDroneId = holdDroneId = self.comments[0].commentDroneId; 
								
								// we always expect a null DroneComment object returned from the delete
								// then we fetch any (0, 1, many) comments remaoning for this drone
								DroneCommentService.deleteDroneCommentByCommentId(id)
									.then(function(d) {
											self.comment = d;
											self.fetchAllDroneCommentByDroneId(holdDroneId);
										})
								.catch(function(errResponse) {
										console.error('Error while deleting DroneComment');
										});
						}

							
//							// this is for the comment page - get a comment by a comment id
//							function fetchDroneCommentByCommentId(id) {
//								DroneCommentService.fetchDroneCommentByCommentId(id)
//										.then(function(d) {
//													self.comment = d;
//												})
//										.catch(function(errResponse) {
//												console.error('Error while fetching Comment by Comment Id');
//												});
//							}

//						function reset() {
//							console.log("    INSIDE RESET");
//							self.comment = {
//									commentId : null,
//									commentDroneId : null,
//									commentText : 'None provided'
//								};
//							$scope.myForm.$setPristine(); // reset Form
//							}

						} ]);

})();
