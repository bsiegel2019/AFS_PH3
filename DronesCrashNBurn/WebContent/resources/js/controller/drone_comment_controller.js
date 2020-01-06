(function() {
// IIFE
'use strict';

angular.module('myApp')
		.controller('DroneCommentController',
				['$scope','DroneCommentService',

						function($scope, DroneCommentService) {
							var self = this;
							
							self.holdDroneId = -1; //droneId is valid if 1 and higher - init sets this for the life of this page
							
							self.isNewCommentVisible = false; // controls the visisbility of the add/edit area
								
							// this comment is used for the comment function - add/edit
							self.comment = {
									commentId : null,
									commentDroneId : null,
									commentText : 'ERROR - None provided '
								};

							// this is a list of drone comments for display
							self.comments = [];
	 						
							self.fetchAllDroneCommentByDroneId = fetchAllDroneCommentByDroneId;
							self.deleteDroneCommentByCommentId = deleteDroneCommentByCommentId;
							self.addDroneComment = addDroneComment;
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
								// we always expect a null DroneComment object returned from the delete
								// then we fetch any (0, 1, many) comments remaoning for this drone
								DroneCommentService.deleteDroneCommentByCommentId(id)
									.then(function(d) {
											self.comment = d;
											self.fetchAllDroneCommentByDroneId(self.holdDroneId);
										})
								.catch(function(errResponse) {
										console.error('Error while deleting DroneComment');
										});
						}
							
						    // the commentId field was null on input and should have been set by hibernate on a successful add
						    function addDroneComment() {
						    	
								// init the comment key fields for an add
						    	self.comment.commentId = null;
								self.comment.commentDroneId = self.holdDroneId;
						    	
						    	// we always expect a non-null DroneComment object returned from the add
								// then we fetch all comments (0, 1, many) for this drone after the add to refresh the view
								DroneCommentService.addDroneComment(self.comment)
 									.then(function(d) {
											self.comment = d;
									    	console.log(" DEEP INSide addDroneComment");
									    	console.log(d);

											self.fetchAllDroneCommentByDroneId(self.holdDroneId);
										})
								.catch(function(errResponse) {
										console.error('Error while adding DroneComment');
										});
						    	console.log(" INSide addDroneComment");
						    	console.log(self.comment);
						    }
							
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
