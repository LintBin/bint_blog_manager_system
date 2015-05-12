package com.bint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bint.service.NotificationService;

@Controller
public class NotificationController {
	@Autowired
	private NotificationService notificationServiceImpl;
	
	
	
}
