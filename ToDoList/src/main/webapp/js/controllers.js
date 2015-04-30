'use strict';

/* Controllers */


var app = angular.module('ngdemo.controllers', []);


// Clear browser cache (in development mode)
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

app.controller('TodoCtrl'), []

app.controller('MyCtrl1', ['$scope', 'UserFactory', function ($scope, UserFactory) {
    $scope.bla = 'bla from controller';
    UserFactory.get({}, function (userFactory) {
        $scope.firstname = userFactory.lastName;
    })
}]);
