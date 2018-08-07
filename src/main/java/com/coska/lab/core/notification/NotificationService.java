package com.coska.lab.core.notification;

import com.coska.lab.expo.domain.PushMessage;
import com.coska.lab.restaurantpos.api.domain.ApiResponse;

public interface NotificationService {
	public ApiResponse sendNotice(PushMessage pm);
}
