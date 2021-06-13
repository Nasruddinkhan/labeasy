package com.labeasy.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.labeasy.dto.UserDto;
import com.labeasy.event.OnUserRegistrationCompleteEvent;
@Component
public class UserRegistrationListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

	@Override
	public void onApplicationEvent(OnUserRegistrationCompleteEvent event) {
		// TODO Auto-generated method stub
		System.out.println("UserRegistrationListener.onApplicationEvent()");
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnUserRegistrationCompleteEvent event) {
		// TODO Auto-generated method stub
		UserDto dto = event.getDto();
		System.out.println("UserRegistrationListener.confirmRegistration()");
	}

}
