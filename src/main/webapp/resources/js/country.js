/**
 * 
 */
 
(function () {

	addCountry = function () {
		const country = JSON.stringify($('#country-form').serializeObject());	
	
		var url = "/master/add-country";
		const callBackFunction = "addCountryCreated";
		ajaxPostCall(url, callBackFunction, country);
	}
	
	addCountryCreated = function(response) {
	toastr.options.timeOut = 5000; // 1.5s
		if(response.country_id >0){
			$('#country-modal').modal('hide');
   		 	toastr.success('Country save successfully!');
   		 	$('#country-form')[0].reset();
   		 	setTimeout(() =>{window.location.href="/labeasy/master/show-country-page"}, 3000);
   		 }
	}
})();