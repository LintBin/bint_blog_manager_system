package com.bint.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.NotificationMapper;
import com.bint.model.NotificationModel;
import com.bint.service.NotificationService;
import com.bint.service.base.impl.BaseServiceImpl;

@Service
@Transactional
public class NotificationServiceImpl extends BaseServiceImpl<NotificationModel> implements NotificationService{
	private NotificationMapper notificationMapper;

	@Resource
	public void setNotificationMapper(NotificationMapper notificationMapper) {
		this.notificationMapper = notificationMapper;
		this.setBaseMapper(notificationMapper);
	}
}