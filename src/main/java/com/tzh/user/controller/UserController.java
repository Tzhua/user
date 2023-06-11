package com.tzh.user.controller;

import com.tzh.user.entity.Result;
import com.tzh.user.entity.User;
import com.tzh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 13:01
 * @Description: 用户信息
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result insertUser(@RequestBody User user){
        int i = userService.insertUser(user);
        if (i > 0){
            return new Result().success();
        }
        return new Result().fail("创建用户失败","201");
    }

    /**
     * 根据用户ID获取用户详情
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public Result user(@PathVariable int userId){
        User user = userService.selectUser(userId);
        if (user != null){
            return new Result().success(user);
        }
        return new Result().fail("获取用户详情失败","201");

    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/list")
    public Result userAll(){
        List<User> allUser = userService.getAllUser();
        if (allUser != null && allUser.size() > 0){
            return new Result().success(allUser);
        }
        return new Result().fail("获取用户列表失败","201");
    }

    @PutMapping
    public Result updateUserById(@RequestBody User user){
        int updateUserInfoById = userService.updateUserInfoById(user);
        if (updateUserInfoById > 0){
            return new Result().success(updateUserInfoById);
        }
        return new Result().fail("更新用户信息失败","201");
    }

    /**
     * 根据用户id，删除用户
     * @param userId    用户id
     * @return
     */
    @DeleteMapping("/{userId}")
    public Result deleteUserById(@PathVariable int userId){
        int deleteUserById = userService.deleteUserById(userId);
        if (deleteUserById > 0){
            return new Result().success();
        }
        return new Result().fail("删除用户失败","201");
    }


}
