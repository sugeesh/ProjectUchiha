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
        vm.im1 = null;

        vm.searchText = "";
        vm.districts = ["Colombo","Kandy","Galle","Ampara","Anuradhapura","Badulla","Batticaloa",
            "Gampaha","Hambantota","Jaffna","Kalutara","Kegalle","Kilinochchi","Kurunegala",
            "Mannar","Matale","Matara","Moneragala","Mullativu","Nuwara Eliya","Polonnaruwa",
            "Puttalam","Ratnapura","Trincomalee","Vavuniya"];
        console.log("Home Controller");

        // $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|ftp|blob):|data:image\//);
        vm.searchItems = searchItems;
        vm.loadImage = loadImage;

        loadRecentItems();


        function loadRecentItems() {
            var search = "";
            var size = 10;
            var page = 0;
            var column = "name";
            var asc = "true";

            var url = "/item"+ "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                var il = response.data.dataRows;
                vm.itemList = il.slice(0, 4);
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
            // vm.loadImage();
        }

        function loadImage() {
            var result ;
            var url = "/item/image/1";
            console.log("This is path")
            webservice.call(url, 'GET').then(function (response) {
               var b64 = utf8_to_b64(response.data);

                var dataUri = 'data:image/png;base64,' + b64;

                // vm.im1 = " data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGcAAABnCAMAAAAqn6zLAAAAYFBMVEX///8douIAnOAAnuEAmuAUoOIAlt83qOTs9vzx+f33/P7a7/rN5/fg8vu43PPj8vtEreWf0fB6wOux2fJvvOnE4/ZTsuan1PGUzu/U6vhjtueKxu1TsOd/w+uJyOy74PSE1u4iAAACz0lEQVRoge2Y24KCIBBAZYDFS3lPy7T+/y8XrTZvwMDWG6dHlNPADBeDwOPxeDwej8ejJKzKnHCSl1X4RUtSU+Bk+gGtL3P/+XOWaJCSN5wO8bMlu7EW1cW9Nj+TCSBLQBzHhlPNgcSm1ycadjNqFsG8Qjq0HZcNUKE0CSWs0D8S0o1lCmmy0w6lCQo5IqAX9dto3mHluFEL6rET0A1du56beUx5JJMkRWRcPj1P1ckQqS2ElHGW1oRHRk0sHoNCc1XxVZpwRCdkKkBiDif+G2h+33+i0c0Ol40/J7NGxvP3Eqv3wlck21sFKUKz+LuU7JTChek9FKcJhvmwQH9Yt1daDyebFxSki3Hh0KymSZfVhCizZ0O4mma5XhXzl7UeQ4EvKNcTzYH1bfZq1qW1lee4k7ccQG5nSRQb8sDGE5z3/7EMi4umLjXlY+fRVeJUiBoPbot7EhNtZzqPYg3ZEglZZ3HuKIKL2fCMhTLo2lPu5qH4k4+YsstNw5FHg5HadW5GT4/WGNYVPfSK96zXHRvw6RbsrDt4uM0BONOXok7TWGgeJysnqOXBunMUYc4fC3InEc8tNWNEDnNErRbRBy23N1H8YvAmvBJLEx3sLePBLUobKw843B5L0fe5MPc9D6e01wQHxrnlZmexJczobLMA3C6/ie0iJ1ySLbDeHgBzR9hlMJzXlxqHnH5xxYu466hNVOhChczcm4ZwkKsPwsWcJ+dFVjSEmkx2h1BlUNlZL3KsnA2FXsM+ozlsvhitNFY3BBWXzpDcyMu1FrkxGDKbCuytV0mWloTpLZx15u8r+1Rterqnxa0R5srZ/bqApYAfAGosmTGY0jWYifjMEVsCh8b2rLY1FYIZbqG0/LdlMp1q5WGHA+2Lz32vDtNSyImaxyWv2vKe1xUfCWVGfExvHYGfJ0Caob38Z58x6MJjkhzD7wk8Ho/H4/F4vskv85seTaRFgsUAAAAASUVORK5CYII=";

                vm.im1 = dataUri;

                console.log(dataUri);
                console.log("\n REAL :"+vm.im1);
                // result = response;
                // console.log(response.data.dataRows);
            });
            return result;
        }

        function utf8_to_b64( str ) {
            return window.btoa(unescape(encodeURIComponent( str )));
        }


    }

})();
