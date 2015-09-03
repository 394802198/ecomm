'use strict';

var ecommApp = angular.module('ecommApp');

ecommApp.config(['$stateProvider', 'ROLES',
    function($stateProvider, ROLES) {

        $stateProvider
            .state('order', {
                parent: 'site',
                url: '/orders',
                views: {
                    'content@': {
                        templateUrl: 'views/order/order.html?' + (new Date()),
                        controller: 'OrderController'
                    }
                },
                data: {
                    roles: [ROLES.sysadmin],
                    authorities: []
                }
            });
    }
]);
