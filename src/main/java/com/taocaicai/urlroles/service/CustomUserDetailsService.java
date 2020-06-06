package com.taocaicai.urlroles.service;

import com.taocaicai.urlroles.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:24:3:24
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.loadUserByUsername(userName);
        if(user==null){
            throw  new UsernameNotFoundException("用户或密码错误");
        }
        user.setRoles(userService.getRolesById(user.getId()));
        return user;
    }
}
