package org.xiaojin.common.modules.redis.receiver;

import cn.hutool.core.util.ObjectUtil;
import org.xiaojin.common.base.ExtendMap;
import org.springframework.stereotype.Component;
import org.xiaojin.common.modules.redis.listener.XiaojinRedisListener;
import org.xiaojin.common.util.SpringContextHolder;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RedisReceiver.java
 * @Description TODO
 * @createTime 2024年05月17日 14:23:00
 */


@Component
public class RedisReceiver {
    public void onMessage(ExtendMap params) {
        Object handlerName = params.get("handlerName");
        XiaojinRedisListener messageListener = (XiaojinRedisListener) SpringContextHolder.getHandler(handlerName.toString(), XiaojinRedisListener.class);
        if (ObjectUtil.isNotEmpty(messageListener)) {
            messageListener.onMessage(params);
        }

    }

    public RedisReceiver() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RedisReceiver)) {
            return false;
        } else {
            RedisReceiver other = (RedisReceiver)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RedisReceiver;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "RedisReceiver()";
    }
}