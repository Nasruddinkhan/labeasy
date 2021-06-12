/**
 * 
 */
(function () {
	var selectedtestList = [];
	var isChkAppointmentList = [];
	selectTest = function (price, testId, testName) {
		$(ApiConstant.BALANCE_ID).val(0);
		const totalAmout = parseFloat($(ApiConstant.TOTAL_AMT_ID).val());
		const testList = isChecked(ApiConstant.TEST_VAL + testId) ? isEmpty($(ApiConstant.TEST_LIST_ID).val()) ? addObjectInArray([], testId) : addObjectInArray(JSON.parse($(ApiConstant.TEST_LIST_ID).val()), testId) :
			isEmpty($(ApiConstant.TEST_LIST_ID).val()) ? [] : removeObjectFromArray(JSON.parse($(ApiConstant.TEST_LIST_ID).val()), testId);
		$(ApiConstant.TEST_LIST_ID).val(JSON.stringify(testList))
		selectedtestList = isChecked(ApiConstant.TEST_VAL + testId) ? addObjectInArray(selectedtestList, testName) : removeObjectFromArray(selectedtestList, testName);
		console.log(selectedtestList);
		const amt = isChecked(ApiConstant.TEST_VAL + testId) ? addition(totalAmout, price) : substraction(totalAmout, price);
		$(ApiConstant.TOTAL_AMT_ID).val(parseFloat(amt));
		$(ApiConstant.SELECTED_TEST_ID).val(testList.length);
		const paid_amt = parseFloat(isEmpty($(ApiConstant.PAID_AMT_ID).val()) ? 0 : $(ApiConstant.PAID_AMT_ID).val());
		const discount = parseFloat(isEmpty($(ApiConstant.DISCOUNT_ID).val()) ? 0 : $(ApiConstant.DISCOUNT_ID).val());
		const afterPaid = substraction(parseFloat($(ApiConstant.TOTAL_AMT_ID).val()), paid_amt)
		const afterDiscount = substraction(afterPaid, discount)
		$(ApiConstant.BALANCE_ID).val(parseFloat(afterDiscount));
	}
	discountAndPaidValidation = function (obj) {
		const selectTest = parseFloat($(ApiConstant.SELECTED_TEST_ID).val());
		if (!isNumericOnly(obj.value)) {
			validationErrorMsg(ApiConstant.NUMERIC_VAL_MSG);
			$(ApiConstant.DARK_AGES + obj.id).val('');
			return false;

		} else if (selectTest <= 0) {
			validationErrorMsg(ApiConstant.TEST_NOT_SELECTED);
			$(ApiConstant.DARK_AGES + obj.id).val('')
			return false;
		}
		return true;
	}
	setOnLoadData = function (appId, testList, selectedTestName) {
		console.log(selectedTestName);
		const appointmentId = parseInt(appId);
		if (appointmentId > 0) {
			const tests = JSON.parse(testList)
			selectedTestName.substring(1, selectedTestName.length-1).split(",").forEach(ele=>selectedtestList.push(ele.trim()));
			console.log(selectedtestList);
			$(ApiConstant.SELECTED_TEST_ID).val(tests.length);
			tests.forEach(ele => isCheckedSelectedTest(ele));
		} else {
			$(ApiConstant.TOTAL_AMT_ID).val(0)

		}

	}
	isCheckedSelectedTest = function (testId) {
		console.log("#test" + testId);
		$("#test" + testId).prop('checked', true);
	}
	discountAndPaidAmmount = function (obj) {
		if (discountAndPaidValidation(obj)) {
			const totalAmout = parseFloat($(ApiConstant.TOTAL_AMT_ID).val());
			console.log(obj.id === 'discount')
			const paidAmmount = obj.id === 'discount' ? parseFloat(isEmpty($(ApiConstant.PAID_AMT_ID).val()) ? 0 : $(ApiConstant.PAID_AMT_ID).val()) :
				parseFloat(isEmpty($(ApiConstant.DISCOUNT_ID).val()) ? 0 : $(ApiConstant.DISCOUNT_ID).val());
			const amt = parseFloat(obj.value);
			const addAmount = addition(paidAmmount, amt);
			const balanceAmount = substraction(totalAmout, addAmount)
			$(ApiConstant.BALANCE_ID).val(parseFloat(balanceAmount));
		}
	}
	clearDue = function (appId) {

		var url = "/appointment/cleardue?appId=" + appId + "&paymentmode=" + ($('#paymentmode').val());
		const callBackFunction = "crearDueRes";
		ajaxGetCall(url, callBackFunction);
	}

	crearDueRes = function (response) {
		parent.$.fancybox.close();
		toastr.options.timeOut = 5000; // 1.5s
		toastr.success('clear due ammount successfully!');
		setTimeout(() => {
			window.location.replace("http://localhost:8087/labeasy/appointment/view-appointment-page")
		}, 5000);
	}
	changeStatus = function (obj) {
		$("#assignUser").val('');
		$("#assign_to").css("display", obj.value === 'AP' ? "block" : "none");
		if ($('#assign_to').is(':visible')) {
			var url = "/user-master/get-phlebotomist";
			const callBackFunction = "getAllPhlebotomistList";
			ajaxGetCall(url, callBackFunction);
		}
	}
	getAllPhlebotomistList = function (response) {
		var assignTo = $("#assignUser");
		assignTo.empty()
		$.each(response, function () {
			assignTo.append($("<option></option>").val(this['key']).html(
				this['value']));
		});
	}
	isCheckAppointment = function (appointmentId) {
		isChkAppointmentList = isChecked("appChk" + appointmentId) ?
			addObjectInArray(isChkAppointmentList, appointmentId) :
			removeObjectFromArray(isChkAppointmentList, appointmentId);
	}
	updateAppointmentStatus = function () {
		const appointments = $('#update-appointment-status').serializeObject();
		appointments["appointment"] = isChkAppointmentList;

		var url = "/appointment/update-appointment-status";
		const callBackFunction = "updateAppointmentStatusRes";
		ajaxPostCall(url, callBackFunction, JSON.stringify(appointments));
	}
	updateAppointmentStatusRes = function (response) {
		toastr.options.timeOut = 5000; // 1.5s
		toastr.success('update appointment successfully!');
		$('#update-appointment-status')[0].reset();
		setTimeout(() => {
			window.location.href = "/labeasy/appointment/view-appointment-page"
		}, 5000);

	}
	testItems = function () {
	  var tblRow ='';
	  $("#tbl").empty();
		selectedtestList.forEach(ele => {
			tblRow += "<tr><td>"+ ele +"</td></tr>" ;
		});
		 $("#tbl").append(tblRow);    
		$('#select-test-modal').modal('show');
	}
})();