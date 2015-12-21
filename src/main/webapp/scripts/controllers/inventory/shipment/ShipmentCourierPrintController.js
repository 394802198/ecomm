
var ShipmentCourierPrintController = function($scope, $rootScope, $location, $interval, toastr, shipmentService, Utils)
{

    $scope.defaultQuery =
    {
        shipmentIds    :   []
    };
    $scope.query = angular.copy( $scope.defaultQuery );

    $scope.operator = $rootScope.user();

    $scope.postingDate = new Date();

    function grep( mergedItems, item )
    {
        return $.grep( mergedItems, function( e )
        {
            console.log( e );
            if( e.printName === item.printName )
            {
                e.qtyShipped += item.qtyShipped;
            }
            return e.printName === item.printName;
        });
    }

    function initMergeShipmentItems()
    {
        var shipments = $scope.page.content;
        for( var shipmentIndex in shipments )
        {
            var mergedItems = [];
            var items = shipments[ shipmentIndex ].shipmentItems;
            for( var itemIndex in items )
            {
                var item = items[ itemIndex ];
                //console.log( item );
                var result = grep( mergedItems, item );
                if( result.length < 1 )
                {
                    mergedItems.push( item );
                }
            }

            shipments[ shipmentIndex ].mergedItems = mergedItems;
        }
    }


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
        var shipmentId = search.shipmentId;

        if( shipmentId )
        {
            query.shipmentIds = shipmentId.split(',');
        }

        if( query.shipmentIds.length > 0 )
        {
            shipmentService.get({
                page: number ? number : 0,
                shipmentIds: query.shipmentIds
            }, function(page) {
                $scope.page = page;
                query.totalPagesList = Utils.setTotalPagesList(page);

                initMergeShipmentItems();
            });
        }
    };

    $scope.searchData( $scope.query );

};

ShipmentCourierPrintController.$inject = ['$scope', '$rootScope', '$location', '$interval', 'toastr', 'shipmentService', 'Utils'];

angular.module('ecommApp').controller('ShipmentCourierPrintController', ShipmentCourierPrintController);