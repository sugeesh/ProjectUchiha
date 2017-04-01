(function () {
    'use strict';

    angular.module('aduwata', [
        'ui.router'
    ]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        $stateProvider.state('home', {
            url: '/home',
            views: {
                "layout": {
                    templateUrl: 'aduwata/main/home/home.html',
                    controller: 'HomeController',
                    controllerAs: 'vm'
                }
            }
        }).state('about', {
            url: '/about',
            views: {
                "layout": {
                    templateUrl: 'aduwata/main/about/about.html',
                    controller: 'AboutController',
                    controllerAs: 'vm'
                }
            }
        }).state('new_item', {
            url: '/new_item',
            views: {
                "layout": {
                    templateUrl: 'aduwata/sell/add-item/add-item.html',
                    controller: 'ItemController',
                    controllerAs: 'vm'
                }
            }
        }).state('404', {
            url: '/404',
            views: {
                "layout": {
                    templateUrl: 'aduwata/core/404/404.html',
                    controller: 'NotFoundController',
                    controllerAs: 'vm'
                }
            }
        });

        $urlRouterProvider.otherwise('/404');
    }]);
})();
