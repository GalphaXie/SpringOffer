package com.company.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ObjectResponse;
import com.company.constant.ResponseCode;
import com.company.entity.User;
import com.company.executor.UserExecutor;
import com.company.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {
    @Autowired
    UserExecutor userExecutor;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public ObjectResponse<User> get(Long userId) {
        return ObjectResponse.<User>builder()
                .data(userExecutor.getUser(userId))
                .build();
    }

    @Override
    public ObjectResponse create(User user) {
        userExecutor.createUser(user);
        return ObjectResponse.builder()
                .build();
    }

    @Override
    public ObjectResponse login(UserLoginRequest request, HttpServletResponse response) {
        User user = userExecutor.login(request);
        // 创建一个 cookie对象
        if(user==null)return null;
        Cookie cookie1 = new Cookie("name", user.getName());
        Cookie cookie2 = new Cookie("password", user.getPassword());

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return null;
    }

}
