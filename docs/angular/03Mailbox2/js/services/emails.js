app.factory('emails', ['$http', function($http){
    return $http.get('/Week7/01Mailbox/emails.json')
        .success(function(data){
            return data;
        })
        .error(function(err){
            return err;
        });
}]);