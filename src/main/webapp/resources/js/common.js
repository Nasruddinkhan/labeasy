/**
 * nasru common.js Apr 19, 2020
 */
(function() {
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
     
   isChecked = function(id) {
        return $('#' + id).is(":checked");
    }
    addition = function(no1, no2) {
        return (no1 + no2);
    }

    substraction = function(no1, no2) {
        return (no1 - no2);
    }
    addObjectInArray = function(objList, obj) {
        objList.push(obj);
        return [...new Set(objList)] ;
    }
  
    removeObjectFromArray = function(objList, obj) {
        const index = objList.indexOf(obj);
        if (index > -1) {
            objList.splice(index, 1);
        }
        return  [...new Set(objList)];
    }
	viewMemebers =function(memberId){
		$('#modal-default').modal('show');
		alert('viewMemebers'+memberId);
		$('#viewmember_id').html(memberId);
	}
})();