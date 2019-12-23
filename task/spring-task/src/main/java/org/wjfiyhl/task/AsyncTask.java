package org.wjfiyhl.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

@Component
public class AsyncTask {


    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 异步调用，每三秒执行一次。
     */
    @Async
    @Scheduled(cron = "0/3 * * * * ? ")
    public void task01() {
        System.out.println(format.format(new Date()) + "wjf");
    }

    /**
     * 异步调用，每十秒执行一次。
     */
    @Async
    @Scheduled(cron = "0/10 * * * * ? ")
    public void task02() {
        System.out.println(format.format(new Date()) + "yhl");
    }
}
