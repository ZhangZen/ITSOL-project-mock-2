angular.module('employeePart', ['restangular', 'angularUtils.directives.dirPagination', 'ngMaterial', 'ngMessages']).config(function (RestangularProvider) {
	RestangularProvider.setBaseUrl('http://localhost:8084/eas-service/');
	RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
		var extractedData;
		if (operation === "getList") {
			extractedData = data.data;
		} else {
			extractedData = data;
		}
		return extractedData;
	});
}).factory('employeeService', function (Restangular) {
	var factory = {
		getAllEmployee: getAllEmployee,
		getOneById: getOneById,
		createNewEmployee: createNewEmployee,
		updateEmployee: updateEmployee,
		doSearch: doSearch,
		deleteById: deleteById,
		getAllEthnic: getAllEthnic,
		getAllCity: getAllCity,
//		getAllCityString: getAllCityString,
		getAllDepartment: getAllDepartment,
		getAllPosition: getAllPosition,
		getAllLiteracy: getAllLiteracy,
		getAllSalary: getAllSalary,
		getSalaryById: getSalaryById
	};
	return factory;

	// PREFIX URL
//	var prefixURL = "http://localhost:8084/eas-service/";

	// BASE URL
//	var employeeServiceBaseURL = "intern05EmployeeServiceRest/intern05Employee/";
//	var literacyServiceBaseURL = "intern05LiteracyServiceRest/intern05Literacy/";
//	var departmentServiceBaseURL = "intern05DepartmentServiceRest/intern05Department/";
//	var positionServiceBaseURL = "intern05PositionServiceRest/intern05Position/";
//	var salaryServiceBaseURL = "intern05SalaryServiceRest/intern05Salary/";

	// REST SERVICE

	function getAllEmployee() {
		return Restangular.all('intern05EmployeeServiceRest/intern05Employee/getAll').getList();
	}

	function getOneById(emId) {
		return Restangular.one('intern05EmployeeServiceRest/intern05Employee/searchById', emId).get();
	}

	function createNewEmployee(employee) {
		return Restangular.one('intern05EmployeeServiceRest/intern05Employee/addNew').customPOST(employee);
	}

	function updateEmployee(employee) {
		return Restangular.one('intern05EmployeeServiceRest/intern05Employee/update').customPUT(employee);
	}

	function doSearch(employee) {
		return Restangular.all('intern05EmployeeServiceRest/intern05Employee/search').post(employee);
	}

	function deleteById(emId) {
		return Restangular.one('intern05EmployeeServiceRest/intern05Employee/delete', emId).remove();
	}

	function getAllEthnic() {
		return Restangular.all('intern05EmployeeServiceRest/intern05Employee/getAllEthnicName').getList();
	}

	function getAllCity() {
		return Restangular.all('intern05EmployeeServiceRest/intern05Employee/getAllCitiesName').getList();
	}
	
//	function getAllCityString() {
//		return Restangular.one('intern05EmployeeServiceRest/intern05Employee/getAllCitiesNameString').get();
//	}

	function getAllDepartment() {
		return Restangular.all('intern05DepartmentServiceRest/intern05Department/getAll').getList();
	}

	function getAllPosition() {
		return Restangular.all('intern05PositionServiceRest/intern05Position/getAll').getList();
	}

	function getAllLiteracy() {
		return Restangular.all('intern05LiteracyServiceRest/intern05Literacy/getAll').getList();
	}

	function getAllSalary() {
		return Restangular.all('intern05SalaryServiceRest/intern05Salary/getAll').getList();
	}

	function getSalaryById(saLevel) {
		return Restangular.one('intern05SalaryServiceRest/intern05Salary/searchById', saLevel).get();
	}
	
});