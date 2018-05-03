/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let app = angular.module("contactapp", []);

app.controller("ContactController", function ($scope, $http) {
  $scope.newContact = {};
  $scope.newContact.firstName = "";
  $scope.newContact.lastName = "";
  $scope.newContact.email = "";
  $scope.newContact.phoneNumber = "";
  $scope.newContact.age = 0;
  $scope.newContact.contactId = 0;
  $scope.token = "";
  $scope.choices = ["firstName", "lastName", "email"];

  $scope.addContact = function () {
    console.log("Age:" + $scope.newContact.age);
    $http({
      method: "POST",
      url: "http://localhost:8080/api/contact?mode=add",
      data: {
        "firstName": $scope.newContact.firstName,
        "lastName": $scope.newContact.lastName,
        "phoneNumber": $scope.newContact.phoneNumber,
        "email": $scope.newContact.email,
        "age": $scope.newContact.age,
        "contactId": 0
      },
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response.data);
      $scope.newContact.firstName = "";
      $scope.newContact.lastName = "";
      $scope.newContact.email = "";
      $scope.newContact.phoneNumber = "";
      $scope.newContact.age = 0;
      $scope.newContact.contactId = 0;
    }, function (err) {
      console.log(err);
    });
  };
  
  $scope.editContact = function () {
    console.log("Age:" + $scope.newContact.age);
    $http({
      method: "POST",
      url: "http://localhost:8080/api/contact?mode=edit",
      data: {
        "firstName": $scope.newContact.firstName,
        "lastName": $scope.newContact.lastName,
        "phoneNumber": $scope.newContact.phoneNumber,
        "email": $scope.newContact.email,
        "age": $scope.newContact.age,
        "contactId": $scope.newContact.contactId
      },
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response.data);
      $scope.newContact.firstName = "";
      $scope.newContact.lastName = "";
      $scope.newContact.email = "";
      $scope.newContact.phoneNumber = "";
      $scope.newContact.age = 0;
      $scope.newContact.contactId = 0;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.deleteAll = function () {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/contact",
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (data) {
      $scope.contacts = [];
      console.log(data);
    }, function (err) {
      console.log(err);
    });
  };

  $scope.find = function () {
    let url = "http://localhost:8080/api/contact?search=" +
            $scope.searchTerm +
            "&value=" +
            $scope.value;

    $http({
      method: "GET",
      url: url,
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response);
      $scope.contacts = response.data;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.findByAge = function () {
    let url = "http://localhost:8080/api/contact/age?gt=" +
            $scope.lowerLimit +
            "&lt=" +
            $scope.upperLimit;

    $http({
      method: "GET",
      url: url,
      headers: {
        "Content-Type": "application/json",
        "authtoken": $scope.token
      }
    }).then(function (response) {
      console.log(response);
      $scope.contacts = response.data;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.login = function () {
    $http({
      method: "POST",
      url: "http://localhost:8080/login",
      headers: {"Content-Type": "application/json"},
      data: {
        "userName": $scope.userName,
        "password": $scope.password
      }
    }).then(function (response) {
      console.log(response.data);
      $scope.token = response.data.authtoken;
    }, function (err) {
      console.log(err);
    });
  };

  $scope.register = function () {
    $http({
      method: "POST",
      url: "http://localhost:8080/register",
      headers: {"Content-Type": "application/json"},
      data: {
        "userName": $scope.userName,
        "password": $scope.password
      }
    }).then(function (response) {
      console.log(response.data);
    }, function (err) {
      console.log(err);
    });
  };

  $scope.edit = function (contact) {
    $scope.newContact = contact;
  }
});
