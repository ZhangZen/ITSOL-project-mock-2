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

app.controller('myCtrl', function($scope, $filter, Restangular, $window) {
    // fill data
    Restangular.all(statisticsServiceBaseUrl + 'getAllStatistics').getList().then(function(result) {
        $scope.statisticsList = result;
        // console.log($scope.importorderList);
    });
    $scope.view = false;
    $scope.searchObj = false;
    // view
    $scope.viewObj = function() {
            $scope.searchObj = false;
            $scope.viewArray = [];
            $scope.view = false;
            angular.forEach($scope.statisticsList, function(statistic) {
                if (statistic.selected)
                    $scope.viewArray.push(statistic);
            });

            if ($scope.viewArray.length == 0) {
                $scope.view = false;
                alert("Vui lòng chọn bản ghi");
                return;
            }

            if ($scope.viewArray.length == 1) {
                Restangular.one(statisticsServiceBaseUrl + 'getByImId', $scope.viewArray[0].imId).get().then(function(result) {
                    $scope.viewObjex = result;
                    $scope.view = true;
                })
                return;
            }

            if ($scope.viewArray.length > 1) {
                $scope.view = false;
                alert("Vui lòng chỉ chọn 1 bản ghi");
                return;
            }
            $scope.view = $scope.view ? false : true;
        }
        // fill all product data
    Restangular.all(statisticsServiceBaseUrl + 'getAllProduct').getList().then(function(result) {
        $scope.productList = result;
    });

    // fill product category data
    Restangular.all(exServiceBaseUrl + 'getAllPrCa').getList().then(function(result) {
        $scope.prCategoryList = result;
    });

    // fill supplier data
    Restangular.all(imServiceBaseUrl + 'getAllSupplier').getList().then(function(result) {
        $scope.supplierList = result;
    });
    // thống kê
    $scope.TimKiem = function() {
        $scope.searchObj = $scope.searchObj ? false : true;
        $scope.view = false;
        if ($scope.prId == undefined || $scope.suId == undefined || $scope.peCategory == undefined) {
            alert("Vui lòng chọn 1 tiêu chí tìm kiếm")
        }

        $scope.searchObj1 = {};
        $scope.searchObj1.prId = $scope.prId;
        $scope.searchObj1.suId = $scope.suId;
        $scope.searchObj1.prCategoryId = $scope.prCategoryId;

        Restangular.all(statisticsServiceBaseUrl + "doSearch").post($scope.searchObj1).then(function(result) {
            $scope.statisticsList = result;
            // console.log($scope.importorderList);
        });
    }

    $scope.resetTable = function() {
        Restangular.all(statisticsServiceBaseUrl + 'getAllStatistics').getList().then(function(result) {
            $scope.statisticsList = result;
        });

        $scope.prId = null;
        $scope.suId = null;
        $scope.prCategoryId = null;
    }

    // check all
    $scope.checkAll = function() {
        var toggleStatus = $scope.isAllSelected;
        angular.forEach($scope.statisticsList, function(itm) {
            itm.selected = toggleStatus;
        });

    }
    $scope.optionToggled = function() {
        $scope.isAllSelected = $scope.statisticsList.every(function(itm) {
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
});