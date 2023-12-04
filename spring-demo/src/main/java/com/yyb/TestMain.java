package com.yyb;

import com.yyb.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
        Student student = factory.getBean(Student.class);
        System.out.println(student.getName());

    }
}
