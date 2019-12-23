package org.wjfiyhl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 动态创建定时任务，使用注解的方式，无法实现动态的修改、添加或关闭定时任务，这个时候就需要使用编程的方式进行任务的更新操作了。
 * 可直接使用ThreadPoolTaskScheduler或者SchedulingConfigurer接口进行自定义定时任务创建。(在使用异步调用配置时，将此类注释掉)
 */
@Configuration
public class DinamicTaskConfig implements SchedulingConfigurer {

    /**
     * 重写configureTasks方法时添加定时任务。
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(scheduler());
        // 预计的任务
        scheduledTaskRegistrar.getScheduler().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "wjf");
            }
        }, new CronTrigger("0/3 * * * * ?"));

        // 计划的任务
        scheduledTaskRegistrar.addCronTask(new CronTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "yhl");
            }
        }, new CronTrigger("0/3 * * * * ?")));
    }


    @Bean
    public TaskScheduler scheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("spring-task-scheduler-thread-");
        taskScheduler.setAwaitTerminationSeconds(60);
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskScheduler;
    }
}
