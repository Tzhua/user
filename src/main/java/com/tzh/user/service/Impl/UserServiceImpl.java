package com.tzh.user.service.Impl;

import com.tzh.user.entity.User;
import com.tzh.user.mapper.UserMapper;
import com.tzh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userMapper.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    /**
     * 根据用户id，修改信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUserInfoById(User user) {
        user.setUpdateTime(new Date());
        return userMapper.updateUserInfoById(user);
    }

    /**
     * 根据用户ID，删除用户
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public int deleteUserById(int userId) {
        return userMapper.deleteUserById(userId);
    }

    /**
     * 根据账号密码校验用户登录
     *
     * @param user
     * @return
     */
    @Override
    public Boolean checkUser(User user) {
        boolean flag = false;
        int checkUser = userMapper.checkUser(user);
        if (checkUser > 0){
            flag = true;
        }
        return flag;
    }
}
