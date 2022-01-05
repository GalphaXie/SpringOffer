package com.company.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderControllerImpl {
    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        System.out.println();
        return "Hello Nacos Discovery " + string;
    }

}
