/**
 * Created by Buddhi on 2/11/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('SidebarController', SidebarController);

    SidebarController.$inject = ['webservice'];

    function SidebarController(webservice) {
        var vm = this;

        console.log("in sidebar");
    }
})();
