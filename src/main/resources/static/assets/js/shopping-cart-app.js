const app = angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl",function($scope,$http){ 
    $scope.cart={
        items:[],
        // thêm sản phẩm vào giỏ hàng
        add(id){
            var item = this.items.find(item => item.id ==id);
            if(item){
                item.qty++;
                this.saveToLocalStorage();
            }else{
                $http.get(`/rest/products/${id}`).then(resp =>{
                    resp.data.qty =1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        // xóa từng sản phẩm trong giỏ hàng
        remove(id){
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        // xóa hết sản phẩm trong giỏ hàng
        clear(){
            this.items=[];
            this.saveToLocalStorage();
        },
        // tiền 1 sản phẩm
        amt_of(item){},
        
        
        // số lượng hàng trong giỏ
        get count(){
            return this.items
            .map(item => item.qty)
            .reduce((total,qty) => total += qty,0);
        },
        // thành tiền
        get amout(){
            return this.items
            .map(item => item.qty * item.price -(item.qty * item.price * item.discount/100))
            .reduce((total,qty) => total += qty,0);
        },
        // lưu giỏ hàng
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        // load giỏ hàng
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) :[];
        }
    }

    $scope.cart.loadFromLocalStorage();

    $scope.order ={
        createDate: new Date(),
        address: "",
        account:{userName: $("#username").text()},
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return {
                    product: {id: item.id},
                    price: item.price,
					discount : item.discount,	
                    quantity: item.qty
                }
            });
        },
        purchase(){
           var order = angular.copy(this);
           // Đặt hàng
           $http.post("/rest/orders", order).then(resp =>{
               alert("Đặt hàng thành công!");
               $scope.cart.clear();
               location.href="/order/detail/" + resp.data.id;
           }).catch(error =>{
               alert("Quý khách vui lòng đăng nhập để đặt hàng!")
               console.log(error, order)
           })
        }
    }
})
