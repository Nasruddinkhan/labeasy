/**
 * 
 */
(function() {
    selectTest = function(price, testId) {
        $(ApiConstant.BALANCE_ID).val(0);
        const totalAmout = parseFloat($(ApiConstant.TOTAL_AMT_ID).val());
        const testList = isChecked(ApiConstant.TEST_VAL + testId) ? isEmpty($(ApiConstant.TEST_LIST_ID).val()) ? addObjectInArray([], testId) : addObjectInArray(JSON.parse($(ApiConstant.TEST_LIST_ID).val()), testId) :
            isEmpty($(ApiConstant.TEST_LIST_ID).val()) ? [] : removeObjectFromArray(JSON.parse($(ApiConstant.TEST_LIST_ID).val()), testId);
        $(ApiConstant.TEST_LIST_ID).val(JSON.stringify(testList))
        const amt = isChecked(ApiConstant.TEST_VAL + testId) ? addition(totalAmout, price) : substraction(totalAmout, price);
        $(ApiConstant.TOTAL_AMT_ID).val(parseFloat(amt));
        $(ApiConstant.SELECTED_TEST_ID).val(testList.length);
        const paid_amt = parseFloat(isEmpty($(ApiConstant.PAID_AMT_ID).val()) ? 0 : $(ApiConstant.PAID_AMT_ID).val());
        const discount = parseFloat(isEmpty($(ApiConstant.DISCOUNT_ID).val()) ? 0 : $(ApiConstant.DISCOUNT_ID).val());
        const afterPaid = substraction(parseFloat($(ApiConstant.TOTAL_AMT_ID).val()), paid_amt)
        const afterDiscount = substraction(afterPaid, discount)
        $(ApiConstant.BALANCE_ID).val(parseFloat(afterDiscount));
    }
    discountAndPaidValidation = function(obj) {
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

    discountAndPaidAmmount = function(obj) {
        if (discountAndPaidValidation(obj)) {
        	 const totalAmout = parseFloat($(ApiConstant.TOTAL_AMT_ID).val());
        	 console.log(obj.id === 'discount')
        	 const paidAmmount = obj.id === 'discount' ?parseFloat(isEmpty($(ApiConstant.PAID_AMT_ID).val()) ? 0 : $(ApiConstant.PAID_AMT_ID).val())
        	 					 :  parseFloat(isEmpty($(ApiConstant.DISCOUNT_ID).val()) ? 0 : $(ApiConstant.DISCOUNT_ID).val());
        	 const amt = parseFloat(obj.value);
        	 const addAmount = addition(paidAmmount, amt);
        	 const balanceAmount = substraction(totalAmout, addAmount)
       		 $(ApiConstant.BALANCE_ID).val(parseFloat(balanceAmount));
        }
    }
})();