package com.rhr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author: yyb
 * @date: 2023/12/15 23:02
 * @description:
 */
//@ComponentScan(
//		useDefaultFilters = false,
//		includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Service1.class)
//)
public class ConfigModule2 {
	@Bean
	public String module2(){
		System.out.println("我是模块二配置类");
		return "我是模块二配置类";
	}

}