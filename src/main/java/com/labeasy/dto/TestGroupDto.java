package com.labeasy.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TestGroupDto {

	@JsonProperty("group_id")
    private Long groupId;
	@JsonProperty("name")
    private String name;
	@JsonProperty("description")
    private String description;
    @Column(name = "status" )
    private String status;
	
    
    
    
    
    
 



}
