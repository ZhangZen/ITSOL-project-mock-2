(function () {
	'use strict';

	angular.module('invoiceModule').controller('invoiceCtrl', function invoiceCtrl(invoiceService) {
		var ctrl = this;
		fillDataTable();
		ctrl.invoiceList = []; // employee list in table
		ctrl.pageSize = 10; // pagination
		ctrl.lines = []; // list invoiceDetail in detailForm

		// --------------------DECLARE SHOW/HIDE FORM--------------------
		ctrl.formSearch = false;
		ctrl.formDetail = false;
		//ctrl.showFormSearch = showFormSearch; 
		
		// fill data into table
		function fillDataTable() {
			invoiceService.getAllInvoice().then(function (result) {
				console.log(result);
				ctrl.invoiceList = result;
				console.log(ctrl.invoiceList);
			});
		}
		
		ctrl.currentSelected;
		ctrl.current = current;
		function current(invoiceId){
			ctrl.currentSelected=invoiceId;
			console.log(ctrl.currentSelected);
			return invoiceId;
		}
//		
//		//select one checkbox
		ctrl.updateSelection = updateSelection;
		function updateSelection(position, invoiceList) {
			  angular.forEach(invoiceList, function(invoice, index) {
			    if (position != index) 
			    	invoice.checked = false;
			  });
			}
		
		
		
		//VIEW DETAIL
		ctrl.viewDetail = viewDetail;
		function viewDetail () {
			 ctrl.formSearch = false;
			 //console.log("AAAA");
			 console.log(ctrl.currentSelected);
			if(ctrl.currentSelected == null){
				alert("Hãy chọn 1 hóa đơn để xem!");
			}else{
				ctrl.formDetail = true;		
				console.log(ctrl.currentSelected);
				invoiceService.getInvoiceDetail(ctrl.currentSelected).then(function (result) {				
					console.log(ctrl.result);
					ctrl.lines = result;				
				});
				
			}						
		}
		
		
		//close formDetail
		ctrl.closeFormDetail = closeFormDetail; 
		function  closeFormDetail() {
			ctrl.formDetail = false;			
		}
		
		//------SEARCH INVOICE-------------
	
		//show formSearch
		ctrl.showFormSearch = showFormSearch; 		
	    function showFormSearch() {	  
	    	ctrl.formDetail = false;
	    	ctrl.formSearch = true;	
	    };
	    
	    // do search
	    ctrl.doSearch = doSearch; 
		function doSearch() {
			//console.log("AAAAA");
			console.log(ctrl.criteria);
			invoiceService.doSearch(ctrl.criteria).then(function (result) {				
				//console.log(result);
				ctrl.invoiceList = result;				
			});
		}
	
		//close formSearch
		ctrl.closeFormSearch = closeFormSearch; 		
		function closeFormSearch () {	  
	    	ctrl.criteria = null;
	    	ctrl.formSearch = false;	
	    	invoiceService.getAllInvoice().then(function (result) {
				//console.log(result);
				ctrl.invoiceList = result;
				//console.log(ctrl.invoiceList);
			});	    	
		}
  	
		
		//sort in table
		ctrl.sort = sort;
		function sort(keyname) {
			ctrl.sortKey = keyname;
			ctrl.reverse = !ctrl.reverse;
		};	
		
	})
})();