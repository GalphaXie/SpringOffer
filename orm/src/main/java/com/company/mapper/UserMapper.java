package com.company.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll2();
}
