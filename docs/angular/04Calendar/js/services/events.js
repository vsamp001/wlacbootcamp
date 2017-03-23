app.factory('allevents', ['$http', function($http){
    return $http.get('/Week7/04Calendar/events.json')
        .success(function(data){
            return data;
        })
        .error(function(err){
            return err;
        });
}]);