package org.wjfiyhl.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wjfiyhl.task.QuartzTask;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

@Configuration
public class SpringQuartzConfig {


    /**
     * 创建任务详细对象，指定调度。
     * @return JobDetail
     */
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(QuartzTask.class).withIdentity("springQuartz").storeDurably().build();
    }


    /**
     * 创建执行，添加调度，指定任务执行方式。
     * @return Trigger
     */
    @Bean
    public Trigger quartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 10秒执行一次。
                .withIntervalInSeconds(10)
                // 永远执行。
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("springQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
