package com.planetpope.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {

    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        System.out.println("Executing Quartz Job");
    }
}