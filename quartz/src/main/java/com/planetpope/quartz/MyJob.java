package com.planetpope.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean implements StatefulJob {

    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        // place your Job code here
        System.out.println("Executing Quartz Job");
    }
}