/**
 * Created by Buddhi on 3/15/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['webservice', '$state'];

    function HomeController(webservice, $state) {
        var vm = this;
        vm.im1 = null;

        vm.searchText = "";
        vm.districts = ["Colombo","Kandy","Galle","Ampara","Anuradhapura","Badulla","Batticaloa",
            "Gampaha","Hambantota","Jaffna","Kalutara","Kegalle","Kilinochchi","Kurunegala",
            "Mannar","Matale","Matara","Moneragala","Mullativu","Nuwara Eliya","Polonnaruwa",
            "Puttalam","Ratnapura","Trincomalee","Vavuniya"];
        console.log("Home Controller");

        // $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|ftp|blob):|data:image\//);

        vm.routeToCategory = routeToCategory;
        vm.routeToSearch = routeToSearch;

        vm.vehicleList = [];
        vm.electronicsList = [];
        vm.propertyList = [];

        loadRecentItems();


        function loadRecentItems() {
            var id = 1;
            var size = 4;
            var page = 0;
            var column = "Date";
            var asc = "false";

            /*var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                var il = response.data.dataRows;
                vm.itemList = il.slice(0, 4);
                console.log(response.data.dataRows);
            });*/

            var url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.vehicleList = response.data.dataRows;
            });

            id = 2;
            url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.electronicsList = response.data.dataRows;
            });

            id = 3;
            url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.propertyList = response.data.dataRows;
            });

        }

        function routeToSearch() {
            $state.go("search_item", {'search': vm.searchText});
        }


        function routeToCategory(id,name) {
            $state.go("category_view", {'id': id,'name':name});
        }


    }

})();
