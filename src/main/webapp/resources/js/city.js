/**
 * 
 */

(function() {

	addCity = function() {
		if (validateCityForm()) {
			const city = JSON.stringify($('#city-form').serializeObject());
			console.log(city);
			var url = "/master/add-city";
			const callBackFunction = "addCityCreated";
			ajaxPostCall(url, callBackFunction, city);
		}
		
	}

	addCityCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if (response.city_id > 0) {
			$('#city-modal').modal('hide');
			toastr.success('City save successfully!');
			$('#city-form')[0].reset();
			setTimeout(() => { window.location.href = "/labeasy/master/show-city-page" }, 3000);
		}
	}
	viewState = async function(id) {
		console.log('1');

		var url = "/master/show-state/" + id;
		const callBackFunction = "showState";
		await ajaxGetCall(url, callBackFunction)

	}
	showState = async function(response) {
		$('.statevalue').remove();
		if (response.length > 0) {
			$.each(response, function(i, response) {
				$('#stateId').append($('<option>', {
					value: response.state_id,
					text: response.state_name,
					class: 'statevalue'
				}));

			});
		}
	}
	validateCityForm = function() {
		const isValidCityName = isFieldValidation('#name', 'City name cannot be Empty');
		const isValidCountry = isValidCityName ? isFieldValidation('#countryId', 'Please Select Country'):flase;
		const isValidState = isValidCountry ? isFieldValidation('#stateId', 'Please Select State'):flase;
		return (isValidCityName && isValidCountry && isValidState);
		console.log('2');
	}

	cityEdit =  function(cityId, countryId, cityName, stateId) {
		 viewState(countryId).then(() => {
			console.log('3');

			$('#countryId').val(countryId);
			$('#city_id').val(cityId);
			$('#city_name').val(cityName);
			$('#stateId').val(stateId);
			$('#city-modal').modal('show');
		}

		);
	}

})();