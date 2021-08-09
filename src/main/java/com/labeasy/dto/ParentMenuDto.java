package com.labeasy.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParentMenuDto {
	
	private String menuUrl;
	private String styleClass;
	private String lableName;
	private boolean subMenu;
	private Set<ParentMenuDto> childmenu;
}
