/**
 * Created by Buddhi on 3/19/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('NotFoundController', NotFoundController);

    NotFoundController.$inject = [];

    function NotFoundController() {
        var vm = this;

        console.log("404 Controller");

        vm.name = "Buddhi Vikasitha"

    }
})();
