package com.labeasy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Messages {
   	private final  MessageSource messageSource;
   	@Autowired
	private Messages(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public  String get(String key) {
		return messageSource.getMessage(key, null, null);
	}
}
