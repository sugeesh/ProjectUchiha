/**
 * Created by Buddhi on 3/19/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata').controller('ItemController', ItemController);

    ItemController.$inject = ['webservice','$state','Upload'];

    function ItemController(webservice,$state,Upload) {
        var vm = this;

        vm.submitItem = submitItem;

        vm.itemName = "";
        vm.itemPrice = 0;
        vm.itemColor = "asd";
        vm.itemSize = "M";
        vm.itemUsed = 0;
        vm.itemDescription = "";
        vm.uploadFile = null;
        vm.dataValues = {};
        vm.detailsDataList = {};


        vm.changeSubCategory = changeSubCategory;
        vm.changeItemDetails = changeItemDetails;
        vm.changeDetailList0Values = changeDetailList0Values;

        vm.districts = ["Colombo", "Kandy", "Galle", "Ampara", "Anuradhapura", "Badulla", "Batticaloa",
            "Gampaha", "Hambantota", "Jaffna", "Kalutara", "Kegalle", "Kilinochchi", "Kurunegala",
            "Mannar", "Matale", "Matara", "Moneragala", "Mullativu", "Nuwara Eliya", "Polonnaruwa",
            "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"];


        initCategoriesWithSubCategories();

        function submitItem() {

            var sendObj = {
                "district":vm.district,
                "category_id": vm.selectedCategory.category_id,
                "subCategory_id": vm.selectedSubCategory.id,
                "title": vm.title,
                "description": vm.description,
                "price": vm.price,
                "contact": vm.contact,
                "details":vm.detailsDataList
            };

            webservice.call('/item/save_advertisement', 'POST', sendObj).then(function (response) {
                var adId = response.data.advertisement_id;
                uploadPic(vm.mainFile,"item_images",adId+"_0","jpg")
                var i = 1;
                angular.forEach(vm.files, function(file) {
                    uploadPic(file,"item_images",adId+"_"+i,"jpg");
                    i++;
                });

                $state.go("home",{}, { reload: true });
            });

        }

        function initCategoriesWithSubCategories() {
            var search = "";
            var size = 10;
            var page = 0;
            var column = "Name";
            var asc = "false";

            var url = "/category" + "?" + "search=" + search + "&size=" + size + "&page=" + page + "&column=" + column + "&asc=" + asc;
            webservice.call(url, 'GET').then(function (response) {
                vm.categoryList = response.data.dataRows;
            });
        }

        function changeSubCategory() {
            vm.subCategoryList = vm.selectedCategory.subCategoryList;
        }

        function changeItemDetails() {
            if (vm.selectedSubCategory != null) {
                vm.subCategoryDetailList = vm.selectedSubCategory.scdetailList;
            }
        }

        function changeDetailList0Values(name,value) {
            vm.detailsDataList[name] = value;
        }

        function uploadPic(picFile,folder,fileName,type) {
                Upload.upload({
                    url: 'http://aduwata.s3.amazonaws.com', //S3 upload url including bucket name
                    method: 'POST',
                    data: {
                        key: folder+"/"+fileName+"."+type, // the key to store the file on S3, could be file name or customized
                        AWSAccessKeyId: "AKIAJ3SX6Z7PRHCPUHKA",
                        acl: "public-read", // sets the access to the uploaded file in the bucket: private, public-read, ...
                        policy: "ewogICJleHBpcmF0aW9uIjogIjIwMjAtMDEtMDFUMDA6MDA6MDBaIiwKICAiY29uZGl0aW9ucyI6IFsKICAgIHsiYnVja2V0IjogImFkdXdhdGEifSwKICAgIFsic3RhcnRzLXdpdGgiLCAiJGtleSIsICIiXSwKICAgIHsiYWNsIjogInB1YmxpYy1yZWFkIn0sCiAgICBbInN0YXJ0cy13aXRoIiwgIiRDb250ZW50LVR5cGUiLCAiIl0sCiAgICBbImNvbnRlbnQtbGVuZ3RoLXJhbmdlIiwgMCwgNTI0Mjg4MDAwXQogIF0KfQ==", // base64-encoded json policy (see article below)
                        signature: "tn/Wz9JKx7ACJmOSBOyzPRaGFQA=", // base64-encoded signature based on policy string (see article below)
                        "Content-Type": picFile.type != '' ? picFile.type : 'application/octet-stream', // content type of the file (NotEmpty)
                        file: picFile
                    }
                });
        };

    }
})();
