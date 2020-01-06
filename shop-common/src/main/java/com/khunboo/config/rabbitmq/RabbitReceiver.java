package com.khunboo.config.rabbitmq;

import com.khunboo.config.rabbitmq.processor.MessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    private Logger logger = LoggerFactory.getLogger(RabbitReceiver.class);


    /**
     * 消息接受者
     */
    @RabbitListener(queues = MQConstant.DEFAULT_ADMIN_QUEUE)
    public void rabbitListen(MessageProcessor processor){
        System.out.println("我发送的ID：" + processor.getId() + "  内容为: " + processor.getContent());
    }


}
