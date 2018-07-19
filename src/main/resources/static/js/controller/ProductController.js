app.controller('productCtrl', function ($scope, $http) {
    $scope.product = {};
    $scope.product.num = getBatch();

    function getBatch() {
        var date = new Date();
        return date.getFullYear() + "" + (date.getMonth() + 1) + "" + date.getDate()
            + date.getHours() + date.getMinutes() + date.getSeconds();
    }

    $scope.submit = function () {
        // $scope.product = angular.toJson($scope.product);
        console.log($scope.product);
        $http({
            method: "POST",
            url: "/product/insert",
            data: angular.toJson($scope.product)
        }).success(function (data, status) {
            //$scope.status = status;
            $scope.users = data;
            alert("保存成功");
        }).error(function (data, status) {
            //$scope.data = data || "Request failed";
            //$scope.status = status;
        });
    }
});