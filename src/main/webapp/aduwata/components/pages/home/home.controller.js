/**
 * Created by Buddhi on 3/15/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['webservice'];

    function HomeController(webservice) {
        var vm = this;

        vm.searchText = "";
        vm.districts = ["Colombo","Kandy","Galle","Ampara","Anuradhapura","Badulla","Batticaloa",
            "Gampaha","Hambantota","Jaffna","Kalutara","Kegalle","Kilinochchi","Kurunegala",
            "Mannar","Matale","Matara","Moneragala","Mullativu","Nuwara Eliya","Polonnaruwa",
            "Puttalam","Ratnapura","Trincomalee","Vavuniya"];
        console.log("Home Controller");

        vm.searchItems = searchItems;
        loadRecentItems();


        function loadRecentItems() {
            var search = "";
            var size = 10;
            var page = 0;
            var column = "name";
            var asc = "true";

            var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.itemList = response.data.dataRows;
                console.log(response.data.dataRows);
            });
        }


        function searchItems() {
            var search = vm.searchText;
            var size = 10;
            var page = 0;
            var column = "name";
            var asc = "true";

            var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.itemList = response.data.dataRows;
                console.log(response.data.dataRows);
            });
        }
    }

})();
