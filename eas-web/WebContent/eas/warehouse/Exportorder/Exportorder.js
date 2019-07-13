	/**
 * 
 */
var app = angular.module('MyApp', ['restangular', 'angularUtils.directives.dirPagination']);
app.config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('http://localhost:8084/eas-service/');
});

var imServiceBaseUrl = "intern05Importorder/";
var exServiceBaseUrl = "intern05Exportorder/";
var statisticsServiceBaseUrl = "intern05Statistics/";

var dateLocal = new Date;
var chonChucNang;

app.controller('myCtrl', function($scope, $filter, Restangular, $window, $timeout) {
	
//	return function(scope, iElement, iAttrs) {
//        iElement.autocomplete({
//            source: scope[iAttrs.uiItems],
//            select: function() {
//                $timeout(function() {
//                  iElement.trigger('input');
//                }, 0);
//            }
//        });
//};
    $scope.rowOnPage = function(){
    	
    }
	
	
    $scope.donvitinh = "VNĐ";
    
    // fill data
    Restangular.all(exServiceBaseUrl + 'getAllEX').getList().then(function(result) {
        $scope.exportorderList = result;
        // console.log($scope.exportorderList);
    });

    // fill all product data
    Restangular.all(statisticsServiceBaseUrl + 'getAllProduct').getList().then(function(result) {
        $scope.productList = result;
    });

    //change product <==> product category
    $scope.changePrcategory = function() {
        Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.prId).get().then(function(result) {
            $scope.prCList = result;
            $scope.addObj.prCategoryId = $scope.prCList.prCategoryId;
            //	        console.log($scope.prCategoryId);
        });
    }

    $scope.changeProduct = function() {
        Restangular.all(exServiceBaseUrl + 'getProductListByPrcId').get($scope.prCategoryId).then(function(result) {
            $scope.productList = result;
            // console.log($scope.productList);
        })
    }

    // delete
    $scope.deleteObj = function() {
        $scope.orderArray = [];
        // console.log($scope.orderArray);
        $scope.orderNumber = false;
        angular.forEach($scope.exportorderList, function(exOrder) {
            if (exOrder.selected)
                $scope.orderArray.push(exOrder);
        });

        if ($scope.orderArray.length == 0) {
            $scope.orderNumber = false;
            alert("Vui lòng chọn bản ghi để xóa");
        }
        // xóa 1
        if ($scope.orderArray.length == 1) {
            var x = confirm("Bạn có chắc chắn muốn xóa?");
            if (x == true) {
                Restangular.one(exServiceBaseUrl + 'delete', $scope.orderArray[0].exId).remove().then(function() {
                    $window.location.reload();
                });
            } else {
                alert("Hủy xóa thành công");
                $window.location.reload();
            }
        }
        // xóa nhiều
        if ($scope.orderArray.length > 1) {
            var x = confirm("Bạn có chắc chắn muốn xóa?");
            if (x == true) {
                for (var i = 0; i < $scope.orderArray.length; i++) {
                    Restangular.one(exServiceBaseUrl + 'delete', $scope.orderArray[i].exId).remove().then(function() {
                        $window.location.reload();
                    });
                }
            } else {
                alert("Hủy xóa thành công");
                $window.location.reload();
            }
        }
    }

    // view
    $scope.viewObj = function() {
            $scope.nhapHang = false;
            $scope.searchform = false;
            $scope.edit = false;
            $scope.viewArray = [];
            // console.log($scope.viewArray);
            $scope.view = false;
            angular.forEach($scope.exportorderList, function(exOrder) {
                if (exOrder.selected)
                    $scope.viewArray.push(exOrder);
            });

            if ($scope.viewArray.length == 0) {
                $scope.view = false;
                alert("Vui lòng chọn bản ghi");
            }

            if ($scope.viewArray.length == 1) {
                Restangular.one(exServiceBaseUrl + 'findById', $scope.viewArray[0].exId).get().then(function(result) {
                    $scope.viewObjex = result;
                    $scope.view = true;
                })
            }

            if ($scope.viewArray.length > 1) {
                $scope.view = false;
                alert("Vui lòng chỉ chọn 1 bản ghi");
            }
        }
    
  //Close view
    $scope.outView = function(){
    	$scope.view = false;
    }
    
    // fill product category data
    Restangular.all(exServiceBaseUrl + 'getAllPrCa').getList().then(function(result) {
        $scope.prCategoryList = result;
    });

    // fill employee data
    Restangular.all(exServiceBaseUrl + 'getEmployee').getList().then(function(result) {
        $scope.employeeList = result;
    });

    // edit
    $scope.doOpenEditForm = function() {
        chonChucNang = "Edit";
        $scope.nhapHang = false;
        $scope.searchform = false;
        $scope.view = false;
//        $scope.edit = false;
        $scope.editArray = [];
       
        angular.forEach($scope.exportorderList, function(exOrder) {
            if (exOrder.selected)
                $scope.editArray.push(exOrder);
        });
        if ($scope.editArray.length == 0) {
            $scope.edit = false;
            alert("Chọn bản ghi cần sửa");
        }
        $scope.category = {};
        if ($scope.editArray.length == 1) {
            Restangular.one(exServiceBaseUrl + 'findById', $scope.editArray[0].exId).get().then(function(result) {
                $scope.editObj = result;
                //console.log($scope.editObj);
                $scope.edit = true;

                Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.editObj.prId).get().then(function(result) {
                    $scope.prCList = result;
                    $scope.editObj.prCategoryId = $scope.prCList.prCategoryId;
                    //        	        console.log($scope.prCategoryId);
                });
                $scope.changePrcategory = function() {
                    Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.editObj.prId).get().then(function(result) {
                        $scope.prCList = result;
                        $scope.editObj.prCategoryId = $scope.prCList.prCategoryId;
                        //                	        console.log($scope.prCategoryId);
                    });
                }

                $scope.changeProduct = function() {
                    Restangular.all(exServiceBaseUrl + 'getProductListByPrcId').get($scope.editObj.prCategoryId).then(function(result) {
                        $scope.productList = result;
                        // console.log($scope.productList);
                    })
                }

            });
        }

        if ($scope.editArray.length > 1) {
            $scope.edit = false;
            alert("Vui lòng chỉ chọn 1 bản ghi");
        }
    }
    
  //close edit
    $scope.doCloseEditForm = function(){
    	$scope.edit = false;
    }


    // save update
    $scope.saveUpdate = function() {

        if (chonChucNang == "Edit") {
            //validation
            if ($scope.editObj.prId == undefined || $scope.editObj.prCategoryId == undefined ||
                $scope.editObj.unitPrice == undefined || $scope.editObj.quantity == undefined ||
                $scope.editObj.createDate == undefined || $scope.editObj.emId == undefined) {
                alert('Các thông tin không được bỏ trống');
                return;
            }

            if ($scope.editObj.unitPrice < 0 || $scope.editObj.unitPrice < 10000) {
                alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                return;
            }

            if ($scope.editObj.unitPrice > 100000000) {
                alert('Đơn giá không không vượt quá 9 chữ số');
                return;
            }

            if ($scope.editObj.quantity < 0) {
                alert("Số lượng không được âm");
                return;
            }

            if ($scope.quantity > $scope.prCList.quantity) {
                alert("Số lượng vượt quá giới hạn");
                return;
            }

            if ($scope.editObj.createDate > dateLocal) {
                alert("Chọn ngày trở về trước");
                return;
            }
            // save update
//            $scope.exportOrder = $scope.editObj;

//            $scope.exportOrder.exId = $scope.editObj.exId;
//            $scope.exportOrder.prName = $scope.editObj.prName;
//            $scope.exportOrder.prCategory = $scope.editObj.prCategory;
//            $scope.exportOrder.money = $scope.editObj.money;
//            $scope.exportOrder.prId = $scope.editObj.prId;
//            $scope.exportOrder.prCategoryId = $scope.editObj.prCategoryId;
//            $scope.exportOrder.unitPrice = $scope.editObj.unitPrice;
//            $scope.exportOrder.quantity = $scope.editObj.quantity;
//            $scope.exportOrder.unit = $scope.editObj.unit;
//            $scope.exportOrder.createDate = $scope.editObj.createDate;
//            $scope.exportOrder.emId = $scope.editObj.emId;
//            $scope.exportOrder.note = $scope.editObj.note;

             console.log($scope.editObj);
            Restangular.one(exServiceBaseUrl + "update").customPUT($scope.editObj).then(function() {
                confirm("Cập nhật thành công");
                $window.location.reload();
            });
        }
        if (chonChucNang == "Add") {
            //validation
            if ($scope.prId == undefined || $scope.prCategoryId == undefined ||
                $scope.unitPrice == undefined || $scope.quantity == undefined ||
                $scope.createDate == undefined || $scope.emId == undefined) {
                alert('Các thông tin không được bỏ trống');
                return;
            }

            if ($scope.unitPrice < 0 || $scope.unitPrice < 10000) {
                alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                return;
            }

            if ($scope.unitPrice > 100000000) {
                alert('Đơn giá không không vượt quá 9 chữ số');
                return;
            }

            if ($scope.quantity < 0) {
                alert("Số lượng không được âm");
                return;
            }

            if ($scope.quantity > $scope.prCList.quantity) {
                alert("Số lượng vượt quá giới hạn");
                return;
            }

            if ($scope.createDate > dateLocal) {
                alert("Chọn ngày trở về trước");
                return;
            }

            // save create
//            $scope.addEx = {};
//
//            $scope.addEx.prName = $scope.prName;
//            $scope.addEx.prId = $scope.prId;
//            $scope.addEx.prCategoryId = $scope.prCategoryId;
//            $scope.addEx.unitPrice = $scope.unitPrice;
//            $scope.addEx.quantity = $scope.quantity;
//            $scope.addEx.unit = $scope.donvitinh;
//            $scope.addEx.createDate = $scope.createDate;
//            $scope.addEx.emId = $scope.emId;
//            $scope.addEx.note = $scope.note;

             console.log($scope.addObj);
            Restangular.one(exServiceBaseUrl + "Create").customPOST($scope.addObj).then(function() {
                confirm("Thêm thành công");
                $window.location.reload();
            });
        }

    };



    $scope.Add = function() {
        chonChucNang = "Add";
        $scope.nhapHang = $scope.nhapHang ? false : true;
        $scope.searchform = false;
        $scope.searchform = false;
        $scope.edit = false;
        $scope.view = false;

    };


    //Tìm kiếm
    $scope.TimKiem = function() {
        //validation 
        if ($scope.searchObj.imId == undefined && $scope.searchObj.prId == undefined && $scope.searchObj.prCategoryId == undefined &&
            $scope.searchObj.createDateFrom == undefined || $scope.searchObj.createDateTo == undefined &&
            $scope.searchObj.emId == undefined) {
            alert("Bạn phải chọn một trong các thông tin")
        }

        if ($scope.searchObj.createDateFrom > $scope.searchObj.createDateTo) {
            alert("Chọn ngày bắt đầu phải nhỏ hơn ngày kết thúc");
        }


        $scope.searchObj1 = {};
        $scope.searchObj1.exId = $scope.searchObj.exId;
        $scope.searchObj1.prId = $scope.searchObj.prId;
        $scope.searchObj1.prCategoryId = $scope.searchObj.prCategoryId;
        $scope.searchObj1.createDateFrom = $scope.searchObj.createDateFrom;
        $scope.searchObj1.createDateTo = $scope.searchObj.createDateTo;
        $scope.searchObj1.emId = $scope.searchObj.emId;
        // console.log($scope.searchObj1);
        Restangular.all(exServiceBaseUrl + "doSearch").post($scope.searchObj1).then(function(result) {
            $scope.exportorderList = result;
        });
    }


    $scope.resetTable = function() {
        Restangular.all(exServiceBaseUrl + 'getAllEX').getList().then(function(result) {
            $scope.exportorderList = result;
        });
        $scope.searchObj.imId = null;
        $scope.searchObj.prId = null;
        $scope.searchObj.suId = null;
        $scope.searchObj.prCategoryId = null;
        $scope.searchObj.createDateFrom = null;
        $scope.searchObj.createDateTo = null;
        $scope.searchObj.emId = null;
    }

    // check all
    $scope.checkAll = function() {
        var toggleStatus = $scope.isAllSelected;
        angular.forEach($scope.exportorderList, function(itm) {
            itm.selected = toggleStatus;
        });

    }
    $scope.optionToggled = function() {
        $scope.isAllSelected = $scope.exportorderList.every(function(itm) {
            return itm.selected;
        });
    }

    // PAGINATION
    $scope.pageSize = 10;

    // SORT
    $scope.sort = function(keyname) {
        $scope.sortKey = keyname; // set the sortKey to the
        // param passed
        $scope.reverse = !$scope.reverse; // if true make it
        // false and vice
        // versa
    }

    // show(hide) form
    $scope.nhapHang = false;
    $scope.searchform = false;
    $scope.edit = false;
    $scope.view = false;
    $scope.formdate = false;
    $scope.tbxsearch = false;

    $scope.search1 = function() {
        $scope.searchform = $scope.searchform ? false : true;
        $scope.nhapHang = false;
        $scope.edit = false;
        $scope.view = false;
        $scope.formdate = false;
        $scope.tbxsearch = false;
    };

});