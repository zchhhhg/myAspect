package com.example.spring.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cheng
 * @date 2021-08-26-9:28
 */
@Component
public class MvcTimeTask {
    @Scheduled(cron = "0/2 * *  * * ?")
    public void execute() {
        System.out.println("trigger quartz current time：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
