package com.example.controller;

import com.example.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wecan on 2019/12/3.
 */
@RestController
public class TestController {

    @Autowired
    private TestInterface testInterface;

    @RequestMapping(value = "/consumerHello",method = RequestMethod.GET)
    public String hello(String name){
        return testInterface.hello(name);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/port", method = RequestMethod.GET)
    public String getPort(){
        return port;
    }
}
