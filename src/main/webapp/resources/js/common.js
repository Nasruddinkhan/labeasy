/**
 * nasru common.js Apr 19, 2020
 */
(function() {
 toastr.options.timeOut = 1500;
	ajaxGetCall = function(url, callbackfunction) {
		var rootURL = window.location.origin;
		base_url = rootURL + myContextPath;
		$.ajax({
			headers : {
				'Content-Type' : 'application/json'
			},
			type : "GET",
			url : base_url + url,
			success : function(response) {
				window[callbackfunction](response);
			},
			error : function(e) {
				console.log("ERROR : ", e);
			}
		});
	}

	ajaxPostCall = function(url, callbackfunction, jsonObj) {
		var rootURL = window.location.origin;
		base_url = rootURL + myContextPath;
		$.ajax({
			headers : {
				'Content-Type' : 'application/json'
			},
			type : "POST",
			data : jsonObj,
			url : base_url + url,
			success : function(response) {
				window[callbackfunction](response);
			},
			error : function(e) {
				console.log("ERROR : ", e);
			}
		});
	}
	
	isEmpty = function(val) {
		return (val === undefined || val == null || val.length <= 0) ? true
				: false;
	}
	isNumberKey = function(evt) {
		var charCode = (evt.which) ? evt.which : event.keyCode
		if (charCode > 31 && (charCode < 48 || charCode > 57))
			return false;
		return true;
	}
	
	checkNAN = function(val) {
		if (isNaN(val)) {
			console.log("checkNAN");
			return 0;
		}
		return val;
	}
	
	successMsg = function(msg){
	  toastr.success(successMsg);
	}
     

	viewMemebers =function(memberId){
		$('#modal-default').modal('show');
		alert('viewMemebers'+memberId);
		$('#viewmember_id').html(memberId);
	}
})();