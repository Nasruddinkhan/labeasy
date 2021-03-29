/**
 * nasru common.js Apr 19, 2020
 */
(function() {
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
	sateList = function(response) {
		var memberState = $("#memberstate");
		memberState
				.empty()
				.append(
						'<option selected="selected" value="">Please select state</option>');
		$.each(response, function() {
			memberState.append($("<option></option>").val(this['key']).html(
					this['value']));
		});
	}
	cityList = function(response) {
		var memberCity = $("#membercity");
		memberCity
				.empty()
				.append(
						'<option selected="selected" value="">Please select city</option>');
		$.each(response, function() {
			memberCity.append($("<option></option>").val(this['key']).html(
					this['value']));
		});
	}
	pincodeList = function(response){
		 $("#pinCode").val(response);
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
	/*
	 * ajaxindicatorstart = function () { var rootURL = window.location.origin;
	 * base_url = rootURL + myContextPath; var imagePath =
	 * base_url+"/resources/img/ajax-loader.gif" var endicator = '<div
	 * id="resultLoading" style="display:none;"><div><img style="position:
	 * absolute;margin-left:50%;" name="spinner" src="'+imagePath+'" ><div
	 * style="color:red" ></div></div><div class="bg"></div></div>'
	 * console.log("endicator [" + endicator + "]"); if
	 * ($('body').find('#resultLoading').attr('id') != 'resultLoading') {
	 * $('body').append(endicator); } $('#resultLoading').css({ 'position' :
	 * 'fixed', 'z-index' : '10000000', 'top' : '0', 'left' : '0', 'right' :
	 * '0', 'bottom' : '0', 'margin' : 'auto' }); $('#resultLoading .bg') .css( {
	 * 'background' : 'gray', 'ms-filter' :
	 * 'progid:DXImageTransform.Microsoft.Alpha(Opacity=50)', IE 8 'filter' :
	 * 'alpha(opacity=50)', IE 5-7 '-moz-opacity' : '0.5', Netscape
	 * '-khtml-opacity' : ' 0.5', Safari 1.x 'opacity' : ' 0.5', Good browsers
	 * 'width' : '100%', 'height' : '100%', 'position' : 'absolute', 'top' : '0'
	 * }); $('#resultLoading>div:first').css({ 'text-align' : 'center',
	 * 'position' : 'fixed', 'top' : '26%', 'left' : '0', 'right' : '0',
	 * 'bottom' : '0', 'margin' : 'auto', 'font-size' : '16px', 'z-index' :
	 * '10', 'color' : '#ffffff' }); $('#resultLoading .bg').height('100%');
	 * $('#resultLoading').fadeIn(500); $('body').css('cursor', 'wait'); }
	 */
	viewMemebers =function(memberId){
		$('#modal-default').modal('show');
		alert('viewMemebers'+memberId);
		$('#viewmember_id').html(memberId);
	}
})();