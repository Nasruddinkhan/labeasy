/**
 * 
 */
 
(function () {
	addGroup = function () {
		const addGrp = JSON.stringify($('#add-group-form').serializeObject());	
		var url = "/master-test/add-test-group";
		const callBackFunction = "addGroupCreated";
		ajaxPostCall(url, callBackFunction, addGrp);
	}
	
	addGroupCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if(response.group_id >0){
			window.location.href="/labeasy/master-test/show-test-group";
			$('#test-group').modal('hide');
   		 	toastr.success('Test Group save successfully!');
   		 	$('#add-group-form')[0].reset();
   		 	
   		 }
	}
})();