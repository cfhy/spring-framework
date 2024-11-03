package com.rhr;

/**
 * @author: yyb
 * @date: 2023/12/15 23:00
 * @description:
 */
public class Service2 {

	private Service1 service1;

	public void setService1(Service1 service1) {
		this.service1 = service1;
	}

	@Override
	public String toString() {
		return "Service2{" +
				"service1=" + service1 +
				'}';
	}
}