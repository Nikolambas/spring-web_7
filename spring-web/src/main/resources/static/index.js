angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data);
                $scope.productsList = response.data;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.createStudentJson = function (){
        console.log($scope.newStudentJson);
        $http.post(contextPath + '/students', $scope.newStudentJson)
            .then(function (response) {
                $scope.loadStudents()
            });
    }

    $scope.loadProducts();
});