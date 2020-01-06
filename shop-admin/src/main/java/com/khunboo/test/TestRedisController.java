package com.khunboo.test;

import com.khunboo.config.redis.RedisUtils;
import com.khunboo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testredis")
public class TestRedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("add")
    @ResponseBody
    public Result addRedis(){

        String key = "111";
        redisUtils.set(key, 222, -1L);

        return new Result("0", "添加成功", "");

    }
}
