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
                    }
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
            var sendObj = {
                "name": vm.itemName,
                "price": vm.itemPrice,
                "color": vm.itemColor,
                "size": vm.itemSize,
                "used": vm.itemUsed,
                "description": vm.itemDescription
            };
            var form = document.getElementById('form-id');
            var formData = new FormData(form);
            // formData.append("file",vm.uploadFile);

            webservice.call('/item/save_item', 'POST', sendObj).then(function (response) {
                console.log(response);

                var request = new XMLHttpRequest();
                request.open('POST', '/item/save_image');
                request.send(formData);
              /*
                webservice.call('/item/save_image', 'POST', formData,true).then(function (response) {

                });*/

                /*sendObj.itemId = response.data.itemId;
                sendObj.image = vm.uploadFile;
*/
                /*var file = {file:vm.uploadFile};
                var url = "/item/image/8";
                webservice.call(url, 'POST', vm.uploadFile,true).then(function (response) {
                    alert("Item Saved Successfully");
                });*/
            });
        }


    }
})();
