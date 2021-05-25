package com.labeasy.services.impl;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.TestNamesDto;
import com.labeasy.entity.TestNames;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.TestNamesRepository;
import com.labeasy.services.TestNamesService;

import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
public class TestNamesServiceImpl implements TestNamesService {

    private final TestNamesRepository testNamesRepository;
    
    @Autowired
    public TestNamesServiceImpl(final TestNamesRepository testNamesRepository) {
		this.testNamesRepository = testNamesRepository;
    }

	@Override
	public TestNamesDto addTestName(TestNamesDto testNamesDto) {
		System.out.println("TestMasterServiceImpl.addTestName()");		
		TestNames testNames = map(testNamesDto, TestNames.class);
		testNames.setStatus(ApplicationStatus.ACTIVE.getValue());
		testNames = testNamesRepository.save(testNames);
        return map(testNames, TestNamesDto.class);
		
	}

	@Override
	public TestNamesDto findByTestNameId(Long testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestNamesDto updateTestName(TestNamesDto testNameDto, Long testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTestName(Long testId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestNamesDto> findAllTestName() {
        final List<TestNames> testGroup = testNamesRepository.findByStatus(ApplicationStatus.ACTIVE.getValue());
        return mapAll(testGroup, TestNamesDto.class);
	}
	

     
    
}

