package com.yyb.event;

import com.yyb.interfac.CustomEventA;
import com.yyb.interfac.CustomEventB;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: yyb
 * @date: 2023/12/4 18:07
 * @description:
 */
@Component
public class MyListener {

	@EventListener(CustomEventA.class)
	public void methodA(CustomEventA event) {
		System.out.println("========我监听到事件A了:" + event.getMessage());
		// 在这里可以执行一些其他操作
	}

	@EventListener(CustomEventB.class)
	public void methodB(CustomEventB event) {
		System.out.println("========我监听到事件B了:" + event.getMessage());
		// 在这里可以执行一些其他操作
	}
}