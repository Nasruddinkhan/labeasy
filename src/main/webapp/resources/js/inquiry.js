/**
 * 
 */
 
(function () {
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
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
   		 	
   		 }
	}
})();