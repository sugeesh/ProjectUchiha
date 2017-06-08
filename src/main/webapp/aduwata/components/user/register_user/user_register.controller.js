/**
 * Created by Buddhi on 3/19/2017.
 */
(function () {
    'use strict';

    angular.module('aduwata')
        .controller('UserRegisterController', UserRegisterController);

    UserRegisterController.$inject = ['webservice'];

    function UserRegisterController(webservice) {
        var vm = this;
        vm.registerUser = registerUser;

        vm.name = "";
        vm.email = "";
        vm.password = "";
        vm.passwordRe = "";

        function registerUser() {
            if(vm.password== vm.passwordRe) {
                var sendObj = {
                    "name": vm.name,
                    "email": vm.email,
                    "password": vm.password
                };
                webservice.call('/user/user_register', 'POST', sendObj).then(function (response) {
                    alert("user registered successfully");
                });
            }else {
                alert("Password mismatch !");
            }
        }


    }
})();
