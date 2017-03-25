/**
 * Created by Buddhi on 3/19/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('LayoutController', LayoutController);

    LayoutController.$inject = [];

    function LayoutController() {
        var vm = this;

        console.log("Layout Controller");

        vm.name = "Buddhi Vikasitha"

    }
})();
