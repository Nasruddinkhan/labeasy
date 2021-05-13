/**
 * 
 */
 
(function () {

	addInquiry = function () {
		const inquiry = JSON.stringify($('#inqury-form').serializeObject());	
		var url = "/inquiry/save-inquiry";
		const callBackFunction = "addInquiryCreated";
		ajaxPostCall(url, callBackFunction, inquiry);
	}
	
	addInquiryCreated = function(response) {
	toastr.options.timeOut = 5000; // 1.5s
		if(response.inq_id >0){
			$('#inquiry-modal').modal('hide');
   		 	toastr.success('Inquiry save successfully!');
   		 	$('#inqury-form')[0].reset();
   		 	setTimeout(() =>{window.location.href="/labeasy/inquiry/show-inquiry-page"}, 5000);
   		 }
	}
})();