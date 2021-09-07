package com.example.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.demo.model.database;
import com.example.demo.repository.database123;
import com.example.demo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import static com.example.demo.model.database.SEQUENCE_NAME;
@Component
@EnableScheduling
public class Scheduler
{
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
public database123 d123;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    static int count=0;
    @Scheduled(initialDelay =2000 ,fixedDelay = 20000 )
    public void reportCurrentTime()
    {
        System.out.println("Current time = " +count+" "  + dateFormat.format(new Date()));
        count++;
    }
    @Scheduled(initialDelay =20000 ,fixedDelay = 100000 )
    public void pushitindatabase()
    {
        System.out.println("pushtime = " +count);
         database d=new database();
         d.setCount(count);
         System.out.println(service.getSequenceNumber(SEQUENCE_NAME));
         d.setId(service.getSequenceNumber(SEQUENCE_NAME));
         d.setDate(new Date());
         d123.save(d);


    }

}
