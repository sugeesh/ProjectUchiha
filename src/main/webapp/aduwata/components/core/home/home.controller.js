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

        vm.districts = ["Colombo","Kandy","Galle","Ampara","Anuradhapura","Badulla","Batticaloa",
            "Gampaha","Hambantota","Jaffna","Kalutara","Kegalle","Kilinochchi","Kurunegala",
            "Mannar","Matale","Matara","Moneragala","Mullativu","Nuwara Eliya","Polonnaruwa",
            "Puttalam","Ratnapura","Trincomalee","Vavuniya"];

        // $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|ftp|blob):|data:image\//);

        // vm.routeToCategory = routeToCategory;
        // vm.routeToSearch = routeToSearch;

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
            var search = "";


            var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                var il = response.data.dataRows;
                vm.vehicleList = il.slice(0, 6);


            });

            var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                var il = response.data.dataRows;
                vm.electronicList = il.slice(0, 6);


            });



            // var url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            // webservice.call(url, 'GET').then(function (response) {
            //     vm.vehicleList = response.data.dataRows;
            // });
            //
            // id = 2;
            // url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            // webservice.call(url, 'GET').then(function (response) {
            //     vm.electronicsList = response.data.dataRows;
            // });
            //
            // id = 3;
            // url = "/item/get_items_by_category"+ "?" + "id=" + id + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            // webservice.call(url, 'GET').then(function (response) {
            //     vm.propertyList = response.data.dataRows;
            // });

        }

        vm.routeToView = function routeToView(id) {
            $state.go("view", {'id': id});
            jQuery('html, body').animate({ scrollTop: 400 }, 200);
        }


        function routeToCategory(id,name) {
            $state.go("category", {'id': id,'name':name});
        }


    }

})();
