package com.tzh.user.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 12:45
 * @Description: 用户信息
 */
@Data
public class User {
    /**
     * 用户id
     */
    private int id;

    private String nickName;

    private int accountId;
    private String phone;
    /**
     * 性别，MALE=男性，FEMALE=女性
     */
    private String gender;
    private String remake;
    private Date createTime;
    private Date updateTime;
}
