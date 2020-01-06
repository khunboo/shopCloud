package com.khunboo.config.rabbitmq;


import com.khunboo.config.rabbitmq.processor.MessageProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate template;


    /**
     * 发送消息
     */
    public void shopAdminMessage(MessageProcessor processor){

        template.convertAndSend(MQConstant.DEFAULT_EXCHANGE, MQConstant.DEFAULT_ADMIN_QUEUE, processor);
    }

}
