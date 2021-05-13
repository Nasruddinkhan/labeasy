package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.TestNamesDto;


public interface TestNamesService {

	TestNamesDto addTestName(TestNamesDto testNamesDto);
	TestNamesDto findByTestNameId(Long testId);
	TestNamesDto updateTestName(TestNamesDto testNameDto, Long testId);
    void deleteTestName(Long testId);
    List<TestNamesDto> findAllTestName();
    
    
    
    
    
}
