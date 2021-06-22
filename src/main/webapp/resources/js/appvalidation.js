/**
 * 
 */

(function() {
	console.log("working");
	toastr.options.timeOut = 5000; // 1.5s
	isFieldValidation = (fieldId, _msg) => {
		const isInValid = isEmpty($(fieldId).val());
		if (isInValid)
			toastr.error(_msg);
		return !isInValid;
	}
})();