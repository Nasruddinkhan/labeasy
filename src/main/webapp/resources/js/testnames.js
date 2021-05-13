/**
 * 
 */
 
(function () {
		addTestName = function () {
		const addTestName = JSON.stringify($('#add-test-form').serializeObject());	
		var url = "/master-test/add-test-name";
		const callBackFunction = "addNameCreated";
		ajaxPostCall(url, callBackFunction, addTestName);
	}
	
	addNameCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if(response.test_id >0){
			window.location.href="/labeasy/master-test/show-test-name";
			$('#test-name').modal('hide');
   		 	toastr.success('Test Name save successfully!');
   		 	$('#add-test-form')[0].reset();
   		 }
	}
})();