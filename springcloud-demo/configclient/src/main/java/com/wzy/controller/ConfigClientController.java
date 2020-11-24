package com.wzy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.wzy.controller
 * @Author: Clarence1
 * @Date: 2019/9/12 9:14
 */
@RestController
@RequestMapping(value = "/hello")
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/index")
    public String index() {
        return this.port;
    }

}
