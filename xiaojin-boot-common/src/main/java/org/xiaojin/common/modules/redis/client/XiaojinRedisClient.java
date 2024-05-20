package org.xiaojin.common.modules.redis.client;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.xiaojin.common.base.ExtendMap;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName XiaojinRedisClient.java
 * @Description TODO
 * @createTime 2024年05月20日 09:21:00
 */
@Configuration
public class XiaojinRedisClient {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public XiaojinRedisClient() {
    }

    public void sendMessage(String handlerName, ExtendMap params) {
        params.put("handlerName", handlerName);
        this.redisTemplate.convertAndSend("jeecg_redis_topic", params);
    }
}
