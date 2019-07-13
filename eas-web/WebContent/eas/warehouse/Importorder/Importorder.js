/**
 * 
 */
var app = angular.module('MyApp', ['restangular', 'angularUtils.directives.dirPagination']);

app.config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('http://localhost:8085/eas-service/');
});

var imServiceBaseUrl = "intern05Importorder/";
var exServiceBaseUrl = "intern05Exportorder/";
var statisticsServiceBaseUrl = "intern05Statistics/";

var dateLocal = new Date;
var chonChucNang;


app.controller('myCtrl', function($scope, $filter, Restangular, $window) {
    
    $scope.donvitinh = "VNĐ";
    // fill data
    Restangular.all(imServiceBaseUrl + 'getAll').getList().then(function(result) {
        $scope.importorderList = result;
        // console.log($scope.importorderList);
    });

    // fill all product data
    Restangular.all(statisticsServiceBaseUrl + 'getAllProduct').getList().then(function(result) {
        $scope.productList = result;
    });

    //change product <==> product category
    $scope.changePrcategory = function() {
        //	$scope.changPrc = $scope.prId;
        Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.prId).get().then(function(result) {
            $scope.prCList = result;
            $scope.prCategoryId = $scope.prCList.prCategoryId;
            //	        console.log($scope.prCategoryId);
        });
    }

    $scope.changeProduct = function() {
        //	$scope.changePr = $scope.prCategoryId;
        Restangular.all(exServiceBaseUrl + 'getProductListByPrcId').get($scope.prCategoryId).then(function(result) {
            $scope.productList = result;
            // console.log($scope.productList);
        })
    }

    // delete
    $scope.deleteObj = function() {
        $scope.orderArray = [];
        console.log($scope.orderArray);
        $scope.orderNumber = false;
        angular.forEach($scope.importorderList, function(imOrder) {
            if (imOrder.selected)
                $scope.orderArray.push(imOrder);
        });

        if ($scope.orderArray.length == 0) {
            $scope.orderNumber = false;
            alert("Vui lòng chọn bản ghi để xóa");
        }
        // xóa 1
        if ($scope.orderArray.length == 1) {
            var x = confirm("Bạn có chắc chắn muốn xóa?");
            if (x == true) {
                Restangular.one(imServiceBaseUrl + 'delete', $scope.orderArray[0].imId).remove().then(function() {
                    alert("Xóa thành công");
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
                    Restangular.one(imServiceBaseUrl + 'delete', $scope.orderArray[i].imId).remove().then(function() {
                        alert("Xóa thành công");
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
            angular.forEach($scope.importorderList, function(imOrder) {
                if (imOrder.selected)
                    $scope.viewArray.push(imOrder);
            });

            if ($scope.viewArray.length == 0) {
                $scope.view = false;
                alert("Vui lòng chọn bản ghi");
            }

            if ($scope.viewArray.length == 1) {
                Restangular.one(imServiceBaseUrl + 'findById', $scope.viewArray[0].imId).get().then(
                    function(result) {
                        $scope.viewObjex = result;
                        $scope.view = true;
                    })
            }

            if ($scope.viewArray.length > 1) {
                $scope.view = false;
                alert("Vui lòng chỉ chọn 1 bản ghi");
            }
        }
        // fill product category data
    Restangular.all(exServiceBaseUrl + 'getAllPrCa').getList().then(function(result) {
        $scope.prCategoryList = result;
    });

    // fill employee data
    Restangular.all(exServiceBaseUrl + 'getEmployee').getList().then(function(result) {
        $scope.employeeList = result;

    });
    //fill supplier data
    Restangular.all(imServiceBaseUrl + 'getAllSupplier').getList().then(function(result) {
        $scope.supplierList = result;

    });


    // edit
    $scope.editObj = function() {
        chonChucNang = "Edit";
        $scope.nhapHang = false;
        $scope.searchform = false;
        $scope.view = false;
        $scope.editArray = [];
        $scope.edit = false;
        angular.forEach($scope.importorderList, function(imOrder) {
            if (imOrder.selected)
                $scope.editArray.push(imOrder);
        });
        //      
        if ($scope.editArray.length == 0) {
            $scope.edit = false;
            alert("Chọn bản ghi cần sửa");
        }
        $scope.category = {};
        if ($scope.editArray.length == 1) {
            Restangular.one(imServiceBaseUrl + 'findById', $scope.editArray[0].imId).get().then(function(result) {
                $scope.editObj = result;
                //console.log($scope.editObj);
                $scope.edit = true;

                Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.editObj.prId).get().then(function(result) {
                    $scope.prCList = result;
                    $scope.editObj.prCategoryId = $scope.prCList.prCategoryId;
                    //        	        console.log($scope.prCategoryId);
                });
                $scope.changePrcategory = function() {
                    //                	$scope.changPrc = $scope.prId;
                    Restangular.one(exServiceBaseUrl + 'getPrcListByPrId', $scope.editObj.prId).get().then(function(result) {
                        $scope.prCList = result;
                        $scope.editObj.prCategoryId = $scope.prCList.prCategoryId;
                        //                	        console.log($scope.prCategoryId);
                    });
                }

                $scope.changeProduct = function() {
                    //                	$scope.changePr = $scope.prCategoryId;
                    Restangular.all(exServiceBaseUrl + 'getProductListByPrcId').get($scope.editObj.prCategoryId).then(function(result) {
                        $scope.productList = result;
                        console.log($scope.productList);
                    })
                }

            });
        }

        if ($scope.editArray.length > 1) {
            $scope.editNumber = false;
            alert("Vui lòng chỉ chọn 1 bản ghi");
        }
    }


    // save update
    $scope.saveUpdate = function() {

        if (chonChucNang == "Edit") {
            //validation
            if ($scope.prId == undefined || $scope.prCategoryId == undefined ||
                $scope.suId == undefined || $scope.unitPrice == undefined || $scope.quantity == undefined ||
                $scope.createDate == undefined || $scope.emId == undefined) {
                alert('Các thông tin không được bỏ trống');
                return;
            }

            if ($scope.unitPrice < 0 || $scope.unitPrice < 10000) {
                alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                return;
            }
            if ($scope.unitPrice > 10000000000000) {
                alert('Đơn giá không vượt 12 chữ số');
                return;
            }
            if ($scope.quantity < 0) {
                alert("Số lượng không được âm");
                return;
            }

            if ($scope.createDate > dateLocal) {
                alert("Chọn ngày trở về trước");
                return;
            }

            // save update
            $scope.importOrder = {};

            $scope.importOrder.imId = $scope.editObj.imId;
            $scope.importOrder.prName = $scope.editObj.prName;
            $scope.importOrder.prCategory = $scope.editObj.prCategory;
            $scope.importOrder.suId = $scope.editObj.suId;
            $scope.importOrder.money = $scope.editObj.money;
            $scope.importOrder.prId = $scope.editObj.prId;
            $scope.importOrder.prCategoryId = $scope.editObj.prCategoryId;
            $scope.importOrder.unitPrice = $scope.editObj.unitPrice;
            $scope.importOrder.quantity = $scope.editObj.quantity;
            $scope.importOrder.unit = $scope.editObj.unit;
            $scope.importOrder.createDate = $scope.editObj.createDate;
            $scope.importOrder.emId = $scope.editObj.emId;
            $scope.importOrder.note = $scope.editObj.note;

            // console.log($scope.importOrder);
            Restangular.one(imServiceBaseUrl + "update").customPUT($scope.importOrder).then(
                function() {
                    confirm("Cập nhật thành công");
                    $window.location.reload();
                });
        }
        if (chonChucNang == "Add") {
            //validation
            if ($scope.prId == undefined || $scope.prCategoryId == undefined ||
                $scope.suId == undefined || $scope.unitPrice == undefined || $scope.quantity == undefined ||
                $scope.createDate == undefined || $scope.emId == undefined) {
                alert('Các thông tin không được bỏ trống');
                return;
            }

            if ($scope.unitPrice < 0 || $scope.unitPrice < 10000) {
                alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                return;
            }

            if ($scope.unitPrice > 10000000000000) {
                alert('Đơn giá không vượt 12 chữ số');
                return;
            }

            if ($scope.quantity < 0) {
                alert("Số lượng không được âm");
                return;
            }

            if ($scope.createDate > dateLocal) {
                alert("Chọn ngày trở về trước");
                return;
            }


            // save create
            $scope.addEx = {};

            $scope.addEx.prId = $scope.prId;
            $scope.addEx.prCategoryId = $scope.prCategoryId;
            $scope.addEx.suId = $scope.suId;
            $scope.addEx.unitPrice = $scope.unitPrice;
            $scope.addEx.quantity = $scope.quantity;
            $scope.addEx.unit = $scope.donvitinh;
            $scope.addEx.createDate = $scope.createDate;
            $scope.addEx.emId = $scope.emId;
            $scope.addEx.note = $scope.note;

            // console.log($scope.addEx);
            Restangular.one(imServiceBaseUrl + "create").customPOST($scope.addEx).then(function() {
                confirm("Thêm thành công");
                $window.location.reload();
            });
        }

    };



    $scope.Add = function() {
        chonChucNang = "Add";
        $scope.nhapHang = $scope.nhapHang ? false : true;
        $scope.searchform = false;
        $scope.edit = false;
        $scope.view = false;

    };


    //Tìm kiếm
    $scope.TimKiem = function() {
        //validation 
        if ($scope.searchObj.imId == undefined && $scope.searchObj.prId == undefined &&
            $scope.searchObj.suId == undefined && $scope.searchObj.prCategoryId == undefined &&
            $scope.searchObj.createDateFrom == undefined || $scope.searchObj.createDateTo == undefined &&
            $scope.searchObj.emId == undefined) {
            alert("Bạn phải chọn một trong các thông tin")
        }

        if ($scope.searchObj.createDateFrom > $scope.searchObj.createDateTo) {
            alert("Chọn ngày bắt đầu phải nhỏ hơn ngày kết thúc");
        }


        $scope.searchObj1 = {};
        $scope.searchObj1.imId = $scope.searchObj.imId;
        $scope.searchObj1.prId = $scope.searchObj.prId;
        $scope.searchObj1.suId = $scope.searchObj.suId;
        $scope.searchObj1.prCategoryId = $scope.searchObj.prCategoryId;
        $scope.searchObj1.createDateFrom = $scope.searchObj.createDateFrom;
        $scope.searchObj1.createDateTo = $scope.searchObj.createDateTo;
        $scope.searchObj1.emId = $scope.searchObj.emId;

        Restangular.all(imServiceBaseUrl + "doSearch").post($scope.searchObj1).then(function(result) {
            $scope.importorderList = result;
            console.log($scope.importorderList);
        });
    }


    $scope.resetTable = function() {
        Restangular.all(imServiceBaseUrl + 'getAll').getList().then(function(result) {
            $scope.importorderList = result;
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
        angular.forEach($scope.importorderList, function(itm) {
            itm.selected = toggleStatus;
        });

    }
    $scope.optionToggled = function() {
        $scope.isAllSelected = $scope.importorderList.every(function(itm) {
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