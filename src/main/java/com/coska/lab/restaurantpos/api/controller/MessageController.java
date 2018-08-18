package com.coska.lab.restaurantpos.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.core.notification.NotificationService;
import com.coska.lab.expo.domain.PushMessage;
import com.coska.lab.expo.domain.RegisterTokenReq;
import com.coska.lab.restaurantpos.api.domain.ApiResponse;
import com.coska.lab.restaurantpos.api.domain.UserToken;
import com.coska.lab.restaurantpos.api.repositories.EmployeeRepository;
import com.coska.lab.restaurantpos.api.repositories.TokenRepository;

@RestController
public class MessageController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TokenRepository tokenRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	NotificationService expo;

	@PostMapping("/users/push-token")
	public ApiResponse registerToken(@RequestBody RegisterTokenReq token) {

		UserToken ut = tokenRepository.findByUserId(token.getUserId());
		if (ut != null) {
			ut.setUserId(token.getUserId());
			ut.setToken(token.getToken());
		} else {
			ut = new UserToken();
			ut.setUserId(token.getUserId());
			ut.setToken(token.getToken());
		}
		tokenRepository.save(ut);

		ApiResponse resp = new ApiResponse();
		return resp;
	}

	@PostMapping("/message/{userId}")
	public ApiResponse sendNotice(@PathVariable String userId) {
		ApiResponse resp = new ApiResponse();
//		Employee em = null;
//		em = employeeRepository.findByUserId(userId);
//
//		if(em == null)
//			resp.addError("UserNotFound", "UserNotFound");

		
		UserToken token = tokenRepository.getOne(userId);

		if(token == null)
			resp.addError("TokenNotFound", "TokenNotFound");
		
		if(resp.hasError())
			return resp;
		PushMessage pm = new PushMessage();
		pm.setTo(token.getToken());
		pm.setTitle("Message from POS Server");
		pm.setBody("Good");
		
		resp = expo.sendNotice( pm);
		
		return resp;
	}

}
