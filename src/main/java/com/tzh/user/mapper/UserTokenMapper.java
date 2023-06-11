package com.tzh.user.mapper;

import com.tzh.user.entity.UserToken;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 21:38
 * @Description: 用户token信息
 */
@Repository
public interface UserTokenMapper {
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
