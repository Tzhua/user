package com.tzh.user.controller;

import com.tzh.user.entity.User;
import com.tzh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 13:01
 * @Description: 用户信息
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PatchMapping("/insert")
    public int insertUser(@RequestBody User user){
        int i = userService.insertUser(user);
        return i;
    }
}
