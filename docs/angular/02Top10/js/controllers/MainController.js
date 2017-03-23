app.controller('MainController', ['$scope', 'shows' ,function($scope, shows, $http){
    shows.success(function(data){
    $scope.shows = data; 
    });
}]);