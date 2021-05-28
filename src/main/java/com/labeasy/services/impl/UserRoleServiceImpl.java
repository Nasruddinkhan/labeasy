package com.labeasy.services.impl;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.InquiryDto;
import com.labeasy.dto.UserRoleDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Inquiry;
import com.labeasy.entity.UserRole;
import com.labeasy.enums.ApplicationErrors;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.InquiryRepository;
import com.labeasy.repsoitory.UserRoleRepository;
import com.labeasy.services.InquiryService;
import com.labeasy.services.UserRoleService;

/**
 * @author Nasruddin
 */
@Service
@Transactional

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    
    
    @Autowired
    public UserRoleServiceImpl(final UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    

	@Override
	public UserRoleDto addUserRole(UserRoleDto userRoleDto) {
		UserRole userRole = map(userRoleDto, UserRole.class);
		userRole.setStatus(ApplicationStatus.ACTIVE.getValue());
		userRole = userRoleRepository.save(userRole);
	   return map(userRole, UserRoleDto.class);
	}

	 private UserRole findUserRoleById(final Long roleId) {
	        return null;
	    }
	
	@Override
	public UserRoleDto findByRoleId(Long roleId) {
		final UserRole userRole = findUserRoleById(roleId);
        return map(userRole, UserRoleDto.class);
	}

	@Override
	public UserRoleDto updateUserRole(UserRoleDto userRoleDto, Long roleId) {
		findByRoleId(roleId);
		 userRoleDto.setRoleId(roleId);
	        return addUserRole(userRoleDto);
	}

	@Override
	public void deleteUserRole(Long roleId) {
		final UserRole userRole = findUserRoleById(roleId);
		userRole.setStatus(ApplicationStatus.INACTIVE.getValue());
        userRoleRepository.save(userRole);
		
	}

	@Override
	public List<UserRoleDto> findAllRoles() {
		 final List<UserRole> userRoles = userRoleRepository.findByStatus(ApplicationStatus.ACTIVE.getValue());
	        return mapAll(userRoles, UserRoleDto.class);
	}
}
