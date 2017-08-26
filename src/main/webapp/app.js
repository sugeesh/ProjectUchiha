(function () {
    'use strict';

    angular.module('aduwata', [
        'ui.router', 'angular-cloudinary', 'ngCookies','flow'
    ]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider', 'cloudinaryProvider',
        function ($stateProvider, $urlRouterProvider, $httpProvider, cloudinaryProvider) {

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
                        templateUrl: 'aduwata/components/core/home/home.html',
                        controller: 'HomeController',
                        controllerAs: 'vm'
                    }
                }
            }).state('about', {
                parent: 'default',
                url: '/about',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/core/about/about.html',
                        controller: 'AboutController',
                        controllerAs: 'vm'
                    }
                }
            }).state('new_user', {
                parent: 'default',
                url: '/new_user',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/user/register/register.html',
                        controller: 'UserRegisterController',
                        controllerAs: 'vm'
                    }
                }
            }).state('view', {
                parent: 'default',
                url: '/view/:id',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/advertisement/view/view_advertisement.html',
                        controller: 'ViewItemController',
                        controllerAs: 'vm'
                    }
                }
            }).state('new_item', {
                parent: 'default',
                url: '/new_item',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/advertisement/add/add_advertisement.html',
                        controller: 'ItemController',
                        controllerAs: 'vm'
                    }
                }
            }).state('search', {
                parent: 'default',
                url: '/search/:search',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/advertisement/search/search_advertisement.html',
                        controller: 'SearchItemController',
                        controllerAs: 'vm'
                    }
                }
            }).state('category', {
                parent: 'default',
                url: '/category/:name/:id',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/category/category_view.html',
                        controller: 'CategoryViewController',
                        controllerAs: 'vm'
                    }
                }
            }).state('404', {
                parent: 'default',
                url: '/404',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/core/404/404.html',
                        controller: 'NotFoundController',
                        controllerAs: 'vm'
                    }
                }
            }).state('login', {
                url: '/login',
                views: {
                    "body@": {
                        templateUrl: 'aduwata/components/core/login/login.html',
                        controller: 'LogInController',
                        controllerAs: 'vm'
                    }
                }
            });

            // $locationProvider.html5Mode(true);
            $urlRouterProvider.otherwise('/404');


            /*This is for the cpagesloudinary image service*/
            cloudinaryProvider.config({
                upload_endpoint: 'https://api.cloudinary.com/v1_1/', // default
                cloud_name: 'sugeesh' // required
                // upload_preset: 'my_preset', // optional
            });


        }]);
})();
