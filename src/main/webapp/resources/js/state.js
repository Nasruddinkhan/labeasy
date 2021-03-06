/**
 * 
 */

(function() {

	addState = function() {
		if(validateStateForm()){
		const state = JSON.stringify($('#state-form').serializeObject());
		console.log(state);
		var url = "/master/add-state";
		const callBackFunction = "addStateCreated";
		ajaxPostCall(url, callBackFunction, state);
	}}

	addStateCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if (response.state_id > 0) {
			$('#state-modal').modal('hide');
			toastr.success('State save successfully!');
			$('#state-form')[0].reset();
			setTimeout(() => { window.location.href = "/labeasy/master/show-state-page" }, 3000);
		}
	}
	editState = function(stateId, stateName, countryId) {
		console.log(stateId, stateName, countryId);
		$('#state_id').val(stateId);
		$('#state_name').val(stateName);
		$('#country_id').val(countryId);
		$('#state-modal').modal('show');
	}
	validateStateForm = function() {
		const isValidStateName = isFieldValidation('#state_name', 'State name cannot be Empty');
		const isValidStateCode = isValidStateName ? isFieldValidation('#state_code', 'State Code cannot be Empty'):false;
		const isValidCountry = isValidStateCode ? isFieldValidation('#country_id', 'Please Select Country'):flase;
		return (isValidStateName && isValidStateCode && isValidCountry);
	}
})();