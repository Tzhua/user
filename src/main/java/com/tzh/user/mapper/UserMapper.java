package com.tzh.user.mapper;

import com.tzh.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据用户id，获取用户详情
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户id，修改信息
     * @param user
     * @return
     */
    int updateUserInfoById(User user);

    /**
     * 根据用户ID，删除用户
     * @param userId    用户id
     * @return
     */
    int deleteUserById(int userId);
}
