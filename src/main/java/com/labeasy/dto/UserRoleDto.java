package com.labeasy.dto;


import lombok.*;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDto  {

    @JsonProperty("role_id")
    private Long roleId;

    @JsonProperty("rolename")
    private String roleName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

}
