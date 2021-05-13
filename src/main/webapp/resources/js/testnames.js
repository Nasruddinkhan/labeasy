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
	
		addTestName = function () {
		const addTestName = JSON.stringify($('#add-test-form').serializeObject());	
		var url = "/master-test/add-test-name";
		const callBackFunction = "addNameCreated";
		ajaxPostCall(url, callBackFunction, addTestName);
	}
	
	addNameCreated = function(response) {
		toastr.options.timeOut = 5000; // 1.5s
		if(response.test_id >0){
			window.location.href="/labeasy/master-test/show-test-name";
			$('#test-name').modal('hide');
			
   		 	toastr.success('Test Name save successfully!');
   		 	$('#add-test-form')[0].reset();
   		 	
   		 }
	}
})();