package com.yyb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yyb
 * @date 2019/9/3 18:24
 * @description
 */
@Configuration
public class JavaConfig {
    @Bean
    public Person person(){
        Person p= new Person();
        p.setName("yyb");
        return p;
    }
}
