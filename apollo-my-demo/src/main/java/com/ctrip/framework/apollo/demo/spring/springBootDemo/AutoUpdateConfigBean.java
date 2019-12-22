package com.ctrip.framework.apollo.demo.spring.springBootDemo;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@EnableApolloConfig
public class AutoUpdateConfigBean {

    /**
     * 支持自动更新
     */
    @Value("${value1:100}")
    private int value1;

    /**
     * 支持自动更新
     */
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<JsonBean> anotherJsonBeans;

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    private static class JsonBean {

        private String someString;
        private int someInt;

        @Override
        public String toString() {
            return "JsonBean{" +
                    "someString='" + someString + '\'' +
                    ", someInt=" + someInt +
                    '}';
        }
    }
}
