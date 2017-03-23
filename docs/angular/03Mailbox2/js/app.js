//... Create your module
var app = angular.module('MailboxApp',['ngRoute']);

app.config(function ($routeProvider) {

    $routeProvider.when('/inbox', {
        controller: 'HomeController',
        templateUrl: '/Week7/03Mailbox2/views/home.html'
    })
    .when('/inbox/:id', {
       controller:'EmailController',
       templateUrl:'/Week7/03Mailbox2/views/email.html'
    })
    .otherwise({redirectTo: '/inbox'});

});