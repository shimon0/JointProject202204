package com.example.jointDevelopment.controller;

import com.example.jointDevelopment.domain.JointUser;
import com.example.jointDevelopment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserDetailController {
    
    @Autowired
    private UserService userService;

    /** ユーザー詳細情報取得 */
    @GetMapping("/detail")
    public JointUser getUser(@RequestParam("userId") String userId){

        //ユーザー1件取得
        JointUser user=userService.getUserOne(userId);

        return user;
    }

    /** パスワード更新 */
    @PostMapping("/password")
    public int updatePassword(@RequestParam("userId")String userId,@RequestParam("password")String password){
        try {
            //パスワード更新
            userService.updateUserOne(userId, password);
        } catch (Exception e) {
            //lombokのlogメゾット
            log.error("パスワード更新でエラー", e);
        }
        

        return 0;
    }

    /** ユーザー削除（1件） */
    @PostMapping("/delete")
    public int deleteUserOne(String userId){
        
        //削除処理
        userService.deleteUserOne(userId);

        return 0;
    }
}
