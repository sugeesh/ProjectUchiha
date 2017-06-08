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


        function logOut() {
            $cookies.remove('userId');
            $state.go('login');
        }

        $state.go('home');
    }


})();

