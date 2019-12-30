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
	 						
							self.reset = reset;
							self.fetchAllDroneCommentByDroneId = fetchAllDroneCommentByDroneId;

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
	
							// this is for the comment page - get a comment by a comment id
							function fetchDroneCommentByCommentId(id) {
								DroneCommentService.fetchDroneCommentByCommentId(id)
										.then(function(d) {
													self.comment = d;
												})
										.catch(function(errResponse) {
												console.error('Error while fetching Comment by Comment Id');
												});
							}

						function reset() {
							self.comment = {
									commentId : null,
									commentDroneId : null,
									commentText : 'None provided'
								};
								$scope.myForm.$setPristine(); // reset Form
							}

						} ]);

})();
