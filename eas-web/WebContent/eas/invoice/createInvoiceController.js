var app = angular.module("InvoiceModule", ['restangular']);
		
		app.controller("invoiceCtrl", function($scope,$q,$window, Restangular){

			$scope.products = [];		
			//$scope.autoProducts = [];	
			//$scope.productField = [];
			
			//get one product by id and insert a row on table
	    	$scope.addRow = function(productId, number) {	    		
	    		var check = false;
	    		angular.forEach($scope.products,function(pro){
		            if(pro.prId==productId){
		            	$window.alert("Mặt hàng này đã có trong hóa đơn!");
		            	check = true;		            	
		            }else{
		            	check = false;
		            }
	        	}); 
	    	
	    		// get all available data
//	    		$scope.getAllProduct = function() {
//	    			Restangular.all("eas-service/intern05Product/intern05Product").getList().then(function(result) {	 
//	    				$scope.productField = result;
//	    				console.log($scope.productField);
//	    				//console.log($scope.cityField);
//	    				$scope.autoProducts = $scope.cityField.map(function (product) {
//	    					return {
//	    						value: product.toLowerCase(),
//	    						display: product
//	    					};
//	    					console.log($scope.autoProducts);
//	    				});
//	    				//console.log($scope.cities);
//	    			});
//	    		}
//	    		
//	    		
//	    		$scope.createFilterFor = function(query) {
//	    			var lowercaseQuery = angular.lowercase(query);
//	    			return function filterFn(state) {
//	    				return (state.value.indexOf(lowercaseQuery) === 0);
//	    			};
//	    		}
//	    		
////	    		
//	    		querySearchPRODUCT = function(query)  {
//	    			var results = query ? $scope.autoProducts.filter(createFilterFor(query)) : $scope.autoProducts,
//	    				deferred;
//	    			if ($scope.simulateQuery) {
//	    				deferred = $q.defer();
//	    				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
//	    				return deferred.promise;
//	    			} else {
//	    				return results;
//	    			}
//	    		}
	    		
	    		

	    	if(check!=true){
	    		var prUrl = "eas-service/intern05Product/intern05Product/"+productId;	    		
	    		Restangular.one(prUrl).get().then(function(data) {	    				    				    			  				    			    			
	    			if(data.quantity  < number){
	    				$window.alert("Quá số lượng hàng hiện có, chỉ còn "+data.quantity+" sản phẩm");
	    			}else{
	    				$scope.products.push({
	    						   'prId': productId, 
	    						   'prName': data.prName,
	    						   'price': data.price,
	    						   'prUnit': data.prUnit,
	    						   'quantity': data.quantity,
	    						   'discountRate': data.discountRate,
	    						   'prDescription': data.prDescription,
		  						   'prDigitalproduct': data.prDigitalproduct,
		  						   'productCategoryId': data.productCategoryId,
	    						   'number': number
	    							});	    				    						
	    			}	    	
	    	    }
	    		,function(responseError){
	    			if(responseError.status==400){
	    				$window.alert("Mã hàng không tồn tại!");
	    			}
	    		}
	    		); 
	    	}
	    		
	    	}  
	    	
	    	//calculate total amount money    	
	    	    	    	
	    	$scope.calculateMoney = function () {	 
	    		$scope.totalAmount = 0;	
	    		if($scope.products.length < 1){
	    			$window.alert("Chưa có mặt hàng nào trong hóa đơn");
	    		}else{
	    			angular.forEach($scope.products,function(pro){
		    			 $scope.totalAmount = $scope.totalAmount + pro.price*(1-pro.discountRate)*pro.number;			    			
			        });	   
	    		}	 
	    		
	    		return $scope.totalAmount;
			}
	    	
	    	
	    	$scope.printInvoice = function () {
				$window.alert("Đang phát triển!")
			}
	    		    	
   	
	    	//insert invoice, invoiceDetails and update quantity of products
	    	$scope.saveInvoice = function() {			    		
	    			console.log($scope.calculateMoney());
	    			if($scope.calculateMoney()>0){
	    				var date = new Date();
			    		var object = {						  
								   'customerName': $scope.customerName,
								   'customerAddress': $scope.customerAddress,
								   'customerPhone': $scope.customerPhone,
								   'invoiceDate': date,
								   'totalAmount': $scope.totalAmount,
								   'employeeId': 4
									}
				    							    		
			    		Restangular.all("eas-service/intern05Invoice/intern05Invoice/").post(object).then(function(data) {
			    			console.log(data);		    			    			
			    			//insert invoiceDeatails
			    			var lines = [];	    			
				    		angular.forEach($scope.products,function(pro){
				    			//console.log(pro.prId);
				    			lines.push({						  
											   'invoiceId': data,
											   'productId': pro.prId,
											   'unitPrice':pro.price,
											   'quantity': pro.number,
											   'discountRate':pro.discountRate
												})
				        	});   
				    		//console.log("bat dau goi rest them invoiceDetail");
			    			Restangular.all("eas-service/intern05InvoiceDetail/intern05InvoiceDetail/").post(lines).then(function (){
			    				console.log("da goi rest them invoiceDetail");
			    				//update quantity of product
			    				var newProducts = [];
					    		angular.forEach($scope.products,function(pro){
					    			var quantity = pro.quantity - pro.number;		    					    			
					    			newProducts.push({		
					    					   'prId': pro.prId,
					  						   'prName': pro.prName,
					  						   'price': pro.price,
					  						   'prUnit': pro.prUnit,
					  						   'quantity': quantity,
					  						   'discountRate': pro.discountRate,
					  						   'prDescription': pro.prDescription,
					  						   'prDigitalproduct': pro.prDigitalproduct,
					  						   'productCategoryId': pro.productCategoryId,
												})
					        	});  
					    		//console.log(newProducts);
					    		console.log("bat dau goi rest update san pham");
					    		Restangular.all("eas-service/intern05Product/intern05Product/").customPUT(newProducts).then(function (){
									console.log("ket thuc goi rest update san pham");
									$window.alert("Lưu hóa đơn thành công!")
									}, function(responseError){
						    			if(responseError.status){
						    				$window.alert("Lỗi khi update số lượng sản phẩm");
						    			}
						    		}
					    		);
					    		
							},function(responseError){
				    			if(responseError.status){
				    				$window.alert("Lỗi khi thêm chi tiết hóa đơn");
				    			}
				    		}
			    			)		    					    			    			
				    	},function(responseError){
			    			if(responseError.status){
			    				$window.alert("Lỗi khi thêm hóa đơn");
			    			}
			    		}
			    		);	    				    
	    			}		    			
	    	}  			
	    
	    					
    	
			//show form addProduct
	       $scope.formAddProduct = false;
	       $scope.showForm= function() {	              
	       		$scope.formAddProduct = $scope.formAddProduct ? false : true;
	       }

			//remove rows are selected
			$scope.removeRow = function(){
				if($scope.products.length < 1){
	    			$window.alert("Chưa có mặt hàng nào để xóa");
	    		}else{
	    			var newProductList=[];
		            angular.forEach($scope.products,function(pro){
			            if(!pro.isSelected){
			            	newProductList.push(pro);
			            }
		        	}); 
		            
		            if($scope.products.length==newProductList.length){
		            	$window.alert("Hãy chọn 1 hay nhiều mặt hàng để xóa!");	
		            }else{
		            	$scope.products = newProductList;		           		
		            }	  	    			
	    		}	                     
	        };	          
		});