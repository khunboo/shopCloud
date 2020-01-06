package com.khunboo.config.rabbitmq.processor;

import lombok.Data;

@Data
public class MessageProcessor extends AbstractProcessor{

    public MessageProcessor(int id, String content){
        this.id = id;
        this.content = content;
    }

    private int id;
    private String content;
}
