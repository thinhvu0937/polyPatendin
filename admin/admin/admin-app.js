app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
    .when("/product",{
        templateUrl: "/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/authorize",{
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("unauthorized",{
        templateUrl: "/assets/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
        .when("/donhang",{
        templateUrl: "/assets/admin/order/index.html", 
    })
		.when("/khohang",{
        templateUrl: "/assets/admin/warehouse/index.html",
    })
    	.when("/thongke",{
        templateUrl: "/assets/admin/statistical/index.html",
    })
    .when("/congthuc",{
        templateUrl: "/assets/admin/recipe/index.html",
    })
    .when("/tintuc",{
        templateUrl: "/assets/admin/news/index.html",
    })
        .when("/tongquan",{
        templateUrl: "/assets/admin/overview/tongquan.html",
    })
            .when("/taikhoan",{
        templateUrl: "/assets/admin/account/index.html",
    })
                    .when("/khuyenmai",{
        templateUrl: "/assets/admin/promotion/index.html",
    })
                    .when("/lienhe",{
        templateUrl: "/assets/admin/contact/index.html",
    })    
    .otherwise({
        template: "<h1 class='text-center'>FPT Polytechnic Administration</h1>"
    });
})