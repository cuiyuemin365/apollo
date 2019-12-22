package com.ctrip.framework.apollo.demo.spring.springBootDemo;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@SpringBootApplication
@EnableApolloConfig
@Slf4j
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
    }

    @ApolloConfigChangeListener(ConfigConsts.NAMESPACE_APPLICATION)
    private void onChange(ConfigChangeEvent changeEvent) {
        log.info("{}", JSON.toJSONString(changeEvent));
    }

}
