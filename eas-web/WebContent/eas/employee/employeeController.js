(function () {
	'use strict';

	angular.module('employeePart').controller('employeeCtrl', function employeeCtrl(employeeService, $timeout, $q) {

		var ctrl = this;

		// --------------------INITIALIZATION PAGE--------------------
		fillDataTable(); // --> fill data into table
		getAllCity(); // --> get all city
		getAllEthnic(); // --> get all ethnic
		getAllDepartment(); // --> get all department
		getAllPosition(); // --> get all position
		getAllLiteracy(); // --> get all literacy
		getAllSalary(); // --> get all salary


		// --------------------DECLARE OBJECT--------------------
		ctrl.employeeList = []; // employee list in table
		ctrl.pageSize = 10; // pagination
		ctrl.employeeArray = []; // checked employee list 
		ctrl.employee = { // employee in edit form
			emId: '',
			emFirstname: '',
			emLastname: '',
			emBirthday: '',
			emSex: '',
			emSexString: '',
			emHometown: '',
			emEthnic: '',
			emPhone: '',
			emStarteddate: '',
			liId: '',
			poId: '',
			deId: '',
			liName: '',
			poName: '',
			deName: '',
			saLevel: '',
			saBasic: '',
			saCoefficient: '',
			saAllowanceCoefficient: ''
		};
		ctrl.sexField = [
			{
				sexId: 1,
				sexOption: 'Nam'
			},
			{
				sexId: 2,
				sexOption: 'Nữ'
			},
			{
				sexId: 3,
				sexOption: 'Không xác định'
			}
		];
		ctrl.cityField = [];
		ctrl.ethnicField = [];
		ctrl.departmentField = [];
		ctrl.positionField = [];
		ctrl.literacyField = [];
		ctrl.salaryField = [];
		
		// auto-complete fields
		ctrl.cities = [];
		ctrl.ethnics = [];
		ctrl.departments = [];
		ctrl.positions = [];
		ctrl.literacies = [];

		// --------------------DECLARE SHOW/HIDE FORM--------------------
		ctrl.addEmployee = false;
		ctrl.searchEmployee = false;
		ctrl.editEmployeeInfor = false;
		ctrl.EmployeeInfor = false;
		ctrl.searchTile = false;
		ctrl.closeSearchTable = false;

		// --------------------DECLARE ACTION/EVENT/FUNCTION------------------------

		// ------------------>>>>>>>>GENERALLY
		// check all
		ctrl.checkAll = checkAll;
		ctrl.optionToggled = optionToggled;
		// sort in table
		ctrl.sort = sort;

		// get one salary by id
		ctrl.showSalaryInfor = showSalaryInfor;

		// refresh table
		ctrl.refreshTable = refreshTable; // --> refresh table

		// employee details
		ctrl.showEmployeeInforClick = showEmployeeInforClick; // --> show form
		ctrl.closeEmployeeInforClick = closeEmployeeInforClick; // --> close form

		// add new employee
		ctrl.addEmployeeClick = addEmployeeClick; // --> show form
		ctrl.closeAddingEmClick = closeAddingEmClick; // --> close form
		ctrl.addNewEmClick = addNewEmClick; // --> add new employee

		//edit employee information
		ctrl.editEmployeeInforClick = editEmployeeInforClick; // --> show form
		ctrl.closeEditingFormClick = closeEditingFormClick; // --> close form
		ctrl.updateEmployee = updateEmployee;// --> update employee information

		// delete employee (list)
		ctrl.deleteEmployeeClick = deleteEmployeeClick; // --> delete

		// search employee
		ctrl.searchEmployeeClick = searchEmployeeClick; // --> show search form
		ctrl.closeSearchForm = closeSearchForm; // --> close search form
		ctrl.doSearchEmployee = doSearchEmployee; // --> search
		ctrl.doCloseSearchTable = doCloseSearchTable; // --> close search result table

		//excel export
		ctrl.exportExcel = exportExcel;


		ctrl.querySearchCITY = querySearchCITY;
		ctrl.querySearchETHNIC = querySearchETHNIC;
		ctrl.querySearchDEPARTMENT = querySearchDEPARTMENT;
		ctrl.querySearchPOSITION = querySearchPOSITION;
		ctrl.querySearchLITERACY = querySearchLITERACY;

		// --------------------->>>>>DETAILS

		// ------------------------------------------Load all data into auto complete fields
		function createFilterFor(query) {
			var lowercaseQuery = angular.lowercase(query);
			return function filterFn(state) {
				return (state.value.indexOf(lowercaseQuery) === 0);
			};
		}
		function querySearchCITY(query) {
			var results = query ? ctrl.cities.filter(createFilterFor(query)) : ctrl.cities,
				deferred;
			if (ctrl.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}
		function querySearchETHNIC(query) {
			var results = query ? ctrl.ethnics.filter(createFilterFor(query)) : ctrl.ethnics,
				deferred;
			if (ctrl.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}
		function querySearchDEPARTMENT(query) {
			var results = query ? ctrl.departments.filter(createFilterFor(query)) : ctrl.departments,
				deferred;
			if (ctrl.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}
		function querySearchPOSITION(query) {
			var results = query ? ctrl.positions.filter(createFilterFor(query)) : ctrl.positions,
				deferred;
			if (ctrl.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}
		function querySearchLITERACY(query) {
			var results = query ? ctrl.literacies.filter(createFilterFor(query)) : ctrl.literacies,
				deferred;
			if (ctrl.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}
		
		// fill data into table
		function fillDataTable() {
			employeeService.getAllEmployee().then(function (result) {
				ctrl.employeeList = result;
				console.log(ctrl.employeeList);
			});
		}

		// clear employee object data
		function clearEmployeeData() {
			ctrl.employee = {
				emId: '',
				emFirstname: '',
				emLastname: '',
				emBirthday: '',
				emSex: '',
				emSexString: '',
				emHometown: '',
				emEthnic: '',
				emPhone: '',
				emStarteddate: '',
				liId: '',
				poId: '',
				deId: '',
				liName: '',
				poName: '',
				deName: '',
				saLevel: '',
				saBasic: '',
				saCoefficient: '',
				saAllowanceCoefficient: ''
			};
		}

		// close all sub form
		function closeAllSubForm() {
			ctrl.addEmployee = false;
			ctrl.searchEmployee = false;
			ctrl.editEmployeeInfor = false;
			ctrl.EmployeeInfor = false;
			ctrl.searchTile = false;
			ctrl.closeSearchTable = false;
		}


		// check all check-boxes
		function checkAll() {
			var toggleStatus = ctrl.isAllSelected;
			angular.forEach(ctrl.employeeList, function (itm) {
				itm.selected = toggleStatus;
			});
		}
		function optionToggled() {
			ctrl.isAllSelected = ctrl.employeeList.every(function (itm) {
				return itm.selected;
			});
		}

		//sort in table
		function sort(keyname) {
			ctrl.sortKey = keyname;
			ctrl.reverse = !ctrl.reverse;
		}

		// get all available data
		function getAllCity() {
			employeeService.getAllCity().then(function (result) {
				ctrl.cityField = result;
				console.log(ctrl.cityField);
				ctrl.cities = ctrl.cityField.map(function (city) {
					return {
						value: city.toLowerCase(),
						display: city
					};
				});
				console.log(ctrl.cities);
			});
		}
		function getAllEthnic() {
			employeeService.getAllEthnic().then(function (result) {
				ctrl.ethnicField = result;
				console.log(ctrl.ethnicField);
				ctrl.ethnics = ctrl.ethnicField.map(function (ethnic) {
					return {
						value: ethnic.toLowerCase(),
						display: ethnic
					};
				});
			});
		}
		function getAllDepartment() {
			employeeService.getAllDepartment().then(function (result) {
				ctrl.departmentField = result;
				console.log(ctrl.departmentField);
				ctrl.departments = ctrl.departmentField.map(function (department) {
					return {
						id: department.deId,
						value: department.deName.toLowerCase(),
						display: department.deName
					}
				});
				console.log(ctrl.departments);
			});
		}
		function getAllPosition() {
			employeeService.getAllPosition().then(function (result) {
				ctrl.positionField = result;
				console.log(ctrl.positionField);
				ctrl.positions = ctrl.positionField.map(function(position){
					return {
						id: position.poId,
						value: position.poName.toLowerCase(),
						display: position.poName
					}
				});
			});
		}
		function getAllLiteracy() {
			employeeService.getAllLiteracy().then(function (result) {
				ctrl.literacyField = result;
				console.log(ctrl.literacyField);
				ctrl.literacies = ctrl.literacyField.map(function(litrracy){
					return{
						id: litrracy.liId,
						value: litrracy.liName.toLowerCase(),
						display: litrracy.liName
					}
				});
			});
		}
		function getAllSalary() {
			employeeService.getAllSalary().then(function (result) {
				ctrl.salaryField = result;
				console.log(ctrl.salaryField);
			});
		}

		// get salary by id
		function showSalaryInfor() {
			employeeService.getSalaryById(ctrl.employee.saLevel).then(function (result) {
				ctrl.employee.saBasic = result.saBasic;
				ctrl.employee.saCoefficient = result.saCoefficient;
				ctrl.employee.saAllowanceCoefficient = result.saAllowancecoefficient;
			});
		}

		// REFRESH
		// refresh table's data
		function refreshTable() {
			ctrl.employeeList = [];
			ctrl.isAllSelected = false;
			clearEmployeeData();
			closeAllSubForm();
			setTimeout(fillDataTable(), 200);
		}

		// EMPLOYEE INFORMATION
		// open employee details form
		function showEmployeeInforClick() {
			ctrl.employeeArray = [];
			angular.forEach(ctrl.employeeList, function (employee) {
				if (employee.selected) ctrl.employeeArray.push(employee);
			});
			if (ctrl.employeeArray.length == 1) {
				if (ctrl.EmployeeInfor == false) {
					closeAllSubForm();
					employeeService.getOneById(ctrl.employeeArray[0].emId).then(function (result) {
						ctrl.employee = result;
					});
					ctrl.EmployeeInfor = true;
					return;
				} else {
					clearEmployeeData();
					ctrl.EmployeeInfor = false;
				}
			}
			if (ctrl.employeeArray.length == 0) {
				closeAllSubForm();
				alert("Bạn cần chọn một nhân viên để xem thông tin!");
				return;
			}
			if (ctrl.employeeArray.length > 1) {
				ctrl.isAllSelected = false;
				ctrl.checkAll();
				closeAllSubForm();
				alert("Bạn chỉ được xem thông tin của từng nhân viên một!");
				return;
			}
		}

		// close employee details form
		function closeEmployeeInforClick() {
			clearEmployeeData();
			ctrl.EmployeeInfor = false;
		};

		// ADD NEW EMPLOYEE
		// open adding form
		function addEmployeeClick() {
			if (ctrl.addEmployee == false) {
				clearEmployeeData();
				closeAllSubForm();
				//uncheck all check boxes
				ctrl.isAllSelected = false;
				angular.forEach(ctrl.employeeList, function (itm) {
					itm.selected = false;
				});

				ctrl.addEmployee = true;
			} else {
				ctrl.closeAddingEmClick();
			}
		}
		//close form 
		function closeAddingEmClick() {
			clearEmployeeData();
			ctrl.addEmployee = false;
		}
		// add
		function addNewEmClick() {
			// validation in form
			if (new Date(ctrl.employee.emBirthday).getFullYear() > new Date().getFullYear()) {
				alert("Năm bạn chọn vượt quá năm hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}
			if ((new Date(ctrl.employee.emBirthday).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emBirthday).getMonth() + 1) > (new Date().getMonth() + 1))) {
				alert("Thời gian bạn chọn vượt quá thời gian hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}
			if ((new Date(ctrl.employee.emBirthday).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emBirthday).getMonth() + 1) == (new Date().getMonth() + 1)) && (new Date(ctrl.employee.emBirthday).getDate() > new Date().getDate())) {
				alert("Thời gian bạn chọn vượt quá thời gian hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}

			ctrl.emAge = new Date().getFullYear() - new Date(ctrl.employee.emBirthday).getFullYear();
			console.log("Tuổi: " + ctrl.emAge);
			if (ctrl.emAge < 15) {
				alert("Người này chưa đủ tuổi lao động!");
				return;
			}

			if (ctrl.emAge > 60 || (ctrl.emAge > 55 && ctrl.emSex == 2)) {
				alert("Người này đã quá tuổi lao động!");
				return;
			}

			if (new Date(ctrl.employee.emStarteddate).getFullYear() > new Date().getFullYear()) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			if ((new Date(ctrl.employee.emStarteddate).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emStarteddate).getMonth() + 1) > (new Date().getMonth() + 1))) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			if ((new Date(ctrl.employee.emStarteddate).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emStarteddate).getMonth() + 1) == (new Date().getMonth() + 1)) && (new Date(ctrl.employee.emStarteddate).getDate() > new Date().getDate())) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			var workingTime = new Date(ctrl.employee.emStarteddate).getFullYear() - new Date(ctrl.employee.emBirthday).getFullYear();
			if (workingTime < 15) {
				alert("Người này chưa đủ tuổi lao động (tính đến thời điểm bắt đầu làm việc)!");
				return;
			}

			// validate home town
			console.log(ctrl.selectedItemCity);
			if (ctrl.selectedItemCity == null) {
				for(var i=0; i<ctrl.cities.length; i++){
					console.log(ctrl.cities[i].display);
					if(ctrl.cities[i].display.toLowerCase() == ctrl.searchTextCITY.toLowerCase()){
						ctrl.employee.emHometown = ctrl.cities[i].display;
						break;
					};
				}
			}else{
				ctrl.employee.emHometown = ctrl.selectedItemCity.display;
			}
			if(ctrl.employee.emHometown == null || ctrl.employee.emHometown == ''){
				alert("Tỉnh/thành phố không tồn tại ở VN, yêu cầu nhập lại!");
				return;
			}

			// validate ethnic
			console.log(ctrl.selectedItemEthnic);
			if (ctrl.selectedItemEthnic == null) {
				for(var i=0; i<ctrl.ethnics.length; i++){
					console.log(ctrl.ethnics[i].display);
					if(ctrl.ethnics[i].display.toLowerCase() == ctrl.searchTextETHNIC.toLowerCase()){
						ctrl.employee.emEthnic = ctrl.ethnics[i].display;
						break;
					};
				}
			}else{
				ctrl.employee.emEthnic = ctrl.selectedItemCity.display;
			}
			if(ctrl.employee.emEthnic == null || ctrl.employee.emEthnic == ''){
				alert("Dân tộc vừa nhập không tồn tại ở VN, yêu cầu nhập lại!");
				return;
			}

			// validate department
			console.log(ctrl.selectedItemDepartment);
			if (ctrl.selectedItemDepartment == null) {
				for(var i=0; i<ctrl.departments.length; i++){
					console.log(ctrl.departments[i].display);
					if(ctrl.departments[i].display.toLowerCase() == ctrl.searchTextDEPARTMENT.toLowerCase()){
						ctrl.employee.deId = ctrl.departments[i].id;
						break;
					};
				}
			}else{
				ctrl.employee.deId = ctrl.selectedItemDepartment.id;
			}
			if(ctrl.employee.deId == null || ctrl.employee.deId == ''){
				alert("Phòng ban vừa nhập không tồn tại, yêu cầu nhập lại!");
				return;
			}
			
			// validate position
			console.log(ctrl.selectedItemPosition);
			if (ctrl.selectedItemPosition == null) {
				for(var i=0; i<ctrl.positions.length; i++){
					console.log(ctrl.positions[i].display);
					if(ctrl.positions[i].display.toLowerCase() == ctrl.searchTextPOSITION.toLowerCase()){
						ctrl.employee.poId = ctrl.positions[i].id;
						break;
					};
				}
			}else{
				ctrl.employee.poId = ctrl.selectedItemPosition.id;
			}
			if(ctrl.employee.poId == null || ctrl.employee.poId == ''){
				alert("Chức vụ vừa nhập không tồn tại, yêu cầu nhập lại!");
				return;
			}
			
			// validate literacy
			console.log(ctrl.selectedItemLiteracy);
			if (ctrl.selectedItemLiteracy == null) {
				for(var i=0; i<ctrl.literacies.length; i++){
					console.log(ctrl.literacies[i].display);
					if(ctrl.literacies[i].display.toLowerCase() == ctrl.searchTextLITERACY.toLowerCase()){
						ctrl.employee.liId = ctrl.literacies[i].id;
						break;
					};
				}
			}else{
				ctrl.employee.liId = ctrl.selectedItemLiteracy.id;
			}
			if(ctrl.employee.liId == null || ctrl.employee.liId == ''){
				alert("Trình độ học vấn vừa nhập không tồn tại, yêu cầu nhập lại!");
				return;
			}
			
			console.log(ctrl.employee);
			var c = confirm("Bạn có chắc chắn muốn thêm nhân viên mới?");
			if (c) {
				employeeService.createNewEmployee(ctrl.employee).then(function () {
					ctrl.closeAddingEmClick();
					alert("Thêm mới nhân viên thành công!");
					setTimeout(refreshTable(), 200);
				});
			}
		}

		// EDIT EMPLOYEE INFORMATION
		// open form
		function editEmployeeInforClick() {
			ctrl.employeeArray = [];
			angular.forEach(ctrl.employeeList, function (employee) {
				if (employee.selected)
					ctrl.employeeArray.push(employee);
			});
			if (ctrl.employeeArray.length == 1) {
				if (ctrl.editEmployeeInfor == false) {
					closeAllSubForm();
					employeeService.getOneById(ctrl.employeeArray[0].emId).then(function (result) {
						ctrl.employee = result;
						ctrl.employee.emBirthday = new Date(ctrl.employee.emBirthday);
						ctrl.employee.emStarteddate = new Date(ctrl.employee.emStarteddate);
					});
					ctrl.editEmployeeInfor = true;
					return;
				} else {
					ctrl.closeEditingFormClick();
				}
			}
			if (ctrl.employeeArray.length == 0) {
				closeAllSubForm();
				alert("Bạn cần chọn một nhân viên để sửa thông tin!");
				return;
			}
			if (ctrl.employeeArray.length > 1) {
				ctrl.isAllSelected = false;
				checkAll();
				closeAllSubForm();
				alert("Bạn chỉ được sửa thông tin của từng nhân viên một!");
				return;
			}
		}
		//close form
		function closeEditingFormClick() {
			clearEmployeeData();
			ctrl.editEmployeeInfor = false;
		};
		// edit
		function updateEmployee() {

			
			if (new Date(ctrl.employee.emBirthday).getFullYear() > new Date().getFullYear()) {
				alert("Năm bạn chọn vượt quá năm hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}
			if ((new Date(ctrl.employee.emBirthday).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emBirthday).getMonth() + 1) > (new Date().getMonth() + 1))) {
				alert("Thời gian bạn chọn vượt quá thời gian hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}
			if ((new Date(ctrl.employee.emBirthday).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emBirthday).getMonth() + 1) == (new Date().getMonth() + 1)) && (new Date(ctrl.employee.emBirthday).getDate() > new Date().getDate())) {
				alert("Thời gian bạn chọn vượt quá thời gian hiện tại để có thể là ngày sinh của nhân viên!");
				return;
			}
			ctrl.emAge = new Date().getFullYear() - new Date(ctrl.employee.emBirthday).getFullYear();
			console.log("Tuổi: " + ctrl.emAge);
			if (ctrl.emAge < 15) {
				alert("Người này chưa đủ tuổi lao động!");
				return;
			}
			if (ctrl.emAge > 60 || (ctrl.emAge > 55 && ctrl.emSex == 2)) {
				alert("Người này đã quá tuổi lao động!");
				return;
			}

			// validate started working date
			if (new Date(ctrl.employee.emStarteddate).getFullYear() > new Date().getFullYear()) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			if ((new Date(ctrl.employee.emStarteddate).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emStarteddate).getMonth() + 1) > (new Date().getMonth() + 1))) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			if ((new Date(ctrl.employee.emStarteddate).getFullYear() == new Date().getFullYear()) && ((new Date(ctrl.employee.emStarteddate).getMonth() + 1) == (new Date().getMonth() + 1)) && (new Date(ctrl.employee.emStarteddate).getDate() > new Date().getDate())) {
				alert("Ngày bắt đầu làm việc tối đa là thời gian hiện tại!");
				return;
			}
			var workingTime = new Date(ctrl.employee.emStarteddate).getFullYear() - new Date(ctrl.employee.emBirthday).getFullYear();
			if (workingTime < 15) {
				alert("Người này chưa đủ tuổi lao động (tính đến thời điểm bắt đầu làm việc)!");
				return;
			}

			console.log(ctrl.employee);
			employeeService.updateEmployee(ctrl.employee).then(function () {
				ctrl.closeEditingFormClick();
				alert("Sửa thông tin thành công!");
				setTimeout(refreshTable(), 200);
			});
		};


		// DELETE EMPLOYEE (LIST)
		function deleteEmployeeClick() {
			ctrl.employeeArray = [];
			angular.forEach(ctrl.employeeList, function (employee) {
				if (employee.selected)
					ctrl.employeeArray.push(employee);
			});
			if (ctrl.employeeArray.length >= 1) {
				var c = confirm("Bạn có chắc chắn muốn xóa (các) nhân viên này?");
				if (c) {
					var isComplete = true;
					for (var i = 0; i < ctrl.employeeArray.length; i++) {
						employeeService.deleteById(ctrl.employeeArray[i].emId).then(function () {
							console.log("Deleting");
						}, function (error) {
							isComplete = false;
						});
					}
					if (isComplete) {
						alert("Xóa thành công!");
						setTimeout(refreshTable(), 500);
					} else {
						alert("Xóa thất bại");
					}
				}
			}
			if (ctrl.employeeArray.length == 0) {
				alert("Bạn cần chọn ít nhất một nhân viên để xóa!");
				return;
			}
		};

		// SEARCH EMPLOYEE
		// open search form
		function searchEmployeeClick() {
			if (ctrl.searchEmployee == false) {
				clearEmployeeData();
				ctrl.isAllSelected = false;
				checkAll();
				closeAllSubForm();
				ctrl.searchEmployee = true;
			} else {
				clearEmployeeData();
				ctrl.searchEmployee = false;
			}
		}
		//close search form
		function closeSearchForm() {
			clearEmployeeData();
			ctrl.searchEmployee = false;
		}
		// search
		function doSearchEmployee() {
			
			if(ctrl.employee.emFirstname.includes("\\")){
				ctrl.employee.emFirstname = ctrl.employee.emFirstname.replace("\\", "\\\\");
			}
			if(ctrl.employee.emLastname.includes("\\")){
				ctrl.employee.emLastname = ctrl.employee.emLastname.replace("\\", "\\\\");
			}
			if(ctrl.employee.emHometown.includes("\\")){
				ctrl.employee.emHometown = ctrl.employee.emHometown.replace("\\", "\\\\");
			}
			if(ctrl.employee.emEthnic.includes("\\")){
				ctrl.employee.emEthnic = ctrl.employee.emEthnic.replace("\\", "\\\\");
			}
			if(ctrl.employee.emPhone.includes("\\")){
				ctrl.employee.emPhone = ctrl.employee.emPhone.replace("\\", "\\\\");
			}
			if(ctrl.employee.deName.includes("\\")){
				ctrl.employee.deName = ctrl.employee.deName.replace("\\", "\\\\");
			}
			if(ctrl.employee.poName.includes("\\")){
				ctrl.employee.poName = ctrl.employee.poName.replace("\\", "\\\\");
			}
			if(ctrl.employee.liName.includes("\\")){
				ctrl.employee.liName = ctrl.employee.liName.replace("\\", "\\\\");
			}
			
			// validate home town
			console.log(ctrl.selectedItemCity);
			if (ctrl.selectedItemCity == null) {
				ctrl.employee.emHometown = ctrl.searchTextCITY;
			}else{
				ctrl.employee.emHometown = ctrl.selectedItemCity;
			}

			// validate ethnic
			console.log(ctrl.selectedItemEthnic);
			if (ctrl.selectedItemEthnic == null) {
				ctrl.employee.emEthnic = ctrl.searchTextETHNIC;
			}else{
				ctrl.employee.emEthnic = ctrl.selectedItemCity;
			}

			// validate department
			console.log(ctrl.selectedItemDepartment);
			if (ctrl.selectedItemDepartment == null) {
				ctrl.employee.deName = ctrl.searchTextDEPARTMENT;
			}else{
				ctrl.employee.deName = ctrl.selectedItemDepartment.display;
			}
			
			// validate position
			console.log(ctrl.selectedItemPosition);
			if (ctrl.selectedItemPosition == null) {
				ctrl.employee.poName = ctrl.searchTextPOSITION;
			}else{
				ctrl.employee.poName = ctrl.selectedItemPosition.display;
			}
			
			// validate literacy
			console.log(ctrl.selectedItemLiteracy);
			if (ctrl.selectedItemLiteracy == null) {
				ctrl.employee.liName  = ctrl.searchTextLITERACY;
			}else{
				ctrl.employee.liName = ctrl.selectedItemLiteracy.display;
			}
			
			console.log(ctrl.employee);						
			employeeService.doSearch(ctrl.employee).then(function (result) {
				ctrl.employeeList = result;
				console.log(ctrl.employeeList);
				closeSearchForm();
				ctrl.searchTile = true;
				ctrl.closeSearchTable = true;
			});
		};
		//close search table
		function doCloseSearchTable() {
			setTimeout(refreshTable(), 200);
			clearEmployeeData();
			ctrl.searchTile = false;
			ctrl.closeSearchTable = false;
		};

		// EXCEL EXPORT
		function exportExcel() {
			alert("Đang phát triển!");
		}

	})
})();