package com.tzh.user.service;

import com.tzh.user.entity.UserToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 21:56
 * @Description: 用户授权信息
 */
public interface UserTokenService {

    /**
     * 插入用户授权信息
     * @param userToken
     * @return
     */
    int insertTokenInfo(UserToken userToken);

    /**
     * 根据用户账号和当前时间判断用户登录是否超期
     * @param accountId
     * @return
     */
    UserToken queryTokenByAccountIdAndTime(int accountId);
}
