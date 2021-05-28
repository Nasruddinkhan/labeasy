package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.UserRoleDto;


public interface UserRoleService {

    UserRoleDto addUserRole(UserRoleDto userRoleDto);


    UserRoleDto findByRoleId(Long roleId);


    UserRoleDto updateUserRole(UserRoleDto userRoleDto, Long roleId);


    void deleteUserRole(Long roleId);


    List<UserRoleDto> findAllRoles();
}
