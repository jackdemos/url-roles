package com.taocaicai.urlroles.dao;

import com.taocaicai.urlroles.entity.Role;
import com.taocaicai.urlroles.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:25:3:25
 */
@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getRolesById(Integer id);
}
