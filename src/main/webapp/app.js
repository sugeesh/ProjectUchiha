(function () {
    'use strict';

    angular.module('aduwata', [
        'ui.router', 'angular-cloudinary'
    ]).config(['$stateProvider', '$urlRouterProvider', '$httpProvider','cloudinaryProvider',
        function ($stateProvider, $urlRouterProvider, $httpProvider,cloudinaryProvider) {

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
            }).state('view_item', {
                parent: 'default',
                url: '/view_item',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/item/view_item/view_item.html',
                        controller: 'ViewItemController',
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
            }).state('search_item', {
                parent: 'default',
                url: '/search_item/:search',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/item/search_item/search_item.html',
                        controller: 'SearchItemController',
                        controllerAs: 'vm'
                    }
                }
            }).state('category_view', {
                parent: 'default',
                url: '/category/:id/:name',
                views: {
                    "view@default": {
                        templateUrl: 'aduwata/components/item/category_view/category_view.html',
                        controller: 'CategoryViewController',
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



            /*This is for the cloudinary image service*/
            cloudinaryProvider.config({
                upload_endpoint: 'https://api.cloudinary.com/v1_1/', // default
                cloud_name: 'sugeesh' // required
                // upload_preset: 'my_preset', // optional
            });


        }]);
})();
