package com.fizz.spring.part9.service;

import com.fizz.spring.part5.data.SpitterRespository;
import com.fizz.spring.part5.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SpitterUserService implements UserDetailsService {

    @Autowired
    private SpitterRespository spitterRespository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRespository.findByUsername(username);
        if (spitter != null) {
            List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
            authority.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(spitter.getUsername(), spitter.getPassword(), authority);
        }
        throw new UsernameNotFoundException("User: " + username + " Not Found");
    }

}
