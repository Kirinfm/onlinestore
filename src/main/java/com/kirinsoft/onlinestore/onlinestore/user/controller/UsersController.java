package com.kirinsoft.onlinestore.onlinestore.user.controller;

import com.kirinsoft.onlinestore.onlinestore.user.service.UserService;
import com.kirinsoft.onlinestore.onlinestore.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/currentUser")
    public UserVo getCurrentUser(@RequestParam String id) {
        return userService.getCurrentUser(id);
    }

    @PostMapping(value = "/api/login/account")
    public UserVo login(@RequestBody UserVo userVo) {
        return userService.getUser(userVo.getUserId(), userVo.getPassword());
    }
}
