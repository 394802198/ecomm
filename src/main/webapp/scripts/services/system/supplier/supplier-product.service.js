angular.module('ecommApp')

.factory('supplierProductService', ['$resource', '$http', function($resource, $http) {

    var supplierProduct = $resource('/api/supplierproducts/:id', {}, {});

    supplierProduct.getDefaultQuery = function() {
        return {
            page: 0,
            size: 20,
            sort: ['createTime,desc'],
            supplierProduct: {}
        };
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


    /* 批量选中 */
    supplierProduct.selectedSupplierProducts = [];
    /* 单个选中 */
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
