package com.yyb.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yyb
 * @date: 2023/12/5 16:54
 * @description:
 */
//@Component
public class Dog {
	private String color;
	private Integer age;

//	@Autowired
//	private Student student;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
