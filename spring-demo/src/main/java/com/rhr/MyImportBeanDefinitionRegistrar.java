package com.rhr;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: yyb
 * @date: 2023/12/15 23:23
 * @description:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		//定义一个bean：Service1
		BeanDefinition service1BeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition();
		//注册bean
		registry.registerBeanDefinition("service1", service1BeanDefinition);
		//定义一个bean：Service2，通过addPropertyReference注入service1
		BeanDefinition service2BeanDefinition = BeanDefinitionBuilder
				.genericBeanDefinition(Service2.class)
				.addPropertyReference("service1", "service1")
				.getBeanDefinition();
		//注册bean

		registry.registerBeanDefinition("service2", service2BeanDefinition);
	}
}
