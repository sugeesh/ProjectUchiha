/**
 * Created by Buddhi on 3/19/2017.
 */
(function () {
    'use strict';

    angular.module('aduwata').directive("fileread", [function () {
        return {
            scope: {
                fileread: "="
            },
            link: function (scope, element, attributes) {
                element.bind("change", function (changeEvent) {
                    var reader = new FileReader();
                    reader.onload = function (loadEvent) {
                        scope.$apply(function () {
                            scope.fileread = loadEvent.target.result;
                        });
                    };
                    reader.readAsDataURL(changeEvent.target.files[0]);
                });
            }
        }
    }]).controller('ItemController', ItemController);

    ItemController.$inject = ['webservice'];

    function ItemController(webservice) {
        var vm = this;

        vm.submitItem = submitItem;

        vm.itemName = "";
        vm.itemPrice = 20;
        vm.itemColor = "asd";
        vm.itemSize = "M";
        vm.itemUsed = 0;
        vm.itemDescription = "";
        vm.uploadFile = null;

        function submitItem() {
            console.log("Come to here.");
            var sendObj = {
                "name": vm.itemName,
                "price": vm.itemPrice,
                "color": vm.itemColor,
                "size": vm.itemSize,
                "used": vm.itemUsed,
                "description": vm.itemDescription
            };

            // formData.append("file",vm.uploadFile);

            console.log("Come to here. 2");
            webservice.call('/item/save_item', 'POST', sendObj).then(function (response) {
                console.log(response);
                console.log("Come to here. 3");
                vm.hiddenId = response.data.itemId;


                var form = document.getElementById('form-id');
                form.action = 'http://localhost:8080/rest/item/save_image?id='+vm.hiddenId;
                form.submit();

                // var formData = new FormData(form);
                /*var request = new XMLHttpRequest();
                var boundary=Math.random().toString().substr(2);
                request.open('POST', '/item/save_image');
                request.setRequestHeader("content-type",
                    "multipart/form-data; charset=utf-8; boundary=" + boundary);
                request.send(formData);*/

            });
        }


    }
})();
