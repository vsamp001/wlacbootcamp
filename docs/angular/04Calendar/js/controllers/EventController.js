app.controller('EventController', ['$scope', 'allevents' ,'$routeParams', function($scope, allevents, $routeParams) {
  allevents.success(function(data){
        $scope.event = data.events[$routeParams.id];
        console.log($scope.event);
    });
}]);

