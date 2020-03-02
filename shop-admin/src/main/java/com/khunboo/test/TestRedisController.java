package com.khunboo.test;

import com.khunboo.config.rabbitmq.RabbitSender;
import com.khunboo.config.rabbitmq.processor.MessageProcessor;
import com.khunboo.config.redis.RedisUtils;
import com.khunboo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestRedisController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RabbitSender rabbitSender;

    @RequestMapping("addredis")
    @ResponseBody
    public Result addRedis(){

        String key = "111";
        redisUtils.set(key, 222, -1L);

        return new Result(0, "添加成功", "");

    }

    @RequestMapping("addrabbitmq")
    @ResponseBody
    public Result addRabbitmq(){
        MessageProcessor processor = new MessageProcessor(1, "消息队列发送成功");
        rabbitSender.shopAdminMessage(processor);

        return new Result(0, "消息发送成功", "");

    }

}
