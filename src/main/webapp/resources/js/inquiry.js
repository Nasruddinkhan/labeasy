/**
 * 
 */
(function() {

	addInquiry = function() {
		if (validateInquiryForm()) {
			const inquiry = JSON.stringify($('#inqury-form').serializeObject());
			var url = "/inquiry/save-inquiry";
			const callBackFunction = "addInquiryCreated";
			ajaxPostCall(url, callBackFunction, inquiry);
		}
	}

	addInquiryCreated = function(response) {
		console.log(response);
		toastr.options.timeOut = 5000; // 1.5s
		if (response.inq_id > 0) {
			$('#inquiry-modal').modal('hide');
			toastr.success('Inquiry save successfully!');
			$('#inqury-form')[0].reset();
			setTimeout(() => { window.location.href = "/labeasy/inquiry/show-inquiry-page" }, 5000);
		}
	}

	validateInquiryForm = function() {
		const isValidName = isFieldValidation('#name', 'Name cannot be Empty');
		const isValidEmptyNumber = isValidName ? isFieldValidation('#mobile_no', 'Mobile no cannot be Empty'):false;
		const isValidMobileMinLength = isValidEmptyNumber ? isMinValidation('#mobile_no',10,'Mobile Number Must Be Atleast 10 Digit') : false;
		const isValidMobileNumber = isValidMobileMinLength ? isValidateMobile('#mobile_no', 'Number must start from 9 to 6') : false;
		const isValidEmptyEmail = isValidMobileNumber ? isFieldValidation('#email_id', 'Email cannot be Empty'):flase;
		const isValidEmail = isValidEmptyEmail ? isValidateEmail('#email_id', 'Enter Proper Email') : false;
		const isValidRemark = isValidEmail ? isFieldValidation('textarea#remarks', 'Remark Cannot be Empty'):false;
		return (isValidMobileNumber && isValidMobileMinLength && isValidName && isValidEmptyNumber && isValidEmptyEmail && isValidEmail && isValidRemark);
	}
	
	inquiryEdit = function(inqId, inqName, inqMobile, inqEmail, inqRemarks) {
		$('#inq_id').val(inqId);
		$('#name').val(inqName);
		$('#mobile_no').val(inqMobile);
		$('#email_id').val(inqEmail);
		$('textarea#remarks').val(inqRemarks);
		$("#inq_btn_add").html('Update');
		$('#inquiry-modal').modal('show');
	}
	
	activitiesHistory = function() {
		var tblRow = '';
		$("#tbl").empty();
		/*selectedtestList.forEach(ele => {
			tblRow += "<tr><td>" + ele + "</td></tr>";
		});*/
		$("#tbl").append(tblRow);
		$('#activities-history-modal').modal('show');
	}
})();

