package com.taocaicai.urlroles.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 04:13:4:13
 */

public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
