package com.wzy.controller;

import com.wzy.entity.Student;
import com.wzy.hystrix.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Clarence1
 */
@RestController
@RequestMapping(value = "/hystrix")
public class HystrixController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping(value = "/findAll")
    public Collection<Student> findAll() {
        return feignProviderClient.findAll();
    }

    @GetMapping(value = "/index")
    public String index() {
        return feignProviderClient.index();
    }

}
