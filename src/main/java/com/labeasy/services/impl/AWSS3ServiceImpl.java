package com.labeasy.services.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.labeasy.services.AWSS3Service;
import com.labeasy.utils.CommonUtils;
@Service("awsS3service")
public class AWSS3ServiceImpl implements AWSS3Service {
	private final AmazonS3 amazonS3;

	@Autowired
	public AWSS3ServiceImpl(final AmazonS3 amazonS3) {
		super();
		this.amazonS3 = amazonS3;
	}

	@Override
	public String uploadFile(MultipartFile multipartFile, String bucketName, String endPointUrl) {
		// TODO Auto-generated method stub
		final File file = CommonUtils.convertMultiPartFileToFile(multipartFile);
		String returnURL = CommonUtils.uploadFileToS3Bucket(bucketName, file, amazonS3, endPointUrl);
		file.delete();
		return returnURL;
	}

	@Override
	public String uploadFile(File file, String bucketName, String endPointUrl) {
		// TODO Auto-generated method stub
		String returnURL = CommonUtils.uploadFileToS3Bucket(bucketName, file, amazonS3, endPointUrl);
		file.delete();
		return returnURL;
	}

}
