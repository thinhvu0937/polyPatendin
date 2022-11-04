app.controller("lienhe-ctrl",function($scope,$http){
   $scope.items = [];
   $scope.form = {};
   $scope.cates = [];
   $scope.initialize= function(){
       //load products
       $http.get("/rest/lienhe").then(resp =>{
           $scope.items = resp.data;
           $scope.items.forEach(item =>{
               item.createDate= new Date(item.createDate);
           })
       });


   //khởi đầu
   $scope.initialize();

   

   //Hiển thị lên form
   $scope.edit = function(item){
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab('show')
   }

   //Thêm sản phẩm mới
   $scope.create= function(){
   alert("hahaha")
       var item = angular.copy($scope.form);
       $http.post(`/rest/lienhe`,item).then(resp =>{
           resp.data.createDate= new Date(resp.data.createDate)
           $scope.items.push(resp.data);
           $scope.reset();
           alert("Thêm mới sản phẩm thành công");
           
       }).catch(error =>{
           alert("Lỗi thêm mới sản phẩm");
           console.log("Error",error);
       })
   }
   }
});