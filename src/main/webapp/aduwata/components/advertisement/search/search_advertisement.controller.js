/**
 * Created by Buddhi on 4/22/2017.
 */

/**
 * Created by Buddhi on 3/19/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('SearchItemController', SearchItemController);

    SearchItemController.$inject = ['webservice','$stateParams'];

    function SearchItemController(webservice, $stateParams) {
        var vm = this;

        searchItems($stateParams.search);

        function searchItems(search) {
            var search = search;
            var size = 10;
            var page = 0;
            var column = "name";
            var asc = "true";

            var url = "/advertisement"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.itemList = response.data.dataRows;
            });

        }

    }
})();

