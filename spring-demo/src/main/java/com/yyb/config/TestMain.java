package com.yyb.config;

import com.yyb.bean.Dog;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    public static void main(String[] args) {

        ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
		DogFactoryBean student = factory.getBean(DogFactoryBean.class);
		Object d1 = factory.getBean("&dogFactoryBean");
		Object d2 = factory.getBean("dogFactoryBean");
		System.out.println(student);
		System.out.println(d1);
		System.out.println(d2);
    }

	public static void test1() {
		GenericBeanDefinition definition = new GenericBeanDefinition();
		definition.setBeanClassName("com.yyb.bean.User");
		definition.setScope("prototype");
		definition.setInitMethodName("init");
	}

	public static void test2() {
		RootBeanDefinition definition = new RootBeanDefinition();
		definition.setBeanClassName("com.yyb.bean.Dog");
		definition.setScope("prototype");

		ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("dog");
		childBeanDefinition.setBeanClassName("com.yyb.bean.TeddyDog");
		childBeanDefinition.setScope("prototype");

		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		registry.registerBeanDefinition("dog",definition);

		registry.registerBeanDefinition("teddyDog",childBeanDefinition);


	}
}
