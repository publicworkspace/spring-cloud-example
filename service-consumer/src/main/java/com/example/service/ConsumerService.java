package com.example.service;

import com.example.ConsumerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wecan on 2019/12/3.
 */

@FeignClient(name = "service-provider" ,fallback = ConsumerHystrix.class)
public interface ConsumerService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);

}
