package com.fizz.spring.part9.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    public String encode(CharSequence charSequence) {
        return null;
    }

    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }

}
