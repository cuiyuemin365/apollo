package com.ctrip.framework.apollo.demo.spring.springBootDemo;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@ConditionalOnProperty("redis.cache.enabled")
@Component
@Slf4j
public class RefreshScopeConfig {

    private final RedisConfigBean redisConfigBean;
    private final RefreshScope refreshScope;

    public RefreshScopeConfig(
            final RedisConfigBean redisConfigBean,
            final RefreshScope refreshScope) {
        this.redisConfigBean = redisConfigBean;
        this.refreshScope = refreshScope;
    }

    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION},
            interestedKeyPrefixes = {"redis.cache."})
    public void onChange(ConfigChangeEvent changeEvent) {
        log.info("before refresh {}", redisConfigBean.toString());
        refreshScope.refresh("redisConfigBean");
        log.info("after refresh {}", redisConfigBean.toString());
    }
}
