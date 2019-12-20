package org.wjfiyhl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@RestController
@RequestMapping("/consumer")
/**
 * 自动刷新配置在nacos中的配置信息。
 */
@RefreshScope
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 加载在nacos服务器中配置的配置信息。
     */
    @Value("${wjfiyhl.flag}")
    private boolean flag;


    @RequestMapping("/nacos/{year}")
    public String nacos(@PathVariable("year") Integer year) {
        if (flag) {
            year++;
        }
        return restTemplate.getForObject("http://nacos-provider//provider/nacos/" + year, String.class);
    }

}
