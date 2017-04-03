/**
 * Created by Buddhi on 3/19/2017.
 */
(function () {
    'use strict';

    angular.module('aduwata')
        .controller('LogInController', LogInController);

    LogInController.$inject = ['webservice'];

    function LogInController(webservice) {
        var vm = this;

/*        vm.submitItem = submitItem;

        vm.itemName = "";
        vm.itemPrice = 20;
        vm.itemColor = "asd";
        vm.itemSize = "M";
        vm.itemUsed = 0;
        vm.itemDescription = "";

        function submitItem() {
            var sendObj = {
                "name": vm.itemName,
                "price": vm.itemPrice,
                "color": vm.itemColor,
                "size": vm.itemSize,
                "used": vm.itemUsed,
                "description": vm.itemDescription
            };
            webservice.call('/item/save_item', 'POST', sendObj).then(function (response) {
                console.log(response);
            });
        }*/


    }
})();
