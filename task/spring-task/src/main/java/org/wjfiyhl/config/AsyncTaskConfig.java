package org.wjfiyhl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 启用异步调用。(在使用动态任务调度的时候，禁用此注解)
 */
@EnableAsync
@Configuration
/**
 * 异步并行定时任务，自定义异步调用线程池。
 * 实现SchedulingConfigurer接口，重写configureTasks方法，配置任务调度线程池。
 * 实现AsyncConfigurer接口，用自定义的线程池来取代默认线程管理方式，
 * 无疑是一个更加安全和灵活的方式，可以避免大量的线程阻塞带来的系统崩溃。
 */
@EnableScheduling
public class AsyncTaskConfig implements SchedulingConfigurer, AsyncConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler());
    }


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(10);
        // 配置最大线程数
        executor.setMaxPoolSize(15);
        // 配置缓存队列大小
        executor.setQueueCapacity(100);
        // 空闲线程存活时间
        executor.setKeepAliveSeconds(15);
        // 线程名称前缀
        executor.setThreadNamePrefix("spring-task-executor-thread-");
        /*
            线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，
            该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞。
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 线程池大小10
        taskScheduler.setPoolSize(10);
        // 线程名称前缀
        taskScheduler.setThreadNamePrefix("spring-task-scheduling-thread-");
        // 线程池关闭前最大等待时间，确保最后一定关闭
        taskScheduler.setAwaitTerminationSeconds(60);
        // 线程池关闭时等待所有任务完成
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        // 任务丢弃策略
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskScheduler;
    }
}
