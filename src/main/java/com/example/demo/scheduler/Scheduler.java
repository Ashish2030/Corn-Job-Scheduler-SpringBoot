package com.example.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    static int count=0;
    @Scheduled(initialDelay =2000 ,fixedDelay = 2000 )
    public void reportCurrentTime()
    {
        System.out.println("Current time = " +count+" "  + dateFormat.format(new Date()));
        count++;
    }
    @Scheduled(initialDelay =20000 ,fixedDelay = 20000 )
    public void pushitindatabase()
    {
        System.out.println("pushtime = " +count);

    }

}
