package com.taocaicai.urlroles.service;

import com.taocaicai.urlroles.entity.Role;
import com.taocaicai.urlroles.entity.User;

import java.util.List;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:57:3:57
 */

public interface UserService {

    /**
     * 根据用户名获取一个用户
     * @return 用户信息
     */
    User loadUserByUsername(String username);

    /**
     * 根据用户id获取用户有效角色
     * @return 用户信息
     */
    List<Role> getRolesById(Integer id);

}
