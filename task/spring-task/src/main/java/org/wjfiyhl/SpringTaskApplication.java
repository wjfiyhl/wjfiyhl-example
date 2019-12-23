package org.wjfiyhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: WJF
 * @date: 2019/12/23
 */


@SpringBootApplication
/**
 * 启用定时任务的配置。
 */
@EnableScheduling
public class SpringTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTaskApplication.class,args);
    }

}
