(function() {
// IIFE
'use strict';

angular.module('myApp').factory('DroneCommentService', ['$http', function($http){
		
     var BASE_REST_URI='/DronesCrashNBurn/droneComment';

     var factory = {
        fetchAllDroneCommentByDroneId : fetchAllDroneCommentByDroneId,
        fetchDroneCommentByCommentId : fetchDroneCommentByCommentId
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
     
}]);

})();
