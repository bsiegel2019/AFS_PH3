(function() {
// IIFE
'use strict';

angular.module('myApp')
		.controller('DroneCommentController',
				['$scope','DroneCommentService',

						function($scope, DroneCommentService) {
							var self = this;
							
							self.holdDroneId = null; //droneId is valid if 1 and higher - init sets this for the life of this page
							
							self.isNewCommentVisible = false; // controls the visisbility of the add/edit area
								
							// this comment is used for the comment function - add/edit
							self.comment = {
									commentId : null,
									commentDroneId : null,
									commentDate : null,
									commentText : null
								};

							// this is a list of drone comments for display
							self.comments = [];
	 						
							self.fetchAllDroneCommentByDroneId = fetchAllDroneCommentByDroneId;
							self.deleteDroneCommentByCommentId = deleteDroneCommentByCommentId;
							self.addDroneComment = addDroneComment;
							self.updateDroneComment = updateDroneComment;
							self.reset = reset;
							
							// this is for the comment page - get all comments for a drone id
							function fetchAllDroneCommentByDroneId(id) {

								DroneCommentService.fetchAllDroneCommentByDroneId(id)
										.then(function(d) {
													self.comments = d;
												})
										.catch(function(error) {
												console.error('Error while fetching Comments by Drone Id');
								                console.error(error);
												});
							}
	
							function deleteDroneCommentByCommentId(id) {
								// we always expect a null DroneComment object returned from the delete
								// then we fetch any (0, 1, many) comments remaining for this drone
								DroneCommentService.deleteDroneCommentByCommentId(id)
									.then(function(d) {
											self.comment = d;
											self.fetchAllDroneCommentByDroneId(self.holdDroneId);
										})
								.catch(function(error) {
										console.error('Error while deleting DroneComment');
						                console.error(error);
										});
							}
							
						    // the commentId field was null on input and should have been set by hibernate on a successful add
						    function addDroneComment() {
						    	
								// init the comment key fields for an add - we keep the text since linked to the view input 
						    	self.comment.commentId = null;
								self.comment.commentDroneId = self.holdDroneId;
	
								// we always expect a non-null DroneComment object returned from the add
								// then we fetch all comments (0, 1, many) for this drone after the add to refresh the view
								DroneCommentService.addDroneComment(self.comment)
 									.then(function(d) {
											self.comment = d;
											self.fetchAllDroneCommentByDroneId(self.holdDroneId);
											reset(); 
										})
								.catch(function(error) {
										console.error('Error while adding DroneComment');
						                console.error(error);
										});
								self.isNewCommentVisible = false; // needed to turn off the comment area
						    }
							
						    // the commentId field and commentDroneId must NOT be null on input for an update
						    function updateDroneComment() {

						    	// we always expect a non-null DroneComment object with no null fields
								// then we fetch all comments (0, 1, many) for this drone after the update to refresh the view
								DroneCommentService.updateDroneComment(self.comment)
 									.then(function(d) {
											self.comment = d;
											self.fetchAllDroneCommentByDroneId(self.holdDroneId);
											reset(); 
										})
								.catch(function(error) {
										console.error('Error while updatinging DroneComment');
						                console.error(error);
										});
								self.isNewCommentVisible = false; // needed to turn off the comment area
						    }
							
						// needed to wipe the comment area after an add, else the text will repeat
					    function reset() {
							self.comment = {
									commentId : null,
									commentDroneId : null,
									commentDate : null,
									commentText : null
								};
  							}
					    
						} ]);

})();
