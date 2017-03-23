app.factory('shows', ['$http', function($http){
        return $http.get('/Week7/02Top10/shows.json')
        .success(function(data){
            return data;
        })
        .error(function(err){
            return err;
        });
}]);