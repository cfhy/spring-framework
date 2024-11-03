package com.rhr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yyb
 * @date: 2023/12/15 23:02
 * @description:
 */
@Configuration(proxyBeanMethods = false)
public class ConfigModule1 {

	@Bean
	public String module1(){
		System.out.println("我是模块一配置类");
		return "我是模块一配置类";
	}
	@Bean
	public String module2(){
		module1();
		return "我是模块一配置类";
	}
}