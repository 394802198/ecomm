angular.module('seedApp')

.directive('coFormValidation', ['$timeout', function($timeout) {

    return {
        name: 'coFormValidation',
        require: 'form',
        restrict: 'A',
        compile: function(tElement, tAttrs, transcludeFn) {

            var formName = $(tElement).attr('name');

            $(tElement[0]).find('input').each(function() {

                var $input = $(this);
                var field = $input.attr('name');
                var fieldError = formName + '.' + field + '.$error';
                var fieldInvalid = formName + '.' + field + '.$invalid';
                var submitted = formName + '.$submitted';
                var attrValue = '{\'has-error\':((' + submitted + ' || ' + fieldError + '.unique) && ' + fieldInvalid + ')}';

                $input.parents('div.form-group').attr('ng-class', attrValue);

                var html = '<span class="help-block" ng-messages="' + fieldError + '" ng-show="' + submitted + ' || ' + fieldError + '.unique">';
                html += '<span ng-messages-include="' + tAttrs.messagesUrl + '"></span>';
                html += '</span> ';

                $input.after(html);

            });

            return function linking(scope, elm, attrs, ctrl) {

                $timeout(function() {
                    $(elm).find('input').first().focus();
                });

                $(elm).on('submit', function() {
                    if (ctrl.$error) {
                        $.each(ctrl.$error, function() {
                            var name = this[0].$name;
                            $timeout(function() {
                                $('input[name="' + name + '"]').focus();
                            });
                            return false;
                        });
                    }

                });

            };
        }

    };

}]);
