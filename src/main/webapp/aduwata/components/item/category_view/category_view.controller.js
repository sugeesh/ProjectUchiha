/**
 * Created by Buddhi on 4/22/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('CategoryViewController', CategoryViewController);

    CategoryViewController.$inject = ['webservice'];

    function CategoryViewController(webservice) {
        var vm = this;

        loadRecentItems();

        function loadRecentItems() {
            var search = "";
            var size = 10;
            var page = 0;
            var column = "name";
            var asc = "true";

            var url = "/item" + "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                var il = response.data.dataRows;
                vm.itemList = il.slice(0, 4);
                console.log(response.data.dataRows);
            });
        }
    }
})();