package com.labeasy.dto;

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
public class TestNamesDto {
    
    @JsonProperty("test_id")
    private Long testId;
    @JsonProperty("groupId")
	private Long groupId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("testcode")
    private String testcode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
	private Long price;
    @JsonProperty("b2bprice")
	private Long b2bprice;
    @JsonProperty("status")
    private String status;

}
