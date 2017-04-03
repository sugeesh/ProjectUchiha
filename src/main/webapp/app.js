(function () {
    'use strict';

    angular.module('aduwata', [
        'ui.router'
    ]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        $stateProvider.state('home', {
            url: '/home',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/pages/home/home.html',
                    controller: 'HomeController',
                    controllerAs: 'vm'
                }
            }
        }).state('about', {
            url: '/about',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/pages/about/about.html',
                    controller: 'AboutController',
                    controllerAs: 'vm'
                }
            }
        }).state('new_user', {
            url: '/new_user',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/user/register_user/register.html',
                    controller: 'UserRegisterController',
                    controllerAs: 'vm'
                }
            }
        }).state('new_item', {
            url: '/new_item',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/item/add_item/add_item.html',
                    controller: 'ItemController',
                    controllerAs: 'vm'
                }
            }
        }).state('login', {
            url: '/login',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/pages/login/login.html',
                    controller: 'LogInController',
                    controllerAs: 'vm'
                }
            }
        }).state('404', {
            url: '/404',
            views: {
                "layout": {
                    templateUrl: 'aduwata/components/core/404/404.html',
                    controller: 'NotFoundController',
                    controllerAs: 'vm'
                }
            }
        });

        $urlRouterProvider.otherwise('/404');
    }]);
})();
