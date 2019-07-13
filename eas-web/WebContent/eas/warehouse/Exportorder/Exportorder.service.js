/**
 * 
 */
angular.module('exportOrder', ['restangular', 'angularUtils.directives.dirPagination', 'ngMaterial', 'ngMessages']).config(function (RestangularProvider) {
	
	RestangularProvider.setBaseUrl('http://localhost:8084/eas-service/');
}).factory('exportorderService', function (Restangular){
	var factory = {
			getAllEx : getAllEx,
			getAllPr : getAllPr,
			getAllPrCa: getAllPrCa,
			getAllEm: getAllEm,
			changePrcategory : changePrcategory,
			changeProduct: changeProduct,
			getOneById: getOneById,
			create: create,
			update: update,
			deleteObj: deleteObj,
			doSearch: doSearch
	};
	return factory;
	
	function getAllEx(){
		return Restangular.all('intern05Exportorder/getAllEX').getList();
	}
	
	function getAllPrCa(){
		return Restangular.all('intern05Exportorder/getAllPrCa').getList();
	}
	
	function getAllEm(){
		return Restangular.all('intern05Exportorder/getEmployee').getList();
	}
	
	function getAllPr (){
		return Restangular.all('intern05Statistics/getAllProduct').getList();
	}
	
	function changePrcategory (prId){
		return Restangular.one('intern05Exportorder/getPrcListByPrId', prId).get();
	}
	
	function changeProduct(prCategoryId){
		return Restangular.all('intern05Exportorder/getProductListByPrcId' , prCategoryId).getList();
	}
	
	function getOneById(exId){
		return Restangular.one('intern05Exportorder/findById', exId).get();
	}
	
	function create(exportorder){
		return Restangular.one('intern05Exportorder/Create').customPOST(exportorder);
	}
	
	function update(exportorder){
		return Restangular.one('intern05Exportorder/update').customPUT(exportorder);
	}
	
	function doSearch(exportorder){
		return Restangular.all('intern05Exportorder/doSearch').post(exportorder);
	}
	
	function deleteObj (exId){
		return Restangular.one('intern05Exportorder/delete', exId).remove();
	}
})
	
	
	
	
	
