package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.TestGroupDto;


public interface TestGroupService {

	TestGroupDto addTestGroup(TestGroupDto testGroupDto);
	TestGroupDto findByTestGroupId(Long groupId);
    TestGroupDto updateTestGroup(TestGroupDto testGroupDto, Long groupId);
    void deleteTestGroup(Long groupId);
    List<TestGroupDto> findAllTestGroup();
    
    
  
    
    
    
    
    
}
