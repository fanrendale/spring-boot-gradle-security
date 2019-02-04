package com.xjf.springboot.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xjf
 * @date 2019/2/4 12:21
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
