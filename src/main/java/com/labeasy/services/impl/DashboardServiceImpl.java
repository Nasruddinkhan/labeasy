package com.labeasy.services.impl;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labeasy.dto.ParentMenuDto;
import com.labeasy.entity.Menus;
import com.labeasy.repsoitory.MenuRepository;
import com.labeasy.services.DashboardService;
import com.labeasy.utils.ObjectUtilMapper;

@Service
public class DashboardServiceImpl implements DashboardService {

	private final MenuRepository menuRepository;

	@Autowired
	public DashboardServiceImpl(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@Override
	public Set<ParentMenuDto> findAllMenus() {
		// TODO Auto-generated method stub
		Set<ParentMenuDto> list = menuRepository.findAll().stream()
				.filter(m-> (Objects.isNull(m.getSubmenuId())  )).map(m-> getMenu(m)).collect(Collectors.toSet());
		System.out.println(list);
		return list;
	}

	private ParentMenuDto getMenu(Menus m) {
		// TODO Auto-generated method stub
		ParentMenuDto menu = ObjectUtilMapper.map(m, ParentMenuDto.class);
		Set<Menus> submenus = m.getChildmenu();
		Set<ParentMenuDto> dtoSubmenu = ObjectUtilMapper.mapAll(submenus, ParentMenuDto.class);
		menu.setChildmenu(dtoSubmenu);
		return menu;
	}

}
