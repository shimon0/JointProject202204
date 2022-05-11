package com.example.jointDevelopment.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupForm {
    @NotBlank
    private String userName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Min(4)
    @Max(16)
    private String password;
    private Date jointDate;
    private Integer age;
    private Integer gender;
    private Integer engineerKinds;
    private Integer experience;
    private String introduction;
}
