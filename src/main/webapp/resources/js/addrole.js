/**
 * 
 */
 
(function () {

	addUserRole = function () {
		if(validateAddRoleForm()){
		const userRole = JSON.stringify($('#add-role-form').serializeObject());	
		var url = "/role-master/add-user-role";
		const callBackFunction = "addUserRoleFunc";
		ajaxPostCall(url, callBackFunction, userRole);
	}
	}
	addUserRoleFunc = function(response) {
	toastr.options.timeOut = 3000; // 1.5s
		if(response.role_id >0){
			$('#add-role-modal').modal('hide');
   		 	toastr.success('User Role saved successfully!');
   		 	$('#add-role-form')[0].reset();
   		 	setTimeout(() =>{window.location.href="/labeasy/role-master/show-user-role"}, 2000);
   		 }
	}
	
	deleteUserRole = function (roleId) {
		const userRole = JSON.stringify($('#add-role-form').serializeObject());	
		var url = "/role-master/delete-user-role";
		const callBackFunction = "deleteUserRoleFunc";
		ajaxPostCall(url, callBackFunction, userRole);
	}
	
	deleteUserRoleFunc = function(response) {
		toastr.options.timeOut = 3000; // 1.5s
		if(response.role_id >0){
			$('#add-role-modal').modal('hide');
   		 	toastr.success('User Role saved successfully!');
   		 	$('#add-role-form')[0].reset();
   		 	setTimeout(() =>{window.location.href="/labeasy/role-master/show-user-role"}, 2000);
   		 }
	}
	validateAddRoleForm = function() {
		const isValidRoleName = isFieldValidation('#rolename', 'Roll Name cannot be Empty');
		const isValiddescription = isValidRoleName ? isFieldValidation('#description', 'Description cannot be empty'):flase;
		
		return (isValidRoleName && isValiddescription);
	}
	roleEdit = function(roleId, roleCode, roleName, roleType, description) {
		$('#role_id').val(roleId);
		$('#rolecode').val(roleCode);
		$('#rolename').val(roleName);
		$('#description').val(description);
		$('#roletype').val(roleType);
		$('#add-role-modal').modal('show');
	}
})();