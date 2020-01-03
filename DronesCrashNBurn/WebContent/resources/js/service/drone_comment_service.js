(function() {
// IIFE
'use strict';

angular.module('myApp').factory('DroneCommentService', ['$http', function($http){
		
     var BASE_REST_URI='/DronesCrashNBurn/droneComment';

     var factory = {
        fetchAllDroneCommentByDroneId : fetchAllDroneCommentByDroneId,
        fetchDroneCommentByCommentId : fetchDroneCommentByCommentId,
        deleteDroneCommentByCommentId : deleteDroneCommentByCommentId,
        addDroneComment : addDroneComment
     };
    return factory;

    // The catch was important to close the promise, otherwise strange things happed after sync add
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
 
    // The catch was important to close the promise, otherwise strange things happed after sync add
    // fetch a comment by a comment id
    function fetchDroneCommentByCommentId(id) {
     	return $http.get(BASE_REST_URI + "/droneComment/" + id)
      		.then(function(resp){
      			return resp.data;
        }).catch(function(error){
            console.error('Error while fetchDroneCommentByCommentId');
            console.error(error);
        });
    }

    // The catch was important to close the promise, otherwise strange things happed after sync add
    // delete a comment by a comment id
    function deleteDroneCommentByCommentId(id) {
        return $http.delete(BASE_REST_URI + "/droneCommentDelete/" + id)
            .then(function (response) {
                 return response.data;
            }).catch( function(errResponse){
                console.error('Error while deleting DroneComment');
                console.error(error);
            });
    }
 
    // the commentId field was null on input and should have been set by hibernate on a successful add
    function addDroneComment(droneComment) {
    	console.log("ADD   before=>");
    	console.log(droneComment);
        return $http.post(BASE_REST_URI + "/" + droneComment)
            .then(function (response) {
            	console.log("ADD    after=>");
            	console.log(droneComment);
                 return response.data;
            }).catch( function(errResponse){
                console.error('Error while adding DroneComment');
                console.error(errResponse);
            });
    }

    
    
    
    
    
}]);

})();
