package com.khunboo.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    /**
     * 默认交换机配置
     * @return
     */
    @Bean
    public DirectExchange defaultExchange(){

        return new DirectExchange(MQConstant.DEFAULT_EXCHANGE, true, false);
    }

    /**
     * 默认队列配置
     * @return
     */
    @Bean
    public Queue defaultQueue(){
        Queue queue = new Queue(MQConstant.DEFAULT_ADMIN_QUEUE, true);
        return queue;
    }

    /**
     * 默认消息列队绑定交互机
     */
    @Bean
    public Binding bindingDefault(){
        return BindingBuilder.bind(defaultQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_ADMIN_QUEUE);
    }
}
