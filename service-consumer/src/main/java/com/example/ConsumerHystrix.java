package com.example;

import com.example.service.TestInterface;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wecan on 2019/12/3.
 */

@Component
public class ConsumerHystrix implements TestInterface{
    @Override
    public String hello(@RequestParam("name") String name) {
        return "server is closed , your send failed";
    }
}
