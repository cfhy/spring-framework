package com.yyb.event;

import com.yyb.interfac.CustomEventA;
import com.yyb.interfac.CustomEventB;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author: yyb
 * @date: 2023/12/4 18:09
 * @description:
 */
@Component
public class CustomEventPublisher implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	// 利用容器刷新好的消息为触发，发布两条自定义的事件
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		CustomEventA eventA = new CustomEventA(applicationContext , "我是AAAA");
		CustomEventB eventB = new CustomEventB(applicationContext , "我是BBBB");
		applicationContext.publishEvent(eventA);
		applicationContext.publishEvent(eventB);
	}
}