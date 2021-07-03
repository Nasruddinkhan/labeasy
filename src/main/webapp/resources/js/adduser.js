(function() {
	validateAddUser = function() {
		debugger;
		const isValidFirstName = isFieldValidation('#firstName', 'First Name must be Entered');
		const isValidLastName = isValidFirstName ? isFieldValidation('#lastName', 'Last Name cannot be Empty'):false;
		const isValidFatherName = isValidLastName ? isFieldValidation('#fatherSpouseName', 'Father/Spouse Name cannot be Empty'):false;
		const isValidGender = isValidFatherName ? isFieldValidation('#gender', 'Gender cannot be Empty'):false;
		const isValidDOB = isValidGender ? isFieldValidation('#userDob', 'Date Of Birth cannot be Empty'):false;
		const isValidDOJ = isValidDOB ? isFieldValidation('#userDoj', 'Date Of Joining cannot be Empty'):false;
		const isValidMobile = isValidDOJ ? isFieldValidation('#mobileNo', 'Mobile cannot be Empty'):false;
		const isValidMobileMinLength = isValidMobile ? isMinValidation('#mobileNo', 10, 'Mobile Number Must Be Atleast 10 Digit'):false;
		const isValidMobileNumber = isValidMobileMinLength ? isValidateMobile('#mobileNo', 'Number must start from 9 to 6'):false;
		const isValidEmptyEmail = isValidMobileNumber ? isFieldValidation('#emailId', 'Email cannot be Empty') : false;
		const isValidEmail = isValidEmptyEmail ? isValidateEmail('#emailId', 'Enter Proper Email') : false;
		const isValidAadhar = isValidEmail ? isFieldValidation('#adharCardNo', 'Aadhar No cannot be Empty') : false;
		const isValidPanCard = isValidAadhar ? isFieldValidation('#panCardNo', 'Pan Card cannot be Empty') : false;
		const isValidAddressLine1 = isValidPanCard ? isFieldValidation('#addressLine1', 'Address cannot be Empty') : false;
		const isValidCity = isValidAddressLine1 ? isFieldValidation('#city', 'City cannot be Empty') : false;
		const isValidPincode = isValidCity ? isFieldValidation('#pinCode', 'Pincode cannot be Empty') : false;
		const isValidState = isValidPincode ? isFieldValidation('#state', 'State cannot be Empty') : false;
		const isValidCountry = isValidState ? isFieldValidation('#country', 'Country cannot be Empty') : false;
		const isValidRole = isValidCountry ? isFieldValidation('#roleId', 'Please Select Role for User') : false;
		const isValidReporting = isValidRole ? isFieldValidation('#reportingUserId', 'Please Select Reporting Person') : false;
		

		return (isValidFirstName && isValidLastName && isValidFatherName && isValidGender && isValidDOB && isValidDOJ && isValidMobile
			&& isValidMobileMinLength && isValidMobileNumber && isValidEmptyEmail && isValidEmail && isValidAadhar && isValidPanCard
			&& isValidAddressLine1 && isValidCity && isValidPincode && isValidState && isValidCountry && isValidRole && isValidReporting);
	}
})();