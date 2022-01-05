package com.company.controller;

import com.company.ObjectResponse;
import com.company.entity.User;
import com.company.request.UserLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户模块")
@FeignClient(name = "spring-offer", contextId = "spring-offer-user")
public interface UserController {

    @GetMapping("/{user_id}")
    @ApiOperation(value = "获取用户信息")
    ObjectResponse<User> get(@PathVariable(value = "user_id")Long userId);

    @PostMapping("/create")
    @ApiOperation(value = "创建用户")
    ObjectResponse<User> create(@RequestBody User user);

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    ObjectResponse login(@RequestBody UserLoginRequest request, HttpServletResponse response);
}
