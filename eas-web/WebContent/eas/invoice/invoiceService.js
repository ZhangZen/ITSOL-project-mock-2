angular.module('invoiceModule', ['restangular', 'angularUtils.directives.dirPagination'])
.factory('invoiceService', function (Restangular) {
	var factory = {
		getAllInvoice: getAllInvoice,
		doSearch: doSearch,
		getInvoiceDetail: getInvoiceDetail,
		getOneProduct: getOneProduct,
		getAllProduct: getAllProduct,
		createInvoice: createInvoice,
		createInvoiceDetail: createInvoiceDetail,
		updateProduct: updateProduct,
		
	};
	return factory;
	
	//service for invoice controller
	function getAllInvoice() {
		return Restangular.all('eas-service/intern05Invoice/intern05Invoice').getList();
	}
	
	function doSearch(criteria) {
		return Restangular.all('eas-service/intern05Invoice/intern05Invoice/search').post(criteria);
	}
	
	function getInvoiceDetail(invoiceId) {
		return Restangular.all('eas-service/intern05InvoiceDetail/intern05InvoiceDetail').get(invoiceId);
	}
	
	
	//service for create invoice
	function getOneProduct(productId) {
		return Restangular.one('eas-service/intern05Product/intern05Product', productId).get();
	}
	
	function getAllProduct() {
		return Restangular.all('eas-service/intern05Product/intern05Product').get();
	}
	
	function createInvoice(invoice) {
		return Restangular.one('eas-service/intern05Invoice/intern05Invoice').customPOST(invoice);
	}

	function createInvoiceDetail(invoiceDetail) {
		return Restangular.all('eas-service/intern05InvoiceDetail/intern05InvoiceDetail').customPOST(invoiceDetail);
	}
	
	function updateProduct(product) {
		return Restangular.all('eas-service/intern05Product/intern05Product').customPUT(product);
	}
	
	
	
});