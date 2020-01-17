(function() {
// IIFE
'use strict';

angular.module('myApp').factory('DroneService', ['$http', function($http){
		
     var BASE_REST_URI='/DronesCrashNBurn/drones';

    var factory = {
        fetchAllDrones: fetchAllDrones,
        fetchDroneByDroneId : fetchDroneByDroneId,
        deleteDrones:deleteDrones
   };
   return factory;

    // The catch was important to close the promise, otherwise strange things happed after sync add
    function fetchAllDrones() {
    	// Do NOT add a forward slash on the literal after the base uri
    	return $http.get(BASE_REST_URI).then(function(resp){
            return resp.data;
        }).catch(function(error){
            console.error('Error while fetchAllDrones');
            console.error(error);
        });
    }

    // The catch was important to close the promise, otherwise strange things happed after sync add
    function deleteDrones(id) {
        return $http.delete(BASE_REST_URI + "/" + id)
            .then(function (response) {
                return response.data;
            }).catch( function(error){
                console.error('Error while deleting Drone');
                console.error(error);
            });
    }

    // The catch was important to close the promise, otherwise strange things happed after sync add
    function fetchDroneByDroneId(id) {
     	return $http.get(BASE_REST_URI + "/" + id)
      		.then(function(resp){
      			return resp.data;
        }).catch(function(error){
            console.error('Error while fetchDroneByDroneId');
            console.error(error);
        });
    }
   
}]);

})();
