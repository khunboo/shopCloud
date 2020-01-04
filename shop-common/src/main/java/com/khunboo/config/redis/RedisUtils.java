package com.khunboo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    /**
     * 默认过期为24小时， 单位为：秒
     */
    private final static long DEFAULT_EXPIRE = 60 * 60 * 24L;

    /**
     * 过期时长为1小时，单位：秒
     */
    public final static long HOUR_ONE_EXPIRE = 60 * 60 * 1L;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1L;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param key
     * @param value
     */
    public void set(String key, Object value, long expireTime){
        redisTemplate.opsForValue().set(key, value);
        if(expireTime != NOT_EXPIRE){
            setExpireTime(key, expireTime);
        }
    }


    /**
     * 设置过期时间
     */
    public void setExpireTime(String key, long expireTime){
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }


    /**
     * 获取缓存的值（有过期时间）
     */
    public Object get(String key, long expireTime){

        Object value = redisTemplate.opsForValue().get(key);
        if(expireTime != NOT_EXPIRE){
            setExpireTime(key, expireTime);
        }

        return value;
    }


    /**
     * 获取缓存值（无过期时间）
     */
    public Object get(String key){
        return get(key, NOT_EXPIRE);
    }

    /**
     * 删除缓存
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 删除多个相似key的缓存
     */
    public void removePattern(String pattern){
        Set<Serializable> keys = this.redisTemplate.keys(pattern);
        if(keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }

    /**
     * 判断key是否存在
     */
    public boolean existKey(String key){
        return redisTemplate.hasKey(key);
    }


    /**
     * 利用redis计数
     */
    public int incr(String key, Long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        int increment = (int) entityIdCounter.incrementAndGet();

        if (liveTime != null) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.HOURS);
        }
        return increment;
    }
}
