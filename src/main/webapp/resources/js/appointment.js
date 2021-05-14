/**
 * 
 */
(function() {
    selectTest = function(price, testId) {
   		 $('#balance_id').val(0);
        const totalAmout = parseFloat($('#total_amt').val());
        const testList =  isChecked('test' + testId) ? isEmpty($('#testList').val()) ? addObjectInArray([], testId) : addObjectInArray(JSON.parse($('#testList').val()), testId)
        				: isEmpty($('#testList').val()) ? [] : removeObjectFromArray(JSON.parse($('#testList').val()), testId);
      	$('#testList').val(JSON.stringify(testList))
        const amt = isChecked('test' + testId) ? addition(totalAmout, price) : substraction(totalAmout, price);
        $('#total_amt').val(parseFloat(amt));
        $('#selected_test').val(testList.length);   
     	const paid_amt = parseFloat(isEmpty($('#paid_amt').val())?0:$ ('#paid_amt').val());
     	const discount = parseFloat(isEmpty($('#discount').val())?0:$ ('#discount').val());
     	console.log(paid_amt);
     	console.log(discount);
     	const afterPaid = substraction(parseFloat($('#total_amt').val()), paid_amt) 
     	console.log(afterPaid);
     	const afterDiscount = substraction(afterPaid, discount) 
     	console.log(afterDiscount);
     	$('#balance_id').val(parseFloat(afterDiscount));
    }
 
})();