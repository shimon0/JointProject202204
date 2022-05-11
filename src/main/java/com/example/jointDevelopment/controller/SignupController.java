package com.example.jointDevelopment.controller;

import com.example.jointDevelopment.domain.JointUser;
import com.example.jointDevelopment.form.SignupForm;
import com.example.jointDevelopment.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignupController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * 
     * @param form
     * @param bindingResult
     * @return success=0,failed=1
     */

    /** ユーザー登録処理 */
    @PostMapping("/signup")
    public int postSignup(@Validated SignupForm form,BindingResult bindingResult){
        
        //入力値チェック
        //入力errorの場合、error信号を送る
        if (bindingResult.hasErrors()) {
            return 1;
        }

        //formをUser classへ変換
        JointUser user=modelMapper.map(form, JointUser.class);

        //ユーザー登録
        userService.signup(user);

        //登録完了信号を送る
        return 0;
    }
}
