package com.company.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String name;

    private String password;
}
