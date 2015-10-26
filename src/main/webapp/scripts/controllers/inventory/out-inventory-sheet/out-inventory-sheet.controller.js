angular.module('ecommApp')

.controller('OutInventorySheetController', ['$rootScope', '$scope', 'Warehouse', 'Utils', 'Inventory', 'InventoryBatch', 'Auth',
    function($rootScope, $scope, Warehouse, Utils, Inventory, InventoryBatch, Auth) {

        var $ = angular.element;

        $scope.page = undefined;

        $scope.warehouses = [];
        $scope.types = [{
            label: '全部',
            value: null
        }, {
            label: '作废',
            value: 0
        }, {
            label: '待出库',
            value: 1
        }, {
            label: '已出库',
            value: 2
        }];

        $scope.defautlQuery = {
            pageSize: 20,
            totalPagesList: [],
            warehouse: undefined,
            batch: {
                operateTimeStart: undefined,
                operateTimeEnd: undefined,
                outInventoryTimeStart: undefined,
                outInventoryTimeEnd: undefined,
                type: $scope.types[0],
                operate: 2
            }
        };
        $scope.query = angular.copy($scope.defautlQuery);

        Warehouse.getAll({
            deleted: false,
            sort: ['name'],
            warehouseIds: Auth.refreshManaged('warehouse')
        }).then(function(warehouses) {
            $scope.warehouses = warehouses;
        });

        $scope.searchData = function(query, number) {
            InventoryBatch.get({
                page: number ? number : 0,
                size: query.pageSize,
                warehouseId: query.warehouse ? query.warehouse.id : null,
                warehouseIds: Auth.refreshManaged('warehouse'),
                operateTimeStart: query.batch.operateTimeStart,
                operateTimeEnd: query.batch.operateTimeEnd,
                outInventoryTimeStart: query.batch.outInventoryTimeStart,
                outInventoryTimeEnd: query.batch.outInventoryTimeEnd,
                type: query.batch.type ? query.batch.type.value : null,
                operate: query.batch.operate
            }).$promise.then(function(page) {
                $scope.page = page;
                query.totalPagesList = Utils.setTotalPagesList(page);
            });
        };

        $scope.searchData($scope.query);

        $scope.turnPage = function(number) {
            if (number > -1 && number < $scope.page.totalPages) {
                $scope.searchData($scope.query, number);
            }
        };

        $scope.search = function(query) {
            $scope.searchData(query);
        };

        $scope.reset = function() {
            $scope.query = angular.copy($scope.defautlQuery);
            $scope.searchData($scope.query);
        };

        $scope.selectAll = function(page) {
            $.each(page.content, function() {
                this.checked = $scope.checkedAll;
            });
        };

        $('#sandbox-container-create .input-daterange').datepicker({
            format: 'yyyy/mm/dd',
            clearBtn: true,
            language: 'zh-CN',
            orientation: 'top left',
            todayHighlight: true,
        });

        $('#sandbox-container-out-inventory .input-daterange').datepicker({
            format: 'yyyy/mm/dd',
            clearBtn: true,
            language: 'zh-CN',
            orientation: 'top left',
            todayHighlight: true,
        });

        $scope.invalidingBatch = undefined;

        $scope.showInvalidBatch = function(batch) {
            $scope.invalidingBatch = batch;
            $('#batchInvalidModal').modal('show');
        };

        $scope.invalidBatch = function() {
            console.clear();
            console.log('invalidBatch');
            console.log($scope.invalidingBatch);
            $scope.invalidingBatch.type = 0;
            $scope.invalidingBatch.orderBatches.length = 0;
            InventoryBatch.save({}, $scope.invalidingBatch, function() {
                $('#batchInvalidModal').modal('hide');
                $scope.searchData($scope.query);
            });
        };
    }

]);
