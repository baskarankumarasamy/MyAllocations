angular.module('myApp', ['ui.bootstrap', 'dataGrid', 'pagination'])
    .controller('myAppController', ['$scope', 'myAppFactory', function ($scope, myAppFactory) {

        $scope.gridOptions = {
            data: [],
            urlSync: true
        };

        myAppFactory.getData().then(function (responseData) {
            $scope.gridOptions.data = responseData.data;
        });

    }])
    .factory('myAppFactory', function ($http) {
        return {
            getData: function () {
                return $http({
                    method: 'GET',
                    url: 'http://localhost:8080/allocations/getAllocationsDetails?empId=1'
                });
            }
        }
    });

