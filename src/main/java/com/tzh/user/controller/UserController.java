package com.tzh.user.controller;

import com.tzh.user.entity.User;
import com.tzh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insert")
    public int insertUser(@RequestBody User user){
        int i = userService.insertUser(user);
        return i;
    }

    @GetMapping("/id")
    public User insertUser(@RequestParam int id){
        User user = userService.selectUser(id);
        return user;

    }
}
