package com.labeasy.services.impl;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.TestGroupDto;
import com.labeasy.entity.TestGroup;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.TestGroupRepository;
import com.labeasy.services.TestGroupService;


@Service
@Transactional

public class TestGroupServiceImpl implements TestGroupService {

    private final TestGroupRepository testMasterRepository;

    /**
     * @param inquiryRepository
     */
    @Autowired
    public TestGroupServiceImpl(final TestGroupRepository testMasterRepository) {
        this.testMasterRepository = testMasterRepository;
    }
    

/*
    

    @Override
    public InquiryDto addInquiry(final InquiryDto inquiryDto) {
        Inquiry inquiry = map(inquiryDto, Inquiry.class);
        inquiry.setStatus(ApplicationStatus.ACTIVE.getValue());
        inquiry = inquiryRepository.save(inquiry);
        return map(inquiry, InquiryDto.class);
    }

    private Inquiry findInquiryById(final Long inqId) {
        return inquiryRepository.findById(inqId).orElseThrow(() ->
                new NotFoundException(ApplicationErrors.INQ_ID_NOT_FOUND.getValue()));
    }

    @Override
    public InquiryDto findByInquiryId(final Long inqId) {
        final Inquiry inquiry = findInquiryById(inqId);
        return map(inquiry, InquiryDto.class);
    }

    @Override
    public InquiryDto updateInquiry(final InquiryDto inquiryDto, final Long inqId) {
        findByInquiryId(inqId);
        inquiryDto.setInqId(inqId);
        return addInquiry(inquiryDto);
    }

    @Override
    public void deleteInquiry(final Long inqId) {
        final Inquiry inquiry = findInquiryById(inqId);
        inquiry.setStatus(ApplicationStatus.INACTIVE.getValue());
        inquiryRepository.save(inquiry);
    }

    @Override
    public List<InquiryDto> findAllInquires() {
        final List<Inquiry> inquiries = inquiryRepository.findByStatus(ApplicationStatus.ACTIVE.getValue());
        return mapAll(inquiries, InquiryDto.class);
    }*/

	@Override
	public TestGroupDto addTestGroup(TestGroupDto testGroupDto) {
		System.out.println("TestMasterServiceImpl.addTestGroup()");
		TestGroup testGroup = map(testGroupDto, TestGroup.class);
		testGroup.setStatus(ApplicationStatus.ACTIVE.getValue());
		testGroup = testMasterRepository.save(testGroup);
        return map(testGroup, TestGroupDto.class);
	}

	@Override
	public TestGroupDto findByTestGroupId(Long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestGroupDto updateTestGroup(TestGroupDto testGroupDto, Long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTestGroup(Long groupId) {
		
	}

	@Override
	public List<TestGroupDto> findAllTestGroup() {
        final List<TestGroup> testGroup = testMasterRepository.findByStatus(ApplicationStatus.ACTIVE.getValue());
        return mapAll(testGroup, TestGroupDto.class);
        
	}

    
	
	
    





}

