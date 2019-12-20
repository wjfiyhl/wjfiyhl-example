package org.wjfiyhl.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@Component
public class Consumer {

    // public static final String QUEUE_INFO_PHONE = "queue_info_phone";
    public static final String QUEUE_INFO_PHONE = "info.phone.queue";

    //public static final String QUEUE_INFO_EMAIL = "queue_info_email";
    public static final String QUEUE_INFO_EMAIL = "info.email.queue";

    /**
     * 消费生产者生产的消息。@RabbitListener用来监视指定的队列。
     * @param message
     */
    @RabbitListener(queues = QUEUE_INFO_EMAIL)
    public void consumeEmail(String message, Channel channel) {
        System.out.println("消息内容：" + message);
        System.out.println("消息通道：" + channel);
    }

    @RabbitListener(queues = QUEUE_INFO_PHONE)
    public void consumePhone(String message, Channel channel) {
        System.out.println("消息内容：" + message);
        System.out.println("消息通道：" + channel);
    }

}
