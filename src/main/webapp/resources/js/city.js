/**
 * 
 */

(function() {

	addCity = function() {
		const city = JSON.stringify($('#city-form').serializeObject());
		console.log(city);

		var url = "/master/add-city";
		const callBackFunction = "addCityCreated";
		ajaxPostCall(url, callBackFunction, city);
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
	viewState = function(id) {
		var url = "/master/show-state/" + id;
		const callBackFunction = "showState";
		ajaxGetCall(url, callBackFunction)

	}
	showState = function(response) {
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

})();