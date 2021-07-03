/**
 * 
 */

(function() {

	addCountry = function() {
		if (validateCountryForm()) {
			const country = JSON.stringify($('#country-form').serializeObject());

			var url = "/master/add-country";
			const callBackFunction = "addCountryCreated";
			ajaxPostCall(url, callBackFunction, country);
		}
	}
	addCountryCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if (response.country_id > 0) {
			$('#country-modal').modal('hide');
			toastr.success('Country save successfully!');
			$('#country-form')[0].reset();
			setTimeout(() => { window.location.href = "/labeasy/master/show-country-page" }, 3000);
		}
	}
	validateCountryForm = function() {
		const isValidCountryName = isFieldValidation('#country_name', 'Country Name cannot be Empty');
		const isValidCountryCode = isValidCountryName ? isFieldValidation('#country_code', 'Country Code cannot be Empty'):false;
		return (isValidCountryName && isValidCountryCode);
	}
})();