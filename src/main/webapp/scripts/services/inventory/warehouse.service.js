angular.module('ecommApp')

.factory('Warehouse', ['$resource', '$http', function($resource, $http) {

	var warehouse = $resource('/api/warehouses/:id', {}, {});

	warehouse.getAll = function() {
        return $http.get('/api/warehouses/get/all').then(function(res) {
            return res.data;
        });
    };

    warehouse.savePositions = function(positions){
    	return $http.post('/api/warehousepositions/save/list', positions).then(function(res) {
            return res.data;
        });
    };

    return warehouse;
}]);

