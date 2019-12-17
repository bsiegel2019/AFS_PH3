(function() {
// IIFE
'use strict';

angular.module('myApp')
		.controller('DroneController',
				['$scope','DroneService',

						function($scope, DroneService) {
							var self = this;
							
							// this drone is used for the remove function
							// this drone is used for the comment function
							self.drone = {
								droneId : 2,
								droneOwnerName : 'A',
								droneName : 'B',
								droneType : 'C',
								droneSpan : 'D',
								droneStatus : 'E',
								droneImage : 'planned future feature'
							};

							// this is a list of drones for display
							self.drones = [];
	 						
							self.remove = remove;
							self.reset = reset;
							self.fetchDroneByDroneId = fetchDroneByDroneId;

							fetchAllDrones();

							function fetchAllDrones() {
								DroneService.fetchAllDrones()
										.then(function(d) {
													self.drones = d;
												})
										.catch(function(errResponse) {
												console.error('Error while fetching Drones');
												});
							}

							// this is for the comment page - get 1 drone by id
							function fetchDroneByDroneId(id) {
								console.log("before get 1");
								console.log(id);
								console.log(self.drone);
								
								DroneService.fetchDroneByDroneId(id)
										.then(function(d) {
													self.drone = d;
													
													console.log(" after get 1");
													console.log(id);
													console.log(self.drone);

												})
										.catch(function(errResponse) {
												console.error('Error while fetching a Drone by Id');
												});
							}

							function deleteDrones(id) {
								DroneService.deleteDrones(id)
										.then(fetchAllDrones, function(errResponse) {
													console.error('Error while deleting Drone');
												});
							}

							function remove(id) {
								if (self.drone.id === id) {
									reset();
								}
								deleteDrones(id);
							}

							function reset() {
								self.drone = {
									droneId : null,
									droneOwnerName : '',
									droneName : '',
									droneType : '',
									droneSpan : '',
									droneStatus : '',
									droneImage : 'TBD'
								};
								$scope.myForm.$setPristine(); // reset Form
							}

						} ]);

})();
