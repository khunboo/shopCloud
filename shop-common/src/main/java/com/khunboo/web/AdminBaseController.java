package com.khunboo.web;

import com.khunboo.config.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基础控制器
 * @Author: duanmu
 */
@Component
public class AdminBaseController {

    @Autowired
    private RedisUtils redisUtils;

}
