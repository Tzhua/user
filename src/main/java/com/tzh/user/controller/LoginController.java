package com.tzh.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.tzh.user.JwtUtils;
import com.tzh.user.entity.Result;
import com.tzh.user.entity.User;
import com.tzh.user.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 17:18
 * @Description: 获取登录
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result login(@RequestBody User user, HttpServletResponse response) {
        JSONObject jsonpObject=new JSONObject();
        /**
         * 自定义生成Token，因为使用了自定义登录，就不会执行JWTLoginFilter了，所以需要字段调用生成token并返给前端
         */
        Boolean checkUser = userService.checkUser(user);
        if (!checkUser){
            return new Result().fail("请检查账号或密码输入是否有误","201");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");

        String subject = String.valueOf(user.getAccountId());
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("accountId",subject);
        String token = JwtUtils.generateJwt(userInfo);
        // 登录成功后，返回token到header里面
        response.addHeader("Authorization", "Bearer " + token);
        jsonpObject.put("access_token", token);
        jsonpObject.put("accountId", user.getAccountId());
        jsonpObject.put("expiration", dateFormat.format(new Date(System.currentTimeMillis() +  60 * 60 * 1000)));
        return new Result().success(jsonpObject);

    }

}
