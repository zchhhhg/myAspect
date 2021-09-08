package com.example.spring.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Cheng
 * @date 2021-08-25-14:23
 */
public class HelloCornScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).build();
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("10,20,30,40,50 * * * * ?")).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
    }
}
