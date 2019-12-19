(function() {
// IIFE
'use strict';

angular.module('myApp').factory('DroneCommentService', ['$http', function($http){
		
     var BASE_REST_URI='/DronesCrashNBurn/droneComments';

     var factory = {
        fetchAllDroneCommentByDroneId : fetchAllDroneCommentByDroneId
     };
    return factory;

    // The catch was important to close the promise, otherwise strange things happed after sync add
    function fetchAllDroneCommentByDroneId(id) {
     	return $http.get(BASE_REST_URI + "/" + id)
      		.then(function(resp){
      			return resp.data;
        }).catch(function(error){
            console.error('Error while fetchAllDroneCommentByDroneId');
            console.error(error);
        });
    }
   
}]);

})();
