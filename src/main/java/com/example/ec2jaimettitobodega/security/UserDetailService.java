package com.example.ec2jaimettitobodega.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class UserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if( "profesor".equals(username)) {
            return new User("profesor", "123", new ArrayList<>());
        }else
            throw new UsernameNotFoundException("Usuario no existe " + username);
    }
}
