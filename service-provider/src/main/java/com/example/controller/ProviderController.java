package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wecan on 2019/12/2.
 */

@RestController
public class ProviderController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name){
        return "Hello," + name + ", this is your world!";
    }
}
