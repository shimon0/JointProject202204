package com.example.jointDevelopment.controller;

import java.util.List;

import com.example.jointDevelopment.domain.JointUser;
import com.example.jointDevelopment.form.UserListForm;
import com.example.jointDevelopment.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userList")
public class UserListController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /** ユーザーデータ取得 */
    @GetMapping("/get/list")
    public List<JointUser> getUserList(UserListForm form){

        //formをUserに変換
        JointUser user=modelMapper.map(form, JointUser.class);

        //ユーザーデータ取得
        List<JointUser> userList=userService.getUsers(user);

        //ユーザーデータ送信
        return userList;
    }
}
