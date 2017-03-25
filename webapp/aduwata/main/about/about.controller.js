/**
 * Created by Buddhi on 3/15/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('AboutController', AboutController);

    AboutController.$inject = ['webservice'];

    function AboutController(webservice) {
        var vm = this;

        console.log("About Controller");

        vm.name = "Buddhi Vikasitha";

        webservice.call('/', 'get').then(function (response) {
            console.log(response);
        });

    }
})();


