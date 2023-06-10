package com.tzh.user.mapper;

import com.tzh.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-10 12:44
 * @Description: UserMapper
 */
@Repository
public interface UserMapper {
    /**
     * 插入一个用户
     * @param user  用户信息
     * @return      更新条数
     */
    int insertUser(User user);

    User selectUser(int id);
}
