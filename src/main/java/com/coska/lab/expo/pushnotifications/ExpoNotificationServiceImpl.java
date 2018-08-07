package com.coska.lab.expo.pushnotifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coska.lab.core.notification.NotificationService;
import com.coska.lab.expo.domain.ExpoReponse;
import com.coska.lab.expo.domain.PushMessage;
import com.coska.lab.restaurantpos.api.domain.ApiResponse;

@Service
public class ExpoNotificationServiceImpl implements NotificationService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	final static String PUSH_SEND_URL = "https://exp.host/--/api/v2/push/send";

	@Override
	public ApiResponse sendNotice(PushMessage pm) {
		ApiResponse resp = new ApiResponse();
		RestTemplate restTemplate = new RestTemplate();

		try {
			String result = restTemplate.postForObject(PUSH_SEND_URL, pm, String.class);
			resp.setData(result);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resp.addError("API Error", e.getMessage());
		}

		return resp;
	}

}
