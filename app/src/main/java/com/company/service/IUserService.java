package com.company.service;

import com.company.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User get(String userId);
}
