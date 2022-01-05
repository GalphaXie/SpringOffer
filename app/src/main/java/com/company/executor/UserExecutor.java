package com.company.executor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.entity.User;
import com.company.mapper.UserMapper;
import com.company.request.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserExecutor {

    @Autowired
    UserMapper userMapper;

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void createUser(User user){
        userMapper.insert(user);
    }

    public User getUser(Long userId){
        return userMapper.selectById(userId);
    }

    public User login(UserLoginRequest request){
        QueryWrapper<User> query = new QueryWrapper<>();
        User user = userMapper.selectOne(query.eq("name",request.getName()).eq("password", request.getPassword()));
        return user;
    }
}
