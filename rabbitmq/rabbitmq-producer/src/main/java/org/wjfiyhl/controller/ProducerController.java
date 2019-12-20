package org.wjfiyhl.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjfiyhl.config.RabbitMqConfig;

import javax.annotation.Resource;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private String emailRoutingKey = "info.email.wjf.xxx";

    private String phoneRoutingKey = "info.phone.wjf";

    @Resource
    private RabbitTemplate rabbitTemplate;


    /**
     * 利用rabbitTemplate发送消息，指定routing-key，消息就会发送到指定的交换机，
     * 并且只有符合配置的routing-key才可以。(info.email.#,info.phone.*)
     * @param message
     * @return
     */
    @RequestMapping("/sendEmail")
    public String sendEmail(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPIC_INFO,emailRoutingKey,message);
        return "发送Email成功！";
    }

    @RequestMapping("/sendPhone")
    public String sendPhone(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPIC_INFO,phoneRoutingKey,message);
        return "发送Phone成功！";
    }


}
