package com.labeasy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Table(name = "menus")
@Setter
@Getter
public class Menus{
	
	@Id
	@Column(name = "menu_id",  length = 30)
	private String menuId;
	
	@Column(name = "menu_url",  length = 1000)
	private String menuUrl;
	
	@Column(name = "style_class",  length = 200)
	private String styleClass;
	
	@Column(name = "label_name",  length = 150)
	private String lableName;
	
	@Column(name = "sub_menu")
	private boolean subMenu;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="sub_menu_id")
	private Menus submenuId;

	@OneToMany(mappedBy="submenuId")
	private Set<Menus> childmenu = new HashSet<>();
	@Column(name = "menu_order")
	private int menuOrder;

}
