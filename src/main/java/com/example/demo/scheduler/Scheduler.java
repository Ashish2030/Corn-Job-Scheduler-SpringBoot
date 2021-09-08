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
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM:yy:dd");
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
        String da=dateFormat.format(new Date());
        database temp=this.service.find(da);

        if(temp!=null)
        {
            temp.setCount(count);
            d123.save(temp);
        }
        else
        {
            database d=new database();
            d.setCount(count);
            d.setId(service.getSequenceNumber(SEQUENCE_NAME));
            d.setDate(da);
            d123.save(d);
        }

    }

}
