/**
 * Created by Buddhi on 3/15/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('HomeController', HomeController);

    HomeController.$inject = [];

    function HomeController() {
        var vm = this;

        console.log("Home Controller");

        vm.name = "Buddhi Vikasitha"

    }
})();
