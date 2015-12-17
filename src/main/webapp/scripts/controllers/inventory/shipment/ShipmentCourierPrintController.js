
var ShipmentCourierPrintController = function($scope, $rootScope, $location, $interval, toastr, purchaseOrderService, Utils)
{

    $scope.defaultQuery =
    {
        purchaseOrderIds    :   []
    };
    $scope.query = angular.copy( $scope.defaultQuery );

    $scope.operator = $rootScope.user();


    function updatePrintTime()
    {
        $scope.printTime = new Date();
    }

    var printTimeInterval = $interval( updatePrintTime, 500 );

    $scope.$on('$destroy', function()
    {
        $interval.cancel( printTimeInterval );
    });

    $scope.searchData = function(query, number)
    {
        var search = $location.search();
        var purchaseOrderId = search.purchaseOrderId;

        if( purchaseOrderId )
        {
            query.purchaseOrderIds = purchaseOrderId.split(',');
        }

        if( query.purchaseOrderIds.length > 0 )
        {
            purchaseOrderService.get({
                page: number ? number : 0,
                purchaseOrderIds: query.purchaseOrderIds
            }, function(page) {
                $scope.page = page;
                query.totalPagesList = Utils.setTotalPagesList(page);
                toastr.success('采购单准备就绪，可以进行打印操作');
            });
        }
    };

};

ShipmentCourierPrintController.$inject = ['$scope', '$rootScope', '$location', '$interval', 'toastr', 'purchaseOrderService', 'Utils'];

angular.module('ecommApp').controller('ShipmentCourierPrintController', ShipmentCourierPrintController);