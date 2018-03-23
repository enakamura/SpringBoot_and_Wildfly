package com.notification.core;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notification.pojo.*;;

@RestController
public class NotificationController {

	static final Logger LOG = LoggerFactory.getLogger(SendMessage.class);
	String serverKey_ = "AAAASgXNggY:APA91bFmiVnIjuWSvNubsa7_kIzIeOchj2cRkMqbbNZNB11we4XE6Jgy-byISVAByoSvovuYQODOFNlpucppSXNxot6-DcbViRvK4BLvawdrKSpC3l_vQZPlPxMqB_oOX8r5k3_Ps-xo";
	
	@RequestMapping("/")
	public String index() {
		return "Application started :)";
	}
	
	@RequestMapping("/notificationMessage")
	public Response notificationMessage(@RequestParam("token") String token, @RequestParam("title") String title, @RequestParam("message") String message){
		
		LOG.trace("BEGIN");
		LOG.trace("Input data ...");
		LOG.trace("serverKey="+serverKey_);
		LOG.trace("token="+token);
		LOG.trace("title="+title);
		LOG.trace("message="+message);
		
		SendMessage sendMessage = new SendMessage();
		
		try {
			sendMessage.sendMessage(serverKey_, token, title, message);
		} catch (IOException e) {
			Response response = new Response("0", e.getMessage());
			LOG.trace(response.toString());
			LOG.trace("END");
			return response;
		}
		
		Response response = new Response("1", "Success");
		LOG.trace(response.toString());
		LOG.trace("END");
		return response;
	}

}
