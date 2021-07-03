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
	
	isValidateMobile = (fieldId, _msg) => {
		const rex = /^[6789]{1}[0-9]{9}$/
		const isInValid = rex.test($(fieldId).val());
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	
	isValidateEmail = (fieldId, _msg) => {
		const re = /^[a-zA-Z0-9.]{1,}@[a-z]{1,5}[a-z]{1,4}[.]{1}[a-z.]{1,3}[a-z]{1,4}$/
		const isInValid = re.test($(fieldId).val());
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	isLengthValidation = (fieldId, lengthSize, _msg) => {
		const fieldLength = parseInt($(fieldId).val().length);
		const isInValid = (fieldLength === lengthSize);
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	isMinValidation = (fieldId, miniSize, _msg) => {
		const fieldLength = parseInt($(fieldId).val().length);
		const isInValid = (fieldLength >= miniSize);
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	
	isMaxValidation = (fieldId,maxSize, _msg) => {
		const fieldLength = parseInt($(fieldId).val().length);
		const isInValid = (fieldLength <= maxSize);
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	isMinMaxValidation = (fieldId, minSize, maxSize, _msg) => {
		const fieldLength = parseInt($(fieldId).val().length);
		const isInValid = (fieldLength <= maxSize && fieldLength >= minSize);
		if (!isInValid)
			toastr.error(_msg);
		return isInValid;
	}
	isCharOnly = (evt)=> {
		var charCode = (evt.which) ? evt.which : event.keyCode
		if ((charCode == 32) || (charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122))
			return true;
		return false;
	}
})();