package com.labeasy.services;

import java.util.List;

import com.labeasy.dto.InquiryDto;

/**
 * @author Nasruddin
 */
public interface InquiryService {
    /**
     * @param inquiryDto
     * @return
     */
    InquiryDto addInquiry(InquiryDto inquiryDto);

    /**
     * @param inqId
     * @return
     */
    InquiryDto findByInquiryId(Long inqId);

    /**
     * @param inquiryDto
     * @param inqId
     * @return
     */
    InquiryDto updateInquiry(InquiryDto inquiryDto, Long inqId);

    /**
     * @param inqId
     */
    void deleteInquiry(Long inqId);

    /***
     *
     * @return
     */
    List<InquiryDto> findAllInquires();
}
