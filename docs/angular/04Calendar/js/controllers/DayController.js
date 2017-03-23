app.controller('DayController', ['$scope', 'allevents', function($scope, allevents) {
    allevents.success(function(data){
        $scope.allevents = data;
    });
}]);