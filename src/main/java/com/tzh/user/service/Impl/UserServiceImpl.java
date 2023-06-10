package com.tzh.user.service.Impl;

import com.tzh.user.entity.User;
import com.tzh.user.mapper.UserMapper;
import com.tzh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 13:00
 * @Description: 用户信息
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
