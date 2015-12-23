angular.module('ecommApp')

.controller('SupplierProductController', ['$scope', '$rootScope', 'toastr', 'Supplier', 'User', 'Utils', 'supplierProductService',
    function($scope, $rootScope, toastr, Supplier, User, Utils, supplierProductService) {

        // $scope.query = angular.copy(supplierProductService.getDefaultQuery());
        // $scope.query.supplierProduct.creator = null;

        /* Activate Date Picker */
        $('.input-daterange>input').datepicker({
            format: 'yyyy-mm-dd',
            clearBtn: true,
            language: 'zh-CN',
            orientation: 'bottom left',
            todayHighlight: true,
            autoclose: true
        });

        Supplier.getAll({ // 导入所有供应商
            enabled: true,
            sort: ['name']
        }).then(function(suppliers) {
            $scope.suppliers = suppliers;
        });

        User.getAll({ // 导入所有用户
            enabled: true,
            sort: ['username']
        }).then(function(creators) {
            $scope.creators = creators;
        });

        $scope.searchData = function(query) {

            supplierProductService.get({
                page: query.page,
                size: query.size,
                sort: query.sort,
                // query parameters
                queryProductBarcode: query.supplierProduct.supplierProductBarcode,
                querySupplierProductCode: query.supplierProduct.supplierProductCode,
                querySupplierProductName: query.supplierProduct.supplierProductName,
                querySupplierId: query.supplierProduct.supplier ? query.supplierProduct.supplier.id : null,
                queryCreatorId: query.supplierProduct.creator ? query.supplierProduct.creator.id: null,
                queryCreateTimeStart: query.supplierProduct.createTimeStart,
                queryCreateTimeEnd: query.supplierProduct.createTimeEnd,
                queryLastUpdateStart: query.supplierProduct.lastUpdateStart,
                queryLastUpdateEnd: query.supplierProduct.lastUpdateEnd

            }, function(page) {
                $scope.page = page;
                $scope.isCheckedAll = false;
            });

        };

        $scope.search = function(query) {
            query.page = 0;
            $scope.searchData(query);
        };

        $scope.reset = function() {
            $scope.query = angular.copy(supplierProductService.getDefaultQuery());
            $scope.query.supplierProduct.creator = null;
            $scope.searchData($scope.query);
        };

        $scope.reset();

        // 
        $scope.isCheckedAll = false;
        $scope.batchManipulationValue = 'batchManipulation';

        $scope.checkAllSupplierProducts = function() {
            for (var supplierProduct in $scope.page.content) {
                $scope.page.content[supplierProduct].isSelected = $scope.isCheckedAll;
            }
        };

        // 批量操作
        $scope.batchManipulation = function() {
            var supplierProducts = $scope.page.content;
            supplierProductService.selectedSupplierProducts.length = 0;
            $.each(supplierProducts, function() {
                var supplierProduct = this;
                if (supplierProduct.isSelected) {
                    supplierProductService.selectedSupplierProducts.push(angular.copy(supplierProduct));
                }
            });
            if (supplierProductService.selectedSupplierProducts.length > 0) {
                if ($scope.batchManipulationValue === 'supplierProductExport') {
                    toastr.info('供应商产品导出！');
                } else if ($scope.batchManipulationValue === 'supplierProductPrint') {
                    toastr.info('供应商产品打印！');
                }
            } else {
                toastr.error('请选择一到多个供应商产品来继续！');
            }
            $scope.batchManipulationValue = 'batchManipulation';
        };

    }
]);
