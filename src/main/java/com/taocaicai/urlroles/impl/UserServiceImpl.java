package com.taocaicai.urlroles.impl;

import com.taocaicai.urlroles.dao.UserMapper;
import com.taocaicai.urlroles.entity.Role;
import com.taocaicai.urlroles.entity.User;
import com.taocaicai.urlroles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:59:3:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }

    @Override
    public List<Role> getRolesById(Integer id) {
        return  userMapper.getRolesById(id);
    }
}
