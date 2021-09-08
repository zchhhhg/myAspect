package com.example.spring.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Cheng
 * @date 2021-08-25-10:09
 */
public class HelloSimpleScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {

        //1.创建一个ScheduleFactory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2.创建JobDetail实例，并与HelloJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .usingJobData("jobdetailparam", "I'm jobdetailparam")
                .withIdentity("myjobdetail","mygroup").build();
        //构建Trigger实例,并且每隔2秒钟重复执行一次，直到程序停止
        /**
         * trigger通过builder模式来创建，TriggerBuilder.newTrigger()
         * withIdentity():定义一个标识符，定义了组
         * startNow()：定义现在开始执行，
         * withSchedule(SimpleScheduleBuilder.simpleSchedule()：withSchedule也是builder模式创建
         *.withIntervalInSeconds(2).repeatForever())：定义了执行频度：每2秒钟执行一次，不间断地重复执行
         * build()：创建trigger
         */
        Date startTime = new Date();
        startTime.setTime(startTime.getTime()+5000);
        Date endTime = new Date();
        endTime.setTime(startTime.getTime()+5000);
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","mygroup").startAt(startTime).endAt(endTime)
                .usingJobData("triggerparam", "I'm triggerparam")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2).withRepeatCount(5)).build();

        //需要将jobDetail和trigger传进去，并将jobDetail和trigger绑定在一起。
        System.out.println("--------scheduler start ! ------------");
        scheduler.scheduleJob(jobDetail,trigger);
        // 执行

        scheduler.start();
        TimeUnit.SECONDS.sleep(10);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");


    }
}
