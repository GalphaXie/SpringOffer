package com.company.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "nacos测试模块")
public class OrderController {
    @GetMapping("/echo/{string}")
    @ApiOperation(value = "获取用户信息")
    public String echo(@PathVariable String string) {
        System.out.println();
        return "Hello Nacos Discovery " + string;
    }
}
