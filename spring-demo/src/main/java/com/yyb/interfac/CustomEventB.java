package com.yyb.interfac;

import org.springframework.context.ApplicationEvent;

/**
 * @author: yyb
 * @date: 2023/12/4 18:07
 * @description:
 */
public class CustomEventB extends ApplicationEvent {
	private static final long serialVersionUID = 5516071349620653420L;

	private String message;

	public CustomEventB(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}