var SupplierProductOperatorController = function($scope, $rootScope, $state, $stateParams, $filter, toastr, supplierProductService, Supplier, Product) {

    $scope.actionLabel = ($stateParams.id && $stateParams.id !== '') ? '编辑' : '创建';
    $scope.action = 'create';

    $scope.supplierProduct = angular.copy(supplierProductService.getDefaultSupplierProduct());

    $scope.getProduct = function(val) {
        return Product.get({
            page: 0,
            size: 30,
            enabled: true,
            nameOrSku: val
        }).$promise.then(function(page) {
            return page.content;
        });
    };

    Supplier.getAll({
        enabled: true
    }).then(function(suppliers) {
        $scope.suppliers = suppliers;
    });

    if ($stateParams.id && $stateParams.id !== '') {
        $scope.action = 'update';
        supplierProductService.get({
            id: $stateParams.id
        }, function(supplierProduct) {
            supplierProductService.initProperties(supplierProduct);
            $scope.supplierProduct = supplierProduct;
        });
    }

    $scope.saveSupplierProduct = function(supplierProductForm, supplierProduct) {

        if (supplierProductForm.$valid) {
            supplierProductService.refreshProperties(supplierProduct);
            supplierProductService.save({}, supplierProduct, function() {
                $state.go('supplierProduct');
            });
        }
        
        // var isQualified = true;

        // if (!formValid) {
        //     if (!supplierProduct.supplierProductCode) {
        //         toastr.warning('请填写［供应商产品编号］');
        //     } else {
        //         supplierProductService.checkUniqueSupplierProductCode({
        //             checkUnique: true,
        //             supplierProductCode: supplierProduct.supplierProductCode
        //         }, {}).then(function(result) {
        //             if (result.data) {
        //                 toastr.warning('［供应商产品编号］不可以重复');
        //             }
        //         });
        //     }
        //     if (!supplierProduct.supplierProductName) {
        //         toastr.warning('请填写［供应商产品名称］');
        //     }
        //     if (!supplierProduct.supplier) {
        //         toastr.warning('请选择一个［供应商］');
        //     }
        //     isQualified = false;
        // }

        // if (isQualified) {
        //     console.log(supplierProduct);
        //     supplierProductService.save({
        //         action: $scope.action
        //     }, supplierProduct, function(supplierProduct) {
        //         console.log('[' + $scope.action + '] save supplierProduct complete:');
        //         console.log(supplierProduct);
        //         $state.go('supplierProduct');
        //     });
        // }
    };

    // 重新构建［价格］
    $scope.rebuildPriceNumeric = function(product, field) {
        product[field] = Number(product[field]);
        if ($.isNumeric(product[field])) {
            product[field] = product[field] > 0 ? product[field] : 0.00;
            product[field] = Number(product[field]).toFixed(2);
        } else {
            product[field] = 0.00;
        }
    };

};

SupplierProductOperatorController.$inject = ['$scope', '$rootScope', '$state', '$stateParams', '$filter', 'toastr', 'supplierProductService', 'Supplier', 'Product'];

angular.module('ecommApp').controller('SupplierProductOperatorController', SupplierProductOperatorController);
