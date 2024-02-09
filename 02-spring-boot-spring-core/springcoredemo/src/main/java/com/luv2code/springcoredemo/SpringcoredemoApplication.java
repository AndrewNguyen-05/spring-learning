package com.luv2code.springcoredemo;

import com.luv2code.springcoredemo.common.BaseballCoach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        System.out.println("> Trước khi IoC Container được khởi tạo");
        ApplicationContext context = SpringApplication.run(SpringcoredemoApplication.class, args);
        System.out.println("> Sau khi IoC Container được khởi tạo");

        BaseballCoach coach = context.getBean(BaseballCoach.class);

        System.out.println("> Trước khi IoC Container destroy BaseballCoach");
        ((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(coach);
        System.out.println("> Sau khi IoC Container destroy BaseballCoach");
    }
}
