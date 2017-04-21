(function () {
    'use strict';

    angular.module('aduwata', [
        'ui.router'
    ]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        $stateProvider.state('default', {
            url: '',
            views: {
                "body@": {
                    templateUrl: 'aduwata/components/core/body.html',
                    controller: 'BodyController',
                    controllerAs: 'vm'
                },
                "sidebar": {
                    templateUrl: 'aduwata/components/core/sidebar.html',
                    controller: 'SidebarController',
                    controllerAs: 'vm'
                }
            }
        }).state('home', {
            parent: 'default',
            url: '/home',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/pages/home/home.html',
                    controller: 'HomeController',
                    controllerAs: 'vm'
                }
            }
        }).state('about', {
            url: '/about',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/pages/about/about.html',
                    controller: 'AboutController',
                    controllerAs: 'vm'
                }
            }
        }).state('new_user', {
            parent: 'default',
            url: '/new_user',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/user/register_user/register.html',
                    controller: 'UserRegisterController',
                    controllerAs: 'vm'
                }
            }
        }).state('new_item', {
            parent: 'default',
            url: '/new_item',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/item/add_item/add_item.html',
                    controller: 'ItemController',
                    controllerAs: 'vm'
                }
            }
        }).state('login', {
            url: '/login',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/pages/login/login.html',
                    controller: 'LogInController',
                    controllerAs: 'vm'
                }
            }
        }).state('404', {
            url: '/404',
            views: {
                "view@default": {
                    templateUrl: 'aduwata/components/core/404/404.html',
                    controller: 'NotFoundController',
                    controllerAs: 'vm'
                }
            }
        });

        $urlRouterProvider.otherwise('/404');
    }]);
})();
