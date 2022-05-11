package com.example.jointDevelopment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    
    /** セキュリティー各種設定 */
    @Override
    protected void configure(HttpSecurity http)throws Exception{

        //ログイン不要ページの設定
        http.authorizeRequests()
            .antMatchers("/signup").permitAll()  //直リンクOK
            .antMatchers("/login").permitAll()  //直リンクOK
            .antMatchers("/user/detail").permitAll()  //直リンクOK
            .antMatchers("/user/password").permitAll()  //直リンクOK
            .antMatchers("/user/delete").permitAll()  //直リンクOK
            .antMatchers("/userList/get/list").permitAll()  //直リンクOK
            .anyRequest().authenticated();  //それ以外直リンク禁止
            
        //ログイン処理
        http.formLogin()
            .loginProcessingUrl("/login")   //ログイン処理のパス
            .failureUrl("/login?error")
            .usernameParameter("userId")
            .passwordParameter("password")
            .defaultSuccessUrl("/user/list");
        
        //ログアウト
        http.logout()
            .logoutUrl("/logout").permitAll();

    }

    /** 認証の設定 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        //ユーザーデータで認証
        auth.userDetailsService(userDetailsService);
    }
    
}
