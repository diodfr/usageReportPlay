
angular.module('MyServiceModule', []).factory('WakeUpReportUpdate', function($http, $timeout, $rootScope, $window, $log) {

	function updateResult() {
    	$http.get('/dynResult').success(function(data) {
   			$rootScope.reports = data;
   			$timeout(updateResult, 10000);
		});
		
	}
	
	updateResult();
	
	return function() {};
});

function UsageReportControler(WakeUpReportUpdate, $window, $scope, $log) {
	WakeUpReportUpdate();
	
	$scope.showPicture = function(imageUrl) {
		$log.warn(imageUrl);
		$scope.mainImageUrl ='http://agil.corp.local/agil/photoReader?path=/loc/giseh/' + imageUrl.toLowerCase() + '.jpg';
	}
}