angular.module('seedApp')

.directive('coSortColumn', ['$compile', function($compile) {

    return {
        name: 'coSortColumn',
        restrict: 'A',
        compile: function(tElement, tAttrs, transcludeFn) {

            var colQueryName = $(tElement).attr('col-query-name');
            var colName = $(tElement).attr('col-name');

            var html = '<a href="" ng-click="toggleSort(\'' + colQueryName + '\')" ng-switch on="query.orderby.' + colQueryName + '">';
            html += '<span>' + colName + '</span>';
            html += '<span ng-switch-when="asc" class="cart-up"></span>';
            html += '<span ng-switch-when="desc" class="cart-down"></span>';
            html += '</a>';

            $(tElement).append(html);

            return function linking(scope, elm, attrs, ctrl, transcludeFn) {

                scope.toggleSort = function(col) {
                    scope.query.orderby = {};
                    var existCol = false;
                    var val = '';
                    $.each(scope.query.sort, function() {
                        if (this.indexOf(col) > -1) {
                            if (this.indexOf('asc') > -1) {
                                val = col + ',desc';
                                scope.query.orderby[col] = 'desc';
                            } else if (this.indexOf('desc') > -1) {
                                val = col + ',asc';
                                scope.query.orderby[col] = 'asc';
                            }
                            existCol = true;
                            return false;
                        }
                    });
                    scope.query.sort.length = 0;
                    if (existCol) {
                        scope.query.sort.push(val);
                    } else {
                        scope.query.sort.push(col + ',desc');
                        scope.query.orderby[col] = 'desc';
                    }
                    scope.searchData(scope.query);
                };

            };
        }

    };

}]);
