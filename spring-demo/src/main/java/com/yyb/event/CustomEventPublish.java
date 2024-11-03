package com.yyb.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author: yyb
 * @date: 2023/12/15 18:16
 * @description: 事件发布类
 */
//@Component
public class CustomEventPublish {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void publish(String message){
		CustomEvent event = new CustomEvent(this, message);
		eventPublisher.publishEvent(event);
	}

}