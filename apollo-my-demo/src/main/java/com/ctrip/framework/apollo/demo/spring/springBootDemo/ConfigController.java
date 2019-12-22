package com.ctrip.framework.apollo.demo.spring.springBootDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConfigController {

    @Autowired
    private AutoUpdateConfigBean autoUpdateConfigBean;

    @GetMapping("/config")
    public void get() {
        log.info("{}", autoUpdateConfigBean);
    }

}
