/**
 * Created by Buddhi on 3/19/2017.
 */
(function () {
    'use strict';

    angular.module('aduwata')
        .controller('LogInController', LogInController);

    LogInController.$inject = ['webservice','$state','$cookies'];

    function LogInController(webservice,$state,$cookies) {
        var vm = this;

        vm.signInUser = signInUser;

        function signInUser(username, password) {
            var user = {
                name: username,
                password: password,
                type: 0
            };
            var url = "/user/login_user";
            webservice.call(url, "POST", user).then(function (response) {
                if (response.data.user_id != null) {
                    if (response.data.type == 1) {
                        $cookies.put('userType', 'Customer');
                    } else if (response.data.type == 2) {

                    }
                    $cookies.put('userId', response.data.user_id);
                    $cookies.put('userName', response.data.name);
                    $state.go('home');
                } else {
                    // alert("Username or Password is wrong.");
                    vm.error = "Username and password mismatch";
                }
            });
        }
    }
})();
