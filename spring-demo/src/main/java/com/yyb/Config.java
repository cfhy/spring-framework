package com.yyb;

import com.yyb.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yyb
 * @date: 2023/12/4 12:02
 * @description:
 */
@Configuration
@ComponentScan
public class Config {
    @Bean(initMethod = "myInit",destroyMethod = "myDestory")
    public Person person(){
        return new Person();
    }
}
