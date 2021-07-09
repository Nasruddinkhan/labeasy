/**
 * 
 */

(function() {

	addPinCode = function() {
		if (validatePinCodeForm()) {
			const pinCode = JSON.stringify($('#pincode-form').serializeObject());
			console.log(pinCode);
			var url = "/master/add-pincode";
			const callBackFunction = "addPinCodeCreated";
			ajaxPostCall(url, callBackFunction, pinCode);
		}
	}
	addPinCodeCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if (response.pin_id > 0) {
			$('#pincode-modal').modal('hide');
			toastr.success('Pin COde save successfully!');
			$('#pincode-form')[0].reset();
			setTimeout(() => { window.location.href = "/labeasy/master/show-pincode-page" }, 3000);
		}
	}
	viewCity = function(id) {
		var url = "/master/show-city/" + id;
		const callBackFunction = "showCity";
		ajaxGetCall(url, callBackFunction)

	}
	showCity = function(response) {
		$('.cityvalue').remove();
		if (response.length > 0) {
			$.each(response, function(i, response) {
				$('#cityId').append($('<option>', {
					value: response.city_id,
					text: response.city_name,
					class: 'cityvalue'
				}));

			});
		}
	}
	validatePinCodeForm = function() {
		const isValidPinCode = isFieldValidation('#pincode', 'PinCode cannot be Empty');
		const isValidPinCodeLength = isValidPinCode ? isMinValidation('#pincode', 5, 'Pincode Should be minimum 5 Digit'):false;
		const isValidAreaName = isValidPinCodeLength ? isFieldValidation('#area_name', 'Area Name cannot be Empty'):false;
		const isValidCountry = isValidAreaName ? isFieldValidation('#countryId', 'Please Select Country'):false;
		const isValidState = isValidCountry ? isFieldValidation('#stateId', 'Please Select State'):false;
		const isValidCity = isValidState ? isFieldValidation('#cityId', 'Please Select City'):false;
		return (isValidPinCodeLength && isValidPinCode && isValidAreaName && isValidCountry && isValidState && isValidCity);
	}

})
	();