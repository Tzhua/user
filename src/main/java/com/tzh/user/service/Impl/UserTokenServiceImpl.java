package com.tzh.user.service.Impl;

import com.tzh.user.entity.UserToken;
import com.tzh.user.mapper.UserTokenMapper;
import com.tzh.user.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 21:58
 * @Description: 用户授权信息
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenMapper userTokenMapper;

    /**
     * 插入用户授权信息
     *
     * @param userToken
     * @return
     */
    @Override
    public int insertTokenInfo(UserToken userToken) {
        return userTokenMapper.insertTokenInfo(userToken);
    }

    /**
     * 根据用户账号和当前时间判断用户登录是否超期
     *
     * @param accountId
     * @return
     */
    @Override
    public UserToken queryTokenByAccountIdAndTime(int accountId) {
        return userTokenMapper.queryTokenByAccountIdAndTime(accountId);
    }
}
