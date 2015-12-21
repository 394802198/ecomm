angular.module('ecommApp')

.factory('supplierProductService', ['$rootScope', '$resource', '$http', function($rootScope, $resource, $http) {

    var supplierProduct = $resource('/api/supplierproducts/:id', {}, {});

    supplierProduct.getDefaultSupplierProduct = function() {
        return {
            id: null,
            supplierId: null,
            productId: null,
            supplierProductCode: null,
            supplierProductBarcode: null,
            supplierProductName: null,
            defaultPurchasePrice: null,
            createTime: null,
            lastUpdate: null,
            creatorId: null,
            productPlace: null,
            creator: $rootScope.user(),
            supplier: null
        };
    };

    supplierProduct.getDefaultQuery = function() {
        return {
            page: 0,
            size: 20,
            sort: [],
            supplierProduct: supplierProduct.getDefaultSupplierProduct()
        };
    };

    supplierProduct.initProperties = function(supplierProduct) {
    };

    supplierProduct.refreshProperties = function(supplierProduct) {
    };

    supplierProduct.getAll = function(params) {
        return $http.get('/api/supplierproducts/get/all', {
            params: params
        }).then(function(res) {
            return res.data;
        });
    };

    supplierProduct.getByProductSkuAndSupplierId = function(sku, supplierId) {
        console.log('sku: ' + sku);
        console.log('supplierId: ' + supplierId);
        return $http.get('/api/supplierproducts/by_sku_and_supplier_id/' + sku + '/' + supplierId).then(function(res) {
            return res.data;
        });
    };

    supplierProduct.checkUniqueSupplierProductCode = function(params) {
        return $http.get('/api/supplierproducts/check-unique', {
            params: params
        }).success(function(data) {
            return data;
        }).error(function() {
            return false;
        });
    };


    // 批量选中
    supplierProduct.selectedSupplierProducts = [];

    // 单个选中
    supplierProduct.selectedSupplierProduct = {};

    supplierProduct.getSelectedSupplierProduct = function() {
        return supplierProduct.selectedSupplierProduct;
    };

    supplierProduct.setSelectedSupplierProduct = function(selectedSupplierProduct) {
        supplierProduct.selectedSupplierProduct = selectedSupplierProduct;
    };

    supplierProduct.saveOneKey = function(params) {
        return $http.post('/api/supplier-products/save/one-key', params).then(function(res){
            return res.data;
        });
    };

    return supplierProduct;

}]);
