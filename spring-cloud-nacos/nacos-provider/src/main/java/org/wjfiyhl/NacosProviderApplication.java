package org.wjfiyhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@SpringBootApplication
/**
 * 开启nacos客户端服务发现功能。
 */
@EnableDiscoveryClient
/**
 * 开启Feign客户端。
 */
@EnableFeignClients
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class,args);
    }

}
