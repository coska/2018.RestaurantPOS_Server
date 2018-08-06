package com.coska.lab.expo.pushnotifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coska.lab.core.notification.NotificationService;
import com.coska.lab.expo.api.ExpoAPI;
import com.coska.lab.restaurantpos.api.domain.Employee;
import com.coska.lab.restaurantpos.api.repositories.EmployeeRepository;

@Service
public class ExpoNotificationServiceImpl implements NotificationService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	private String getUrl() {
		return ExpoAPI.EXPO_HOST + ExpoAPI.BaseAPIURL;
	}
	
	@Override
	public boolean sendNotice(String userId, String message) {
		Employee em = employeeRepository.findByUserId(userId);
		if (em != null) {
			String token = em.getExpoPushToken();
			
		}
		return false;
	}

}
