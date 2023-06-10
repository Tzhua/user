package com.tzh.user.service;

import com.tzh.user.entity.User;

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
}
