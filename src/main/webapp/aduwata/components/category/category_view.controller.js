/**
 * Created by Buddhi on 4/22/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('CategoryViewController', CategoryViewController);

    CategoryViewController.$inject = ['webservice', '$stateParams', '$state'];

    function CategoryViewController(webservice, $stateParams, $state) {
        var vm = this;

        vm.categoryName = $stateParams.name;
        vm.routeToCategory = routeToCategory;

        loadRecentItems();


        function loadRecentItems() {
            var id = $stateParams.id;
            var size = 100;
            var page = 0;
            var column = "Date";
            var asc = "false";

            var url = "/item/get_items_by_category" + "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.itemList = response.data.dataRows;
            });
        }

        function routeToCategory(id, name) {
            $state.go("category", {'id': id, 'name': name});
        }

    }
})();