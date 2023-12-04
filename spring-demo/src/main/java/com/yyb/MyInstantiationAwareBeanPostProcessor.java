package com.yyb;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author: yyb
 * @date: 2023/12/4 16:50
 * @description:
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInstantiation方法");
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}