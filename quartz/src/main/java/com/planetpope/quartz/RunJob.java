package com.planetpope.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunJob {

    public static void main(String[] args) {

        // By loading the bean factory, we will start the Quartz Scheduler
        // The Quartz Scheduler will continue to run until explicitly shutdown.
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Quartz.xml");
    }
}