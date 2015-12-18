// Post repeat directive for logging the rendering time  
// angular.module('ecommApp')

// .directive('postRepeatDirective', ['$timeout', '$log', 'TimeTracker',
//     function($timeout, $log, TimeTracker) {
//         return function(scope) {
//             if (scope.$last) {
//                 $timeout(function() {
//                     var timeFinishedLoadingList = TimeTracker.reviewListLoaded();
//                     var ref = new Date(timeFinishedLoadingList);
//                     var end = new Date();
//                     $log.debug('## DOM rendering list took: ' + (end - ref) + ' ms');
//                 });
//             }
//         };
//     }
// ]);
