/**
 * Created by Buddhi on 3/19/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('AddItemController', AddItemController);

    AddItemController.$inject = ['webservice'];

    function AddItemController(webservice) {
        var vm = this;

        console.log("Add Item Controller");

        vm.name = "Buddhi Vikasitha"

        var item = {
            name: "OMAX Men's watch",
            price: 4000,
            color: "Silver",
            size: null,
            used: false
        };

        webservice.call('/add_item', 'post', item).then(function (response) {
            console.log(response);
        });

    }
})();
