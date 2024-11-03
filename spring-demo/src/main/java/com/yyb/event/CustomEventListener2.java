package com.yyb.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: yyb
 * @date: 2023/12/4 18:09
 * @description: 事件监听类
 */
//@Component
public class CustomEventListener2 {
	@EventListener
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("========我监听到事件了:" + event.getMessage());
	}
}