package com.labeasy.services.impl;
import static com.labeasy.utils.ObjectUtilMapper.map;
import static com.labeasy.utils.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labeasy.dto.InquiryDto;
import com.labeasy.eception.NotFoundException;
import com.labeasy.entity.Inquiry;
import com.labeasy.enums.ApplicationErrors;
import com.labeasy.enums.ApplicationStatus;
import com.labeasy.repsoitory.InquiryRepository;
import com.labeasy.services.InquiryService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nasruddin
 */
@Service
@Transactional
@Slf4j
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    /**
     * @param inquiryRepository
     */
    @Autowired
    public InquiryServiceImpl(final InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    /**
     * @param inquiryDto
     * @return
     */
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

    /**
     * @param inqId
     * @return
     */
    @Override
    public InquiryDto findByInquiryId(final Long inqId) {
        final Inquiry inquiry = findInquiryById(inqId);
        return map(inquiry, InquiryDto.class);
    }

    /**
     * @param inquiryDto
     * @param inqId
     * @return
     */
    @Override
    public InquiryDto updateInquiry(final InquiryDto inquiryDto, final Long inqId) {
        findByInquiryId(inqId);
        inquiryDto.setInqId(inqId);
        return addInquiry(inquiryDto);
    }

    /**
     * @param inqId
     */
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
    }
}
