package com.labeasy.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDto  {
	
	@JsonProperty("rolecode")
    private String roleCode;
	
    @JsonProperty("role_id")
    private Long roleId;
    
    @JsonProperty("roletype")
    private String roleType;

    @JsonProperty("rolename")
    private String roleName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

}
