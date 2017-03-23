//...
var app = angular.module('CalendarApp', ['ngRoute']);

app.config(function($routeProvider){
     $routeProvider.when('/', {
        controller: 'DayController',
        templateUrl: '/Week7/04Calendar/views/day.html'
    })
    .when('/:id',{
        controller: 'EventController',
        templateUrl: '/Week7/04Calendar/views/event.html'
    })
    .otherwise({redirectTo: '/'});
});