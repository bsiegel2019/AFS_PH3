(function() {
// IIFE
'use strict';

angular.module('myApp').factory('DroneCommentService', ['$http', function($http){
		
     var BASE_REST_URI='/DronesCrashNBurnBE/droneComment';

     var factory = {
        fetchAllDroneCommentByDroneId : fetchAllDroneCommentByDroneId,
        deleteDroneCommentByCommentId : deleteDroneCommentByCommentId,
        addDroneComment : addDroneComment,
        updateDroneComment : updateDroneComment
     };
    return factory;

    // fetch all comments for a drone id
    function fetchAllDroneCommentByDroneId(id) {
     	return $http.get(BASE_REST_URI + "/droneComments/" + id)
      		.then(function(resp){
      			return resp.data;
        }).catch(function(error){
            console.error('Error while fetchAllDroneCommentByDroneId');
            console.error(error);
        });
    }
 
    // delete a comment by a comment id
    function deleteDroneCommentByCommentId(id) {
        return $http.delete(BASE_REST_URI + "/droneCommentDelete/" + id)
            .then(function (response) {
                 return response.data;
            }).catch( function(error){
                console.error('Error while deleting DroneComment');
                console.error(error);
            });
    }
 
    // the commentId field was null on input and should have been set by hibernate on a successful add
    function addDroneComment(comment) {
        return $http.post(BASE_REST_URI + "/addComment", comment)
            .then(function (response) {
                 return response.data;
            }).catch( function(error){
                console.error('Error while adding DroneComment');
                console.error(error);
            });
    }

    // no fields are null for update - pass comment obj on
    function updateDroneComment(comment) {
        return $http.post(BASE_REST_URI + "/updateComment", comment)
            .then(function (response) {
                 return response.data;
            }).catch( function(error){
                console.error('Error while updating DroneComment');
                console.error(error);
            });
    }

}]);

})();
