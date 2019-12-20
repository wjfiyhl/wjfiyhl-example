package org.wjfiyhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@SpringBootApplication
/**
 * 开启nacos客户端服务发现功能。
 */
@EnableDiscoveryClient
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class,args);
    }

}
