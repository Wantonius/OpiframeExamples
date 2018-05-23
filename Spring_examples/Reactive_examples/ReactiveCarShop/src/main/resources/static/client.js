let app = angular.module("CarApp", []);

app.controller("CarController", function ($scope, $http) {
    $scope.streamOn = false;
    $scope.carStream = [];
    $scope.edit = false;
    $scope.editId = "";

    $scope.token = "";

    $scope.getCars = function () {
        $http({
            "method": "GET",
            "url": "/api/car",
            "headers": {
                "Content-Type": "application/json",
                "token": $scope.token
            }
        }).then(function (data) {
            console.log(data.data);
            $scope.carList = data.data;
        }, function (error) {
            console.log(error);
        });
    };

    $scope.findCars = function () {
        if ($scope.searchFor.length > 0 && $scope.param1.length > 0) {
            let searchUrl = "searchType=" + $scope.searchFor + "&param1=" + $scope.param1 + "&param2=" + $scope.param2;
            $http({
                "method": "GET",
                "url": "/api/car/search?" + searchUrl,
                "headers": {
                    "Content-Type": "application/json",
                    "token": $scope.token
                }
            }).then(function (data) {
                console.log(data.data);
                $scope.carList = data.data;
            }, function (error) {
                console.log(error);
            });
        }
    };

    $scope.removeCar = function (car) {
        $http({
            "method": "DELETE",
            "url": "/api/car/" + car.id,
            "headers": {
                "Content-Type": "application/json",
                "token": $scope.token
            }
        }).then(function (data) {
            console.log(data);
            $scope.getCars();
        }, function (error) {
            console.log(error);
        })
    };

    $scope.addCar = function () {
        $http({
            "method": "POST",
            "url": "/api/car",
            "headers": {
                "Content-Type": "application/json",
                "token": $scope.token
            },
            "data": {
                "type": $scope.type,
                "price": $scope.price,
                "year": $scope.year
            }
        }).then(function (data) {
            console.log(data.data);
            $scope.getCars();
        }, function (error) {
            console.log(error);
        });
    };

    $scope.streamCars = function () {
        $scope.streamOn = true;
        if (typeof (EventSource) !== "undefined") {
            let source;
            source = new EventSource("/api/car/stream");
            source.onopen = function (event) {
                console.log("Source open");
            }
            source.onmessage = function (event) {
                console.log(event);
                if (!$scope.streamOn) {
                    source.close();
                }
                $scope.carStream.push(JSON.parse(event.data));
            };
        } else {
            $scope.carStream = "Not supported";
        }
    };

    $scope.stopStream = function () {
        $scope.streamOn = false;
    };

    $scope.editCar = function (car) {
        $scope.edit = true;
        $scope.editId = car.id;
        $scope.type = car.type;
        $scope.year = car.year;
        $scope.price = car.price;
    };

    $scope.updateCar = function () {
        $http({
            "method": "PUT",
            "url": "/api/car",
            "headers": {
                "Content-Type": "application/json",
                "token": $scope.token
            },
            "data": {
                "id": $scope.editId,
                "type": $scope.type,
                "price": $scope.price,
                "year": $scope.year
            }
        }).then(function (data) {
            console.log(data.data);
            $scope.getCars();
            $scope.edit = false;
            $scope.editId = "";
            $scope.type = "";
            $scope.year = "";
            $scope.price = "";
        }, function (error) {
            console.log(error);
        });
    };

    $scope.register = function () {
        $http({
            "method": "POST",
            "url": "/register",
            "headers": { "Content-Type": "application/json" },
            "data": {
                "userName": $scope.userName,
                "passphrase": $scope.passphrase
            }
        }).then(function (data) {
            console.log(data.data);
        }, function (error) {
            console.log(error.data);
        });
    };

    $scope.login = function () {
        $http({
            "method": "POST",
            "url": "/login",
            "headers": { "Content-Type": "application/json" },
            "data": {
                "userName": $scope.userName,
                "passphrase": $scope.passphrase
            }
        }).then(function (data) {
            $scope.token = data.data;
            console.log(data.data);
        }, function (error) {
            console.log(error.data);
        });
    };
});