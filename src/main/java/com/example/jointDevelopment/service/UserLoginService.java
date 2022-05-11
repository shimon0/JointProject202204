package com.example.jointDevelopment.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jointDevelopment.domain.JointUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService{
    
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //ユーザー取得
        JointUser loginUser=userService.getLoginUser(username);

        //case:ユーザーが存在しない
        if (loginUser==null) {
            throw new UsernameNotFoundException("user not found");
        }

        //権限リスト
        //userのみの設定
        GrantedAuthority authority=new SimpleGrantedAuthority("user");
        List<GrantedAuthority> authorities=new ArrayList<>();

        authorities.add(authority);

        //UserDetails生成
        UserDetails userDetails=(UserDetails)new User(loginUser.getUserId(),loginUser.getPassword(),authorities);

        return userDetails;
    }
}
