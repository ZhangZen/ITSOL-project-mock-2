/**
 * 
 */
(function() {
    'use strict';

    angular.module('exportOrder').controller('exportorderCtrl', function exportorderCtrl(exportorderService, $window, $q, $log, $timeout) {
        var ctrl = this;
        var chonChucNang;
        var dateLocal = new Date;

        getAllEx();
        getAllEm();
        getAllPr();
        getAllPrCa();


        ctrl.exportorderList = [];
        ctrl.pageSize = 10;
        ctrl.orderArray = [];
        ctrl.exportorder = {
            exId: '',
            prId: '',
            emId: '',
            prName: '',
            prCategory: '',
            prCategoryId: '',
            unit: 'VNĐ',
            quantity: '',
            unitPrice: '',
            money: '',
            createDate: '',
            note: '',
            firstName: '',
            lastName: '',
            createDateFrom: '',
            createDateTo: ''
        };

        ctrl.viewArray = [];
        ctrl.editArray = [];
        ctrl.prlist = [];
        ctrl.prclist = [];
        ctrl.emlist = [];

        ctrl.nhapHang = false;
        ctrl.searchform = false;
        ctrl.edit = false;
        ctrl.view = false;

        //change product <==> product category
        ctrl.changePrcategory = changePrcategory;
        ctrl.changeProduct = changeProduct;

        // check all
        ctrl.checkAll = checkAll;
        ctrl.optionToggled = optionToggled;

        // sort in table
        ctrl.sort = sort;

        // refresh table
        ctrl.refreshTable = refreshTable; // --> refresh table

        //view
        ctrl.viewObj = viewObjClick;
        ctrl.closeviewObj = closeviewObjClick;

        //edit
        ctrl.doOpenEditForm = doOpenEditFormClick;
        ctrl.doCloseEditForm = doCloseEditFormClick;

        //add
        ctrl.Add = AddClick;
        ctrl.closeAdd = closeAddClick;

        //save
        ctrl.saveUpdate = saveUpdateClick;

        //delete
        ctrl.deleteObj = deleteObjClick;

        //search
        ctrl.TimKiem = TimKiemClick;
        ctrl.closeTimKiem = closeTimKiemClick;
        ctrl.search1 = searchFromClick;


        //autocomplete product
        ctrl.querySearchProduct = querySearchProduct;
        //        ctrl.selectedItemChangeProduct = selectedItemChangeProduct;


        function querySearchProduct(query) {
            var results = query ? ctrl.prlist.filter(createFilterFor(query)) : ctrl.prlist,
                deferred;
            if (ctrl.simulateQuery) {
                deferred = $q.defer();
                $timeout(function() { deferred.resolve(results); }, Math.random() * 1000, false);
                return deferred.promise;
            } else {
                return results;
            }
        }

        function createFilterFor(query) {
            var lowercaseQuery = angular.lowercase(query);
            return function filterFn(state) {
                return (state.value.indexOf(lowercaseQuery) === 0);
            };
        }

        //        function selectedItemChangeProduct(item) {
        //            ctrl.exportorder.product = item.display;
        //            // ctrl.exportorder.product = item.id;
        //            console.log(item.display);
        //        }

        //autocomplete product category
        ctrl.querySearchPrCategory = querySearchPrCategory;
        //        ctrl.selectedItemChangePrCategory = selectedItemChangePrCategory;

        function querySearchPrCategory(query) {
            var results = query ? ctrl.prclist.filter(createFilterFor(query)) : ctrl.prclist,
                deferred;
            if (ctrl.simulateQuery) {
                deferred = $q.defer();
                $timeout(function() { deferred.resolve(results); }, Math.random() * 1000, false);
                return deferred.promise;
            } else {
                return results;
            }
        }

        function createFilterFor(query) {
            var lowercaseQuery = angular.lowercase(query);
            return function filterFn(state) {
                return (state.value.indexOf(lowercaseQuery) === 0);
            };
        }

        //        function selectedItemChangePrCategory(item) {
        //            ctrl.exportorder.prCategory = item.display;
        //            console.log(ctrl.exportorder.prCategory)
        //        }

        //autocomplete employee
        ctrl.querySearchEmployee = querySearchEmployee;
        //        ctrl.selectedItemChangeEmployee = selectedItemChangeEmployee;

        function querySearchEmployee(query) {
            var results = query ? ctrl.emlist.filter(createFilterFor(query)) : ctrl.emlist,
                deferred;
            if (ctrl.simulateQuery) {
                deferred = $q.defer();
                $timeout(function() { deferred.resolve(results); }, Math.random() * 1000, false);
                return deferred.promise;
            } else {
                return results;
            }
        }

        function createFilterFor(query) {
            var lowercaseQuery = angular.lowercase(query);
            return function filterFn(state) {
                return (state.value.indexOf(lowercaseQuery) === 0);
            };
        }

        //        ctrl.exportorder.emName = ctrl.exportorder.firstName + ' ' + ctrl.exportorder.lastName;
        //
        //        function selectedItemChangeEmployee(item) {
        //            ctrl.exportorder.emName = item.display;
        //        }

        //fill data into table
        function getAllEx() {
            exportorderService.getAllEx().then(function(result) {
                ctrl.exportorderList = result;
            });
        }

        //clear data in table
        function clearData() {
            ctrl.exportorder = {
                exId: '',
                prId: '',
                emId: '',
                prName: '',
                prCategory: '',
                prCategoryId: '',
                unit: '',
                quantity: '',
                unitPrice: '',
                money: '',
                createDate: '',
                note: '',
                firstName: '',
                lastName: '',
                createDateFrom: '',
                createDateTo: ''
            };
        }

        //close all form
        function closeAllForm() {
            ctrl.nhapHang = false;
            ctrl.searchform = false;
            ctrl.edit = false;
            ctrl.view = false;
        }

        // check all check-boxes
        function checkAll() {
            var toggleStatus = ctrl.isAllSelected;
            angular.forEach(ctrl.exportorderList, function(itm) {
                itm.selected = toggleStatus;
            });
        }

        function optionToggled() {
            ctrl.isAllSelected = ctrl.exportorderList.every(function(itm) {
                return itm.selected;
            });
        }

        //sort in table
        function sort(keyname) {
            ctrl.sortKey = keyname;
            ctrl.reverse = !ctrl.reverse;
        }

        //get all available data
        function getAllEm() {
            exportorderService.getAllEm().then(function(result) {
                ctrl.employeeList = result;
                ctrl.emlist = ctrl.employeeList.map(function(employee) {
                    return {
                        id: employee.emId,
                        value: ((employee.firstName) + ' ' + (employee.lastName)).toLowerCase(),
                        display: ((employee.firstName) + ' ' + (employee.lastName))
                    };
                });
            })
        }
        // ctrl.exportorder.emName = ctrl.emlist.display;

        function getAllPr() {
            exportorderService.getAllPr().then(function(result) {
                ctrl.productList = result;
                ctrl.prlist = ctrl.productList.map(function(product) {
                    return {
                        id: product.prId,
                        value: product.prName.toLowerCase(),
                        display: product.prName
                    };
                });
            })
        }



        function getAllPrCa() {
            exportorderService.getAllPrCa().then(function(result) {
                ctrl.prCategoryList = result;
                ctrl.prclist = ctrl.prCategoryList.map(function(category) {
                    return {
                        id: category.prCategoryId,
                        value: category.prCategory.toLowerCase(),
                        display: category.prCategory
                    };
                });
            })
        }


        //change product <==> product category
        function changePrcategory() {
            exportorderService.changePrcategory(ctrl.exportorder.prId).then(function(result) {
                ctrl.prCList = result;
                ctrl.exportorder.prCategoryId = ctrl.prCList.prCategoryId;
            })
        }

        function changeProduct() {
            exportorderService.changeProduct(ctrl.exportorder.prCategoryId).then(function(result) {
                ctrl.productList = result;
            })
        }

        //refresh table data
        function refreshTable() {
            ctrl.exportorderList = [];
            ctrl.isAllSelected = false;
            clearData();
            closeAllForm();
        }

        //view info exorder
        function viewObjClick() {
            ctrl.nhapHang = false;
            ctrl.searchform = false;
            ctrl.edit = false;
            ctrl.viewArray = [];

            angular.forEach(ctrl.exportorderList, function(exOrder) {
                if (exOrder.selected)
                    ctrl.viewArray.push(exOrder);
            });

            if (ctrl.viewArray.length == 0) {
                ctrl.view = false;
                alert("Vui lòng chọn bản ghi");
            }

            if (ctrl.viewArray.length == 1) {
                exportorderService.getOneById(ctrl.viewArray[0].exId).then(function(result) {
                    ctrl.exportorder = result;
                    ctrl.view = true;
                })
            }

            if (ctrl.viewArray.length > 1) {
                ctrl.view = false;
                alert("Vui lòng chỉ chọn 1 bản ghi");
            }
        }

        //close view
        function closeviewObjClick() {
            clearData();
            ctrl.view = false;
        }

        //edit
        function doOpenEditFormClick() {
            chonChucNang = "Edit"
            closeAllForm();
            ctrl.editArray = [];

            angular.forEach(ctrl.exportorderList, function(exOrder) {
                if (exOrder.selected)
                    ctrl.editArray.push(exOrder);
            });

            if (ctrl.editArray.length == 0) {
                ctrl.edit = false;
                alert("Chọn bản ghi cần sửa");
                return;
            }
            //			ctrl.category = {};
            if (ctrl.editArray.length == 1) {
                exportorderService.getOneById(ctrl.editArray[0].exId).then(function(result) {
                    ctrl.exportorder = result;
                    ctrl.edit = true;
                    console.log(ctrl.exportorder);
                    exportorderService.changePrcategory(ctrl.exportorder.prId).then(function(result) {
                        ctrl.prCList = result;
                        ctrl.exportorder.prCategoryId = ctrl.prCList.prCategoryId;
                    });

                    changePrcategory();
                    changeProduct();
                });
                return;
            }

            if (ctrl.editArray.length > 1) {
                ctrl.isAllSelected = false;
                ctrl.edit = false;
                closeAllForm();
                alert("Vui lòng chỉ chọn 1 bản ghi");
                return;
            }
        }

        //close editFrom
        function doCloseEditFormClick() {
            clearData();
            ctrl.edit = false;
        }

        //add order
        function AddClick() {
            chonChucNang = "Add";
            ctrl.nhapHang = ctrl.nhapHang ? false : true;
            ctrl.searchform = false;
            ctrl.searchform = false;
            ctrl.edit = false;
            ctrl.view = false;
        }

        //close Add
        function closeAddClick() {
            ctrl.nhapHang = false;
        }

        //save
        function saveUpdateClick() {
            if (chonChucNang == "Edit") {
                //validation
                if (ctrl.selectedItemProduct == null ||
                    ctrl.selectedItemPrCategory == null ||
                    ctrl.exportorder.unitPrice == null || ctrl.exportorder.quantity == null ||
                    ctrl.exportorder.createDate == null || ctrl.selectedItemEmployee == null) {
                    alert('Các thông tin không được bỏ trống');
                    return;
                }

                if (ctrl.exportorder.unitPrice < 0 || ctrl.exportorder.unitPrice < 10000) {
                    alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                    return;
                }

                if (ctrl.exportorder.unitPrice > 99999999999999) {
                    alert('Đơn giá không không vượt quá 12 chữ số');
                    return;
                }

                if (ctrl.exportorder.quantity < 0) {
                    alert("Số lượng không được âm");
                    return;
                }

                if (ctrl.exportorder.quantity > ctrl.productList.quantity) {
                    alert("Số lượng vượt quá giới hạn");
                    return;
                }

                if (ctrl.exportorder.createDate > dateLocal) {
                    alert("Chọn ngày trở về trước");
                    return;
                }

                if (ctrl.selectedItemProduct.id == null || ctrl.searchTextProduct == null) {
                    alert("Bạn chưa chọn tên hàng");
                    return;
                }

                if (ctrl.selectedItemPrCategory.id == null || ctrl.searchTextPrCategory == null) {
                    alert("Bạn chưa chọn loại hàng");
                    return;
                }


                if (ctrl.selectedItemEmployee.id == null || ctrl.searchTextEmployee == null) {
                    alert("Bạn chưa chọn nhân viên lập phiếu");
                    return;
                }

                ctrl.exportorder.prName = ctrl.exportorder.prName.id;

                var c = confirm("Bạn có muốn lưu thay đổi?");
                if (c) {
                    exportorderService.update(ctrl.exportorder).then(function() {
                        doCloseEditFormClick();
                        alert("Lưu thành công!");
                        $window.location.reload();
                    });
                }

            }

            if (chonChucNang == "Add") {
                //validation
                if (
                    ctrl.exportorder.unitPrice == null || ctrl.exportorder.quantity == null ||
                    ctrl.exportorder.createDate == null ) {
                    alert('Các thông tin không được bỏ trống');
                    return;
                }

                if (ctrl.exportorder.unitPrice < 0 || ctrl.exportorder.unitPrice < 10000) {
                    alert('Đơn giá không âm hoặc phải lớn hơn 4 chữ số');
                    return;
                }

                if (ctrl.exportorder.unitPrice > 99999999999999) {
                    alert('Đơn giá không không vượt quá 14 chữ số');
                    return;
                }

                if (ctrl.exportorder.quantity < 0) {
                    alert("Số lượng không được âm");
                    return;
                }

                if (ctrl.exportorder.quantity > ctrl.productList.quantity) {
                    alert("Số lượng vượt quá giới hạn");
                    return;
                }

                if (ctrl.exportorder.createDate > dateLocal) {
                    alert("Chọn ngày trở về trước");
                    return;
                }

                              
                if(ctrl.selectedItemProduct == null){
                	for(var i = 0; i < ctrl.prlist.length; i++){
                		if(ctrl.prlist[i].display.toLowerCase() == ctrl.searchTextProduct.toLowerCase()){
                			ctrl.exportorder.prId = ctrl.prlist[i].id;
                			break;
                		};
                	}
                }else{
                	 ctrl.exportorder.prId = ctrl.selectedItemProduct.id;
                }
                
                if(ctrl.exportorder.prId === null || ctrl.exportorder.prId === ''){
                	alert("Tên hàng không được để trống");
                	return;
                }
                
                if(ctrl.selectedItemPrCategory == null){
                	for(var i = 0; i < ctrl.prclist.length; i++){
                		if(ctrl.prclist[i].display.toLowerCase() == ctrl.searchTextPrCategory.toLowerCase()){
                			ctrl.exportorder.prCategoryId = ctrl.prclist[i].id;
                			break;
                		};
                	}
                }else{
                	 ctrl.exportorder.prCategoryId = ctrl.selectedItemPrCategory.id;
                }
                
                if(ctrl.exportorder.prCategoryId == null || ctrl.exportorder.prCategoryId == ''){
                	alert("Loại hàng phải có trong danh sách");
                	return;
                }
                
                if(ctrl.selectedItemEmployee == null){
                	for(var i = 0; i < ctrl.emlist.length; i++){
                		if(ctrl.emlist[i].display.toLowerCase() == ctrl.searchTextEmployee.toLowerCase()){
                			ctrl.exportorder.emId = ctrl.emlist[i].id;
                			break;
                		};
                	}
                }else{
                	 ctrl.exportorder.emId = ctrl.selectedItemEmployee.id;
                }
                
                if(ctrl.exportorder.emId == null || ctrl.exportorder.emId == ''){
                	alert("Nhân viên phải là người có trong danh sách");
                	return;
                }

                var c = confirm("Bạn có muốn thêm phiếu xuất?");
                if (c) {
                    exportorderService.create(ctrl.exportorder).then(function() {
                        closeAddClick();
                        alert("Thêm thành công!");
                        $window.location.reload();
                    });
                }

            }
        }

        //delete
        function deleteObjClick() {
            ctrl.orderArray = [];
            angular.forEach(ctrl.exportorderList, function(exOrder) {
                if (exOrder.selected)
                    ctrl.orderArray.push(exOrder);
            });
            if (ctrl.orderArray.length >= 1) {
                var c = confirm("Bạn có chắc chắn muốn xóa phiếu này?");
                if (c) {
                    var isComplete = true;
                    for (var i = 0; i < ctrl.orderArray.length; i++) {
                        exportorderService.deleteObj(ctrl.orderArray[i].exId).then(function() {
                            console.log("Deleting");
                            $window.location.reload();
                        }, function(error) {
                            isComplete = false;
                        });
                    }
                    if (isComplete) {
                        alert("Xóa thành công!");
                        $window.location.reload();
                        return;
                    } else {
                        alert("Xóa thất bại");
                    }
                }
            }
            if (ctrl.orderArray.length == 0) {
                alert("Bạn cần chọn ít nhất một phiếu để xóa!");
                return;
            }
        }

        //search
        function TimKiemClick() {
            if (ctrl.exportorder.exId < 0 || ctrl.exportorder.exId > 999999) {
                alert("Mã phiếu phải lớn hơn 0 hoặc nhỏ hơn 6 chữ số");
                return;
            }

            if (ctrl.selectedItemProduct == null) {
                ctrl.exportorder.prName = ctrl.searchTextProduct;
            } else {
                ctrl.exportorder.prName = ctrl.selectedItemProduct.display;
            }

            if (ctrl.selectedItemPrCategory == null) {
                ctrl.exportorder.prCategory = ctrl.selectedItemPrCategory;
            } else {
                ctrl.exportorder.prCategory = ctrl.selectedItemPrCategory.display;
            }

            if (ctrl.selectedItemEmployee == null) {
                ctrl.exportorder.firstName = ctrl.searchTextEmployee;
            } else {
                ctrl.exportorder.lastName = ctrl.selectedItemEmployee.display;
            }

            exportorderService.doSearch(ctrl.exportorder).then(function(result) {
                ctrl.exportorderList = result;
                console.log(ctrl.exportorderList);
                closeTimKiemClick();
                ctrl.searchform = true;
            });
        }

        //close searcForm
        function closeTimKiemClick() {
            ctrl.searchform = false;
            ctrl.exportorder.exId = null;
            ctrl.selectedItemProduct = null;
            ctrl.selectedItemPrCategory = null;
        }

        function doSearch1() {

        }

        function searchFromClick() {
            ctrl.searchform = ctrl.searchform ? false : true;
            ctrl.nhapHang = false;
            ctrl.edit = false;
            ctrl.view = false;
            ctrl.formdate = false;
            ctrl.tbxsearch = false;
        }
    })
})();