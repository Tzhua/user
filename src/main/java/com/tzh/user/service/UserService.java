package com.tzh.user.service;

import com.tzh.user.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 12:59
 * @Description: 用户信息
 */

public interface UserService {

    int insertUser(User user);

    User selectUser(int id);

    List<User> getAllUser();

    /**
     * 根据用户id，修改信息
     * @param user
     * @return
     */
    int updateUserInfoById(User user);

    /**
     * 根据用户ID，删除用户
     * @param userId    用户id
     * @return
     */
    int deleteUserById(int userId);
}
