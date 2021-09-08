package com.example.spring.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cheng
 * @date 2021-08-26-9:28
 */
@Configuration
@EnableScheduling
public class StaticScheduleTask {
    @Scheduled(cron = "0/2 * *  * * ?")
    public void executeScheduleTask() {
        System.out.println("执行静态定时任务时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
