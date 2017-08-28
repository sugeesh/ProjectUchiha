/**
 * Created by Buddhi on 3/19/2017.
 */
(function () {
    'use strict';

    angular.module('aduwata')
        .controller('ViewItemController', ViewItemController);

    ViewItemController.$inject = ['webservice','$stateParams'];

    function ViewItemController(webservice, $stateParams) {
        var vm = this;

        vm.itemId  = $stateParams.id;
        /*loadItem(vm.itemId);


        function loadItem(itemId) {
            var url = "/item/by_id"+ "?" + "id=" + itemId;
            webservice.call(url, 'GET').then(function (response) {
                vm.itemName = response.data.name;
                vm.description = response.data.description;
                vm.price = response.data.price;
            });
        }*/


    }
})();
