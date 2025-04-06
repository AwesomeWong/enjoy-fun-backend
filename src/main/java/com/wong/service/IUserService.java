package com.wong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wong.dto.LoginFormDTO;
import com.wong.dto.Result;
import com.wong.entity.User;

import javax.servlet.http.HttpSession;


public interface IUserService extends IService<User> {
    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();
}
