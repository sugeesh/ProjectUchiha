/**
 * Created by Buddhi on 2/27/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('BodyController', BodyController);

    BodyController.$inject = ['$state', '$rootScope', 'webservice','$cookies'];


    function BodyController($state, $rootScope, webservice,$cookies) {
        var vm = this;
        vm.loggedin = $cookies.get('userId');
        vm.logOut = logOut;

        vm.districts = ["Colombo","Kandy","Galle","Ampara","Anuradhapura","Badulla","Batticaloa",
            "Gampaha","Hambantota","Jaffna","Kalutara","Kegalle","Kilinochchi","Kurunegala",
            "Mannar","Matale","Matara","Moneragala","Mullativu","Nuwara Eliya","Polonnaruwa",
            "Puttalam","Ratnapura","Trincomalee","Vavuniya"];

        function logOut() {
            $cookies.remove('userId');
            $state.go('login');
        }

        $state.go('home');
    }


})();

