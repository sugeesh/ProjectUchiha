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
        loadItem(vm.itemId);


        function loadItem(itemId) {
            var url = "/item/by_id"+ "?" + "id=" + itemId;
            webservice.call(url, 'GET').then(function (response) {
                vm.title = response.data.title;
                vm.description = response.data.description;
                vm.price = response.data.price;
                vm.district = response.data.district;
                vm.category_name = response.data.category_name;
                vm.subCategory_name = response.data.subCategory_name;
                vm.contact = response.data.contact;
                vm.details = response.data.detailsObjList;

            });
        }


    }
})();
