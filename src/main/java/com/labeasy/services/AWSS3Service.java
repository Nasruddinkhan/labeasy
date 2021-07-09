package com.labeasy.services;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {
	String uploadFile(MultipartFile multipartFile, String bucketName, String endPointUrl);

	String uploadFile(File file, String bucketName, String endPointUrl);
}
