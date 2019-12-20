package org.wjfiyhl.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author: WJF
 * @date: 2019/12/20
 */

@SpringBootConfiguration
public class RabbitMqConfig {

    /**
     * 队列的名称要符合routing-key的规则，因为rabbitmq是通过routing-key找队列的，
     * 符合routing-key的队列名称才可以接收到消息。
     * 队列名称要符合routingKey规则：
     * info.phone.queue --> info.phone.*
     * info.email.queue --> info.email.#
     * 制定的routingKey也要符合routingKey规则：
     * emailRoutingKey = info.email.wjf.xxx --> info.email.#
     * phoneRoutingKey = info.phone.wjf --> info.phone.*
     */
    public static final String QUEUE_INFO_PHONE = "info.phone.queue";

    public static final String QUEUE_INFO_EMAIL = "info.email.queue";

    /**
     * `*`代表routingKey的通配符，但是只能匹配到通配符的一个单词，例如：info.phone.wjf
     * `#`代表routingKey的通配符，可以匹配到一个或多个单词，例如：info.phone.wjf.xxx
     */
    public static final String INFO_PHONE = "info.phone.*";

    public static final String INFO_EMAIL = "info.email.#";

    public static final String EXCHANGE_TOPIC_INFO = "exchange_topic_info";


    /**
     * 构建一个topic类型的交换机，durable为true代表mq重启之后依然存在。
     * @return Exchange
     */
    @Bean(EXCHANGE_TOPIC_INFO)
    public Exchange EXCHANGE_TOPIC_INFO() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_INFO).durable(true).build();
    }


    /**
     * 创建两个队列，队列名称分别为：QUEUE_INFO_EMAIL，QUEUE_INFO_PHONE。
     * @return Queue
     */
    @Bean(QUEUE_INFO_EMAIL)
    public Queue QUEUE_INFO_EMAIL() {
        return new Queue(QUEUE_INFO_EMAIL);
    }

    @Bean(QUEUE_INFO_PHONE)
    public Queue QUEUE_INFO_PHONE() {
        return new Queue(QUEUE_INFO_PHONE);
    }


    /**
     * 声明两个绑定，将交换机和队列进行绑定关联，并指定routing-key。
     * @param queue
     * @param exchange
     * @return Binding
     */
    @Bean
    public Binding BINDING_QUEUE_EXCHANGE_EMAIL(
            @Qualifier(QUEUE_INFO_EMAIL) Queue queue,
            @Qualifier(EXCHANGE_TOPIC_INFO) Exchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with(INFO_EMAIL).noargs();
    }


    @Bean
    public Binding BINDING_QUEUE_EXCHANGE_PHONE(
            @Qualifier(QUEUE_INFO_PHONE) Queue queue,
            @Qualifier(EXCHANGE_TOPIC_INFO) Exchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with(INFO_PHONE).noargs();
    }


    /**
     * 可以访问此链接了解学习RabbitMQ: https://blog.csdn.net/n950814abc/article/details/98219335
     */















}
