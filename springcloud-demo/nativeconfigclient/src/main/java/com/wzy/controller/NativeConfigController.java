package com.wzy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.wzy.controller
 * @Author: Clarence1
 * @Date: 2019/9/11 10:30
 */
@RestController
@RequestMapping(value = "/native")
public class NativeConfigController {

    @Value("${server.port}")
    private String port;
    @Value("${foo}")
    private String foo;

    @GetMapping(value = "/index")
    public String index() {
        return this.port +"-"+ this.foo;
    }

}
