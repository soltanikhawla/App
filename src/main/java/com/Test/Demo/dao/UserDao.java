package com.Test.Demo.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Repository
public class UserDao {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "khawla",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("Role_Admin"))
            ),
            new User(
                    "user",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("Role_User"))
            )

    );
    public UserDetails findUserByLogin(String login)
    {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(login))
                .findFirst()
                .orElseThrow(()-> new UsernameNotFoundException("No user found with Login"));
    }
}
