/**
 * Created by Buddhi on 3/15/2017.
 */

(function () {
    'use strict';

    angular.module('aduwata')
        .service('webservice', webservice);

    webservice.$inject = ['$http', '$q'];

    function webservice($http, $q) {
        var service = {
            call: call
        };
        return service;

        function call(url, method, data) {
            console.log(url);

            url = 'http://localhost:8080/rest' + url;

            console.log(url);
            var obj = {};

            var promises = [];
            if (method == "GET") {
                // promises.push($http.get(url));
                promises.push($http({
                    method: "GET",
                    url: url
                }));
            } else if (method == "POST") {
                // promises.push($http.post(url, data));
                promises.push($http({
                    method: "POST",
                    headers: {'Content-Type': 'multipart/form-data'},
                    url: url,
                    data: data
                }));
            } else if (method == "DELETE") {
                promises.push($http({
                    method: "DELETE",
                    url: url+data
                }));
                // promises.push($http.delete(url + data));
            } else if (method == "PUT") {
                promises.push($http({
                    method: "PUT",
                    url: url,
                    data: data
                }));
                // promises.push($http.put(url, data));
            }

            return $q.all(promises).then(function (response) {
                    obj = response[0];
                    console.log("Response :" + obj.data);
                    var deferred = $q.defer();
                    deferred.resolve(obj);
                    return deferred.promise;
                }, function (error) {
                    //This will be called if $q.all finds any of the requests erroring.
                    console.log("There is an error: " + error);
                    console.log(error);
                }
            );

        }

    }
})();

