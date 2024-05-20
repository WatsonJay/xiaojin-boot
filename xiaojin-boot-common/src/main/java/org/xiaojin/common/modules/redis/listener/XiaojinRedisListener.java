package org.xiaojin.common.modules.redis.listener;

import org.xiaojin.common.base.ExtendMap;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName XiaojinRedisListener.java
 * @Description TODO
 * @createTime 2024年05月17日 14:28:00
 */
public interface XiaojinRedisListener {

    void onMessage(ExtendMap message);
}
