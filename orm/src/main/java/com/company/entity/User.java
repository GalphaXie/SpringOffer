package com.company.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@TableName("user")
@Data
public class User {
    @TableId
    private long id;

    private String name;

    private String email;

    private String phone;

    private String password;

}
