package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("In post construct: " + this.getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("In pre destroy: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Spend 30 mins on training baseball!";
    }
}
