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
								droneId : null,
								droneOwnerName : '',
								droneName : '',
								droneType : '',
								droneSpan : '',
								droneFirstFlownDate : '',
								droneStatus : '',
								droneImage : ''
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
										.catch(function(error) {
												console.error('Error while fetching Drones');
								                console.error(error);
												});
							}

							// this is for the comment page - get 1 drone by id
							function fetchDroneByDroneId(id) {
								DroneService.fetchDroneByDroneId(id)
										.then(function(d) {
													self.drone = d;
										})
										.catch(function(error) {
												console.error('Error while fetching a Drone by Id');
								                console.error(error);
												});
							}

							function deleteDrones(id) {
								DroneService.deleteDrones(id)
										.then(fetchAllDrones, function(error) {
													console.error('Error while deleting Drone');
									                console.error(error);
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
										droneFirstFlownDate : '',
										droneStatus : '',
										droneImage : 'TBD'
								};
							}

						} ]);

})();
