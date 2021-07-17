/**
 * 
 */

(function() {
	addTestName = function() {
		if (validateTestNameForm()) {
			const addTestName = JSON.stringify($('#add-test-form').serializeObject());
			var url = "/master-test/add-test-name";
			const callBackFunction = "addNameCreated";
			ajaxPostCall(url, callBackFunction, addTestName);
		}
	}
	addNameCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if (response.test_id > 0) {
			window.location.href = "/labeasy/master-test/show-test-name";
			$('#test-name').modal('hide');
			toastr.success('Test Name save successfully!');
			$('#add-test-form')[0].reset();
		}
	}
	validateTestNameForm = function() {
		const isValidTestCode = isFieldValidation('#testcode', 'Test Code cannot be Empty');
		const isValidTestName = isValidTestCode ? isFieldValidation('#name', 'Test Name Cannot Be Empty'):false;
		const isValidDescription = isValidTestName ? isFieldValidation('#description', 'Description Cannot Be Empty'):false;
		const isValidPrice = isValidDescription ? isFieldValidation('#price', 'Price Cannot Be Empty'):false;
		const isValidB2BPrice = isValidPrice ? isFieldValidation('#b2bprice', 'B2B Price Cannot Be Empty'):false;
		return (isValidTestCode && isValidTestName && isValidDescription && isValidPrice && isValidB2BPrice);
	}
	
	testNameEdit = function(testId, groupId, testcode, name, description, price, b2bprice) {
		$('#add-test-form')[0].reset();
		$('#test_id').val(testId);
		$('#groupId').val(groupId);
		$('#testcode').val(testcode);
		$('#name').val(name);
		$('#description').val(description);
		$('#price').val(price);
		$('#b2bprice').val(b2bprice);
		
		//$("#test_grp_btn_add").html('Update');
		$('#test-name').modal('show');
	}
})();