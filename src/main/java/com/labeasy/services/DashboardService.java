package com.labeasy.services;

import java.util.Set;

import com.labeasy.dto.ParentMenuDto;

public interface DashboardService {

	Set<ParentMenuDto> findAllMenus();

}
