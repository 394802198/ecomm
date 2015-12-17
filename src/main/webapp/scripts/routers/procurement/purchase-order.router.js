angular.module('ecommApp')

.config(['$stateProvider', 'ROLES', function($stateProvider, ROLES) {

    var t = $.now();

    $stateProvider
        .state('purchaseOrder', {
            parent: 'site',
            url: '/purchase-orders',
            views: {
                'content@': {
                    templateUrl: 'views/procurement/purchase-order/purchase-order.html?' + t,
                    controller: 'PurchaseOrderController'
                }
            },
            data: {
                roles: [ROLES.SYSTEM_ADMIN, ROLES.PURCHASE_ADMIN]
            }
        })
        .state('purchaseOrder.operator', {
            url: '/purchase-order/:id/:purchasedProducts',
            // params: {
            //     purchasedProducts: null
            // },
            views: {
                'content@': {
                    templateUrl: 'views/procurement/purchase-order/purchase-order.operator.html?' + t,
                    controller: 'PurchaseOrderOperatorController'
                }
            },
            data: {
                roles: [ROLES.SYSTEM_ADMIN, ROLES.PURCHASE_ADMIN]
            }
        })
        .state('purchaseOrder.print', {
            parent: 'site',
            url: '/purchase-order-print',
            views: {
                'content@': {
                    templateUrl: 'views/procurement/purchase-order/purchase-order.print.html?' + t,
                    controller: 'PurchaseOrderPrintController'
                }
            },
            data: {
                roles: [ROLES.SYSTEM_ADMIN, ROLES.PURCHASE_ADMIN]
            }
        });
}]);
