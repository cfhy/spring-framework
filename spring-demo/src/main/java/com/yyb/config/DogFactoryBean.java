package com.yyb.config;

/**
 * @author: yyb
 * @date: 2023/12/24 19:11
 * @description:
 */

import com.yyb.bean.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class DogFactoryBean implements FactoryBean<Dog> {

	private int seed;

	public void setSeed(int seed) {
		this.seed = seed;
	}

	@Override
	public Dog getObject() throws Exception {
		Dog p= new Dog();
		p.setAge(20);
		return p;
	}

	@Override
	public Class<?> getObjectType() {
		return Dog.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}
